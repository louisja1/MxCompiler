package AST.Expression;

import AST.Constructor.AST;
import AST.SymbolTable.Symbol;
import Error.CompilationError;
import AST.Type.BaseType;
import AST.Type.ClassType;
import AST.Type.FunctionType;
import IR.Instruction.BaseInstruction;

import java.util.List;

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
            return new IdentifierExpression(currentSymbol, !(currentType instanceof FunctionType || idname == "this"));
        }
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(symbol.operand);
    }
}
