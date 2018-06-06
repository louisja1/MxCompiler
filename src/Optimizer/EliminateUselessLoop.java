package Optimizer;

import IR.Block;
import IR.FunctionIR;
import IR.Instruction.BaseInstruction;
import IR.Operand.VirtualRegister;


public class EliminateUselessLoop {
    public static void eliminateUselessLoop(FunctionIR functionIR) {
        LivenessAnalysis.livenessAnalysis(functionIR);
        for (int i = 0; i < functionIR.blockList.size(); i++) {
            Block block = functionIR.blockList.get(i);
            if (!block.labelInstruction.isLoopEntry) continue;
            int endPos = -1;
            for (int j = i + 1; j < functionIR.blockList.size(); j++) {
                if (functionIR.blockList.get(j).labelInstruction == block.labelInstruction.loopExit) {
                    endPos = j;
                }
            }
            if (endPos == -1) continue;
            Block endBlock = functionIR.blockList.get(endPos);
            boolean flag = true;
            for (int ii = i; ii < endPos; ii ++) {
                Block cur = functionIR.blockList.get(ii);
                for (int jj = 0; jj < cur.instructionList.size(); jj++) {
                    BaseInstruction instruction = cur.instructionList.get(jj);
                    if (instruction.isNotAllowedToEliminate()) {
                        flag = false;
                        break;
                    }
                    for (VirtualRegister reg : instruction.defSet) {
                        if (endBlock.liveOut.contains(reg) || endBlock.useSet.contains(reg)) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                if (!flag) break;
            }
            if (flag) {
                for (int ii = i; ii < endPos; ii++) {
                    functionIR.blockList.get(ii).instructionList.clear();
                }
            }
            i = endPos;
        }
    }
}
