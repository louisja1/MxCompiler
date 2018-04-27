package Statement;

import Error.CompilationError;
import Constructor.AST;

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
}
