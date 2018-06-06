package Optimizer;

import IR.FunctionIR;
import IR.IR;

public class Optimizer {
    public static void optimize() {
        for (FunctionIR functionIR : IR.functionMap.values()) {
            //LivenessAnalysis.livenessAnalysis(functionIR);
            //TrickOptimizer.eliminateUselessMoveInstruction(functionIR);
            EliminateUselessLoop.eliminateUselessLoop(functionIR);
            EliminateEmptyBlock.eliminateEmptyBlock(functionIR);
            LivenessAnalysis.livenessAnalysis(functionIR);
            RegisterAllocater.registerAllocate(functionIR, LivenessAnalysis.conflictEdge);
            EliminateUselessJump.eliminateUselessJump(functionIR);
        }
    }
}
