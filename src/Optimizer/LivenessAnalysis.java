package Optimizer;

import IR.Block;
import IR.FunctionIR;
import IR.Instruction.BaseInstruction;
import IR.Instruction.CjumpInstruction;
import IR.Instruction.JumpInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.VirtualRegister;
import Error.RuntimeError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LivenessAnalysis {
    public static Map<VirtualRegister, Set<VirtualRegister>> conflictEdge;
    public static Map<VirtualRegister, Set<VirtualRegister>> moveEdge;
    public static Map<VirtualRegister, Integer> virtualRegisterWithTimes;
    private static FunctionIR currentFunction;

    public static void livenessAnalysis(FunctionIR _currentFunction) {
        currentFunction = _currentFunction;
        conflictEdge = new HashMap<>();
        moveEdge = new HashMap<>();
        virtualRegisterWithTimes = new HashMap<>();

        blockAnalysis();
        instructionAnalysis();
    }

    private static void blockAnalysis() {
        Block lst = null;
        for (Block block : currentFunction.blockList) {
            block.useSet = new HashSet<>();
            block.defSet = new HashSet<>();
            block.liveIn = new HashSet<>();
            block.liveOut = new HashSet<>();
            if (lst != null && !lst.haveJumpInstruction) {
                addEdge(lst, block);
            }
            lst = block;
            for (BaseInstruction instruction : block.instructionList) {
                instruction.liveIn = new HashSet<>();
                instruction.liveOut = new HashSet<>();
                for (VirtualRegister reg : instruction.useSet) {
                    if (isTemporaryVariable(reg) && !conflictEdge.containsKey(reg)) {
                        conflictEdge.put(reg, new HashSet<>());
                    }
                }
                for (VirtualRegister reg : instruction.defSet) {
                    if (isTemporaryVariable(reg) && !conflictEdge.containsKey(reg)) {
                        conflictEdge.put(reg, new HashSet<>());
                    }
                }
            }
            int id = 0;
            for (BaseInstruction instruction : block.instructionList) {
                for (VirtualRegister reg : instruction.useSet) {
                    if (isTemporaryVariable(reg) && !block.defSet.contains(reg)) {
                        block.useSet.add(reg);
                    }
                }
                for (VirtualRegister reg : instruction.defSet) {
                    block.defSet.add(reg);
                }
                if (instruction instanceof CjumpInstruction) {
                    if (id != block.instructionList.size() - 2) {
                        throw new RuntimeError("Cjump error");
                    }
                    addEdge(block, ((CjumpInstruction) instruction).target.block);
                }
                if (instruction instanceof JumpInstruction) {
                    if (id != block.instructionList.size() - 1) {
                        throw new RuntimeError("Jump error");
                    }
                    addEdge(block, ((JumpInstruction) instruction).target.block);
                }
                id ++;
            }
            block.liveIn = new HashSet<>(block.useSet);
        }
        boolean flag = true;
        while (flag) {
            flag = false;
            for (Block block : currentFunction.blockList) {
                if (updateLiveIn(block)) {
                    flag = true;
                }
                if (updateLiveOut(block)) {
                    flag = true;
                }
            }
        }
    }

    private static void instructionAnalysis() {
        for (Block block : currentFunction.blockList) {
            for (int i = block.instructionList.size() -  1; i >= 0; i--) {
                BaseInstruction instruction = block.instructionList.get(i);
                if (instruction instanceof JumpInstruction) {
                    if (i != block.instructionList.size() - 1) {
                        throw new RuntimeError("Jump error");
                    }
                    instruction.liveOut = new HashSet<>(((JumpInstruction) instruction).target.block.liveIn);
                } else if (instruction instanceof CjumpInstruction) {
                    if (i != block.instructionList.size() - 2) {
                        throw new RuntimeError("Cjump error");
                    }
                    instruction.liveOut = new HashSet<>(((CjumpInstruction) instruction).target.block.liveIn);
                    JumpInstruction next = (JumpInstruction) block.instructionList.get(i + 1);
                    UnionSet(instruction.liveOut, next.liveIn);
                } else if (i < block.instructionList.size() - 1){
                    UnionSet(instruction.liveOut, block.instructionList.get(i + 1).liveIn);
                }
                updateLiveIn(instruction);
                for (VirtualRegister reg1 : instruction.defSet) {
                    for (VirtualRegister reg2 : instruction.liveOut) {
                        if (!(instruction instanceof MoveInstruction) || !instruction.useSet.contains(reg2)) {
                            addConflictEdge(reg1, reg2);
                        }
                    }
                }

            }
        }
    }

    private static boolean isTemporaryVariable(VirtualRegister reg) {
        if (reg.global || currentFunction.idMap.containsKey(reg)) {
            return false;
        }
        return true;
    }

    private static void addEdge(Block x, Block y) {
        if (x == y) return;
        x.blockOut.add(y);
        y.blockIn.add(x);
    }

    private static boolean updateLiveIn(Block block) {
        boolean flag = false;
        for (VirtualRegister reg : block.liveOut) {
            if (!block.defSet.contains(reg) && !block.liveIn.contains(reg)) {
                block.liveIn.add(reg);
                flag = true;
            }
        }
        return flag;
    }

    private static boolean updateLiveOut(Block block) {
        boolean flag = false;
        for (Block succ : block.blockOut) {
            for (VirtualRegister reg : succ.liveIn) {
                if (!block.liveOut.contains(reg)) {
                    block.liveOut.add(reg);
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static void UnionSet(Set<VirtualRegister> A, Set<VirtualRegister> B) {
        for (VirtualRegister reg : B) {
            if (isTemporaryVariable(reg) && !A.contains(reg)) {
                A.add(reg);
            }
        }
    }

    private static void updateLiveIn(BaseInstruction instruction) {
        instruction.liveIn = new HashSet<>(instruction.useSet);
        for (VirtualRegister reg : instruction.liveOut) {
            if (isTemporaryVariable(reg) && !instruction.liveIn.contains(reg) && !instruction.defSet.contains(reg)) {
                instruction.liveIn.add(reg);
            }
        }
    }

    private static void addConflictEdge(VirtualRegister x, VirtualRegister y) {
        if (x == y) return;
        if (!isTemporaryVariable(x)) return;
        if (!isTemporaryVariable(y)) return;
        conflictEdge.get(x).add(y);
        conflictEdge.get(y).add(x);
    }

}