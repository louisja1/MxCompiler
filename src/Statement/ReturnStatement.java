package Statement;

import Constructor.AST;
import Expression.BaseExpression;
import Type.FunctionType;
import Error.CompilationError;
import Type.VoidType;

public class ReturnStatement extends BrunchStatement {
    private FunctionType function;
    private BaseExpression expression;

    public ReturnStatement(BaseExpression _expression) {
        FunctionType currentFunction = AST.symbolTable.getCurrentFunction();
        if (currentFunction == null) {
            throw new CompilationError("the return statement should belongs to a function ");
        }
        if (currentFunction.getRawName() == null) {
            // construction function
            if (_expression != null) {
                throw new CompilationError("the construction function should not have a return statement");
            }
        } else {
            if (currentFunction.getReturnType() != VoidType.getInstance() && _expression == null) {
                throw new CompilationError("the void function should not have a return expression");
            }
            if (_expression != null && !_expression.getType().beCompatibleWith(currentFunction.getReturnType())) {
                throw new CompilationError("the return expression should be compatible with function return type");
            }
        }
        this.function = currentFunction;
        this.expression = _expression;
    }

    public BaseExpression getExpression() {
        return expression;
    }

    public FunctionType getFunction() {
        return function;
    }
}
