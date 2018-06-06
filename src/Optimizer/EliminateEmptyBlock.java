package Optimizer;

import IR.Block;
import IR.FunctionIR;
import IR.Instruction.BaseInstruction;
import IR.Instruction.CjumpInstruction;
import IR.Instruction.JumpInstruction;

public class EliminateEmptyBlock {
    public static void eliminateEmptyBlock(FunctionIR functionIR) {
        for (int i = 0; i < functionIR.blockList.size() - 1; i++) {
            Block block = functionIR.blockList.get(i);
            if (block.instructionList.size() > 0) continue;
            Block nxt = functionIR.blockList.get(i + 1);
            for (int j = 0; j < i; j++) {
                Block pre = functionIR.blockList.get(j);
                for (int k = 0; k < pre.instructionList.size(); k++) {
                    BaseInstruction instruction = pre.instructionList.get(k);
                    if (instruction instanceof JumpInstruction && ((JumpInstruction) instruction).target == block.labelInstruction) {
                        ((JumpInstruction) instruction).modifyTarget(nxt.labelInstruction);
                    }
                    if (instruction instanceof CjumpInstruction && ((CjumpInstruction) instruction).target == block.labelInstruction) {
                        ((CjumpInstruction) instruction).modifyTarget(nxt.labelInstruction);
                    }
                }
            }
            functionIR.blockList.remove(i);
            i --;
        }
    }
}
