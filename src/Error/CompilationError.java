package Error;

import Constructor.PositionListener;

public class CompilationError extends Error {
    public CompilationError(String message) {
        super("Compilation Error : [" + PositionListener.row + ":" + PositionListener.col + "] " + message + ".");
    }
}
