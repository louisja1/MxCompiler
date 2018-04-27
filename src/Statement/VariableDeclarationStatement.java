package Statement;

import Expression.BaseExpression;
import Type.BaseType;
import Type.ClassType;
import SymbolTable.Symbol;
import Error.CompilationError;

public class VariableDeclarationStatement extends BaseStatement {
    private BaseType type;
    private String name;
    private BaseExpression expression;
    private ClassType classScope;
    private Symbol symbol;

    public VariableDeclarationStatement(BaseType _type, String _name) {
        this.type = _type;
        this.name = _name;
        this.expression = null;
        this.classScope = null;
        this.symbol = new Symbol(_name, _type);
    }

    public void addExpression(BaseExpression expression) {
        if (!type.beCompatibleWith(expression.getType())) {
            throw new CompilationError("variable declaration with incompatible type");
        }
        this.expression = expression;
    }

    public void addClassScope(ClassType _classScope) {
        this.classScope = _classScope;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public BaseType getType() {
        return type;
    }

    public BaseExpression getExpression() {
        return expression;
    }

    public ClassType getClassScope() {
        return classScope;
    }
}
