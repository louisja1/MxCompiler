package AST.Constructor;

import Parser.MxStarBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class PositionListener extends MxStarBaseListener {
    public static int row, col;
    static ParseTreeProperty<Object> map = new ParseTreeProperty<>();

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        this.row = ctx.getStart().getLine();
        this.col = ctx.getStart().getCharPositionInLine();
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        this.row = ctx.getStart().getLine();
        this.col = ctx.getStart().getCharPositionInLine();
    }
}
