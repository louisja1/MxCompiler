package AST.Statement;

import Error.CompilationError;
import AST.Constructor.AST;
import IR.Instruction.BaseInstruction;
import IR.Instruction.JumpInstruction;

import java.util.List;

public class ContinueStatement extends BrunchStatement {
    private LoopStatement loop;

    public ContinueStatement() {
        LoopStatement _currentLoop = AST.symbolTable.getCurrentLoop();
        if (_currentLoop == null) {
            throw new CompilationError("The continue statement should belong to a loop statement");
        }
        this.loop = _currentLoop;
    }

    public LoopStatement getLoop() {
        return loop;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        instructionList.add(new JumpInstruction(loop.loopNextLabel));
    }
}
