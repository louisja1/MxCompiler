package Statement;

import Constant.BoolConstant;
import Expression.BaseExpression;
import Type.BoolType;
import Error.CompilationError;

public class ForStatement extends LoopStatement {
    private BaseExpression initiate, condition, variance;
    private BaseStatement statement;

    public ForStatement() {
        this.initiate = null;
        this.condition = new BoolConstant(true);
        this.variance = null;
        this.statement = null;
    }

    public void addInitiate(BaseExpression _initiate) {
        this.initiate = _initiate;
    }

    public void addCondition(BaseExpression _condition) {
        if (!(_condition.getType() == BoolType.getInstance())) {
            throw new CompilationError("The condition expression of for statement is not a bool type");
        }
        this.condition = _condition;
    }

    public void addVariance(BaseExpression _variance) {
        this.variance = _variance;
    }

    public void addStatement(BaseStatement _statement) {
        this.statement = _statement;
    }

    public BaseExpression getCondition() {
        return condition;
    }

    public BaseExpression getInitiate() {
        return initiate;
    }

    public BaseExpression getVariance() {
        return variance;
    }

    public BaseStatement getStatement() {
        return statement;
    }

    @Override
    public String getName() {
        return null;
    }
}
