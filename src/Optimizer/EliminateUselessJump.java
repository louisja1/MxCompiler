package Optimizer;

import IR.Block;
import IR.FunctionIR;
import IR.Instruction.BaseInstruction;
import IR.Instruction.JumpInstruction;

public class EliminateUselessJump {
    public static void eliminateUselessJump(FunctionIR functionIR) {
        for (int i = 0; i < functionIR.blockList.size() - 1; i++) {
            Block block = functionIR.blockList.get(i);
            if (block.instructionList.isEmpty()) continue;
            Block nextBlock = functionIR.blockList.get(i + 1);
            int size = block.instructionList.size();
            BaseInstruction instruction = block.instructionList.get(size - 1);
            if (instruction instanceof JumpInstruction && ((JumpInstruction) instruction).target.block == nextBlock) {
                functionIR.blockList.get(i).instructionList.remove(size - 1);
            }
        }
    }
}
