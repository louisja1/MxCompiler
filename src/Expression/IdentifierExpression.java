package Expression;

import Constructor.AST;
import SymbolTable.Symbol;
import Error.CompilationError;
import Type.BaseType;
import Type.ClassType;
import Type.FunctionType;

public class IdentifierExpression extends BaseExpression {
    private Symbol symbol;
    private IdentifierExpression(Symbol _symbol, boolean leftValue) {
        super(_symbol.getType(), leftValue);
        this.symbol = _symbol;
    }
    public Symbol getSymbol() {
        return symbol;
    }
    public static BaseExpression getExpression(String idname) {
        if (!AST.symbolTable.existSymbol(idname)) {
            throw new CompilationError("There is not an identifier named [" + idname + "] in this scope");
        }
        Symbol currentSymbol = AST.symbolTable.getSymbol(idname);
        BaseType currentType = currentSymbol.getType();
        if (currentSymbol.classScope instanceof ClassType) {
            return MemberExpression.getExpression(IdentifierExpression.getExpression("this"), idname);
        } else {
            return new IdentifierExpression(currentSymbol, !(currentType instanceof FunctionType));
        }
    }

}
