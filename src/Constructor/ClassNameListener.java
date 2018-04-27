package Constructor;

import Parser.MxStarParser;
import Type.ClassType;

public class ClassNameListener extends PositionListener {
    @Override
    public void exitClassDeclaration(MxStarParser.ClassDeclarationContext ctx) {
        String name = ctx.Identifier().getText();
        AST.globalClass.addClass(name, new ClassType(name));
        map.put(ctx, AST.globalClass.getClassType(name));
    }
}
