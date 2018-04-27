package Statement;

import Constant.BoolConstant;
import Expression.BaseExpression;
import Type.BoolType;
import Error.CompilationError;

public class WhileStatement extends LoopStatement {
    private BaseExpression condition;
    private BaseStatement statement;

    public WhileStatement() {
        this.condition = new BoolConstant(true);
        this.statement = null;
    }

    public void addCondition(BaseExpression _condition) {
        if (!(_condition.getType() instanceof BoolType)) {
            throw new CompilationError("The condition of while statement should be boolean");
        }
        this.condition = _condition;
    }

    public void addStatement(BaseStatement _statement) {
        this.statement = _statement;
    }

    public BaseStatement getStatement() {
        return statement;
    }

    public BaseExpression getCondition() {
        return condition;
    }

    @Override
    public String getName() {
        return null;
    }
}
