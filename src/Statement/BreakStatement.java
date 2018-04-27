package Statement;

import Constructor.AST;
import Error.CompilationError;

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
}
