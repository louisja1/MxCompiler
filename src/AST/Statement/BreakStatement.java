package AST.Statement;

import AST.Constructor.AST;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.JumpInstruction;

import java.util.List;

public class BreakStatement extends BrunchStatement {
    private LoopStatement loop;

    public BreakStatement() {
        LoopStatement _currentLoop = AST.symbolTable.getCurrentLoop();
        if (_currentLoop == null) {
            throw new CompilationError("The break statement should belong to a loop statement");
        }
        this.loop = _currentLoop;
    }

    public LoopStatement getLoop() {
        return loop;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        instructionList.add(new JumpInstruction(loop.loopExitLabel));
    }
}
