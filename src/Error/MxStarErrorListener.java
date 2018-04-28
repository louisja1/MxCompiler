package Error;

import Constructor.PositionListener;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MxStarErrorListener extends BaseErrorListener {
    private static final MxStarErrorListener instance = new MxStarErrorListener();
    static public MxStarErrorListener getInstance() {
        return instance;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        PositionListener.row = line;
        PositionListener.col = charPositionInLine;
        throw new CompilationError(msg);
    }
}
