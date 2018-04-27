package Statement;

import Constant.BoolConstant;
import Expression.BaseExpression;

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
