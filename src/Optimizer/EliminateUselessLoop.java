package Optimizer;

import IR.Block;
import IR.FunctionIR;
import IR.Instruction.BaseInstruction;
import IR.Instruction.LabelInstruction;
import IR.Operand.VirtualRegister;

import java.util.List;
import java.util.Vector;

public class EliminateUselessLoop {
    public static void eliminateUselessLoop(FunctionIR functionIR) {
        List<BaseInstruction> instructionList = new Vector<>();
        LivenessAnalysis.livenessAnalysis(functionIR);
        for (int i = 0; i < functionIR.blockList.size(); i++) {
            Block block = functionIR.blockList.get(i);
            instructionList.addAll(block.instructionList);
        }
        for (int i = 0; i < instructionList.size(); i++) {
            BaseInstruction instruction = instructionList.get(i);
            if (instruction instanceof LabelInstruction && ((LabelInstruction) instruction).isLoopEntry) {
                LabelInstruction exit = ((LabelInstruction) instruction).loopExit;
                boolean flag = true;
                int cnt = 1;
                for (int j = i + 1; j < instructionList.size(); j++) {
                    BaseInstruction cur = instructionList.get(j);
                    ++ cnt;
                    if (((LabelInstruction) cur) == exit) {
                        break;
                    }
                    if (cur.isNotAllowedToEliminate()) {
                        flag = false;
                        break;
                    }
                    for (VirtualRegister reg : cur.defSet) {
                        if (exit.liveOut.contains(reg)) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                if (flag) {
                    //System.out.println("hahahahaha");
                    boolean toEliminate = false;
                    for (int ii = 0; ii < functionIR.blockList.size(); ii++) {
                        Block curBlock = functionIR.blockList.get(ii);
                        for (int jj = 0; jj < curBlock.instructionList.size(); jj++) {
                            BaseInstruction curInstruction = curBlock.instructionList.get(jj);
                            if (curInstruction == instruction) {
                                toEliminate = true;
                            }
                            if (toEliminate && cnt > 0) {
                                functionIR.blockList.get(ii).instructionList.remove(jj);
                                jj --;
                                cnt --;
                            }
                            if (cnt == 0) break;
                        }
                        if (cnt == 0) break;
                    }
                }
            }
        }
    }
}
