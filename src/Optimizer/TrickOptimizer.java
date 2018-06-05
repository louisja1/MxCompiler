package Optimizer;

import IR.Block;
import IR.FunctionIR;
import IR.Instruction.MoveInstruction;
import IR.Operand.VirtualRegister;

public class TrickOptimizer {
    public static void eliminateUselessMoveInstruction(FunctionIR functionIR) {
        for (Block block : functionIR.blockList) {
            for (int i = 0; i < block.instructionList.size() - 1; i++) {
                if (!(block.instructionList.get(i + 1) instanceof MoveInstruction)) {
                    i += 2;
                    continue;
                }
                if (!(block.instructionList.get(i) instanceof MoveInstruction)) {
                    i += 1;
                    continue;
                }
                MoveInstruction pre = (MoveInstruction) block.instructionList.get(i);
                MoveInstruction suf = (MoveInstruction) block.instructionList.get(i + 1);
                if (pre.target instanceof VirtualRegister && pre.target == suf.source && !(suf.liveOut.contains(pre.target))) {
                    pre.modifyTarget(suf.target);
                    block.instructionList.remove(i + 1);
                }
            }
        }
    }
}
