package Statement;

import Expression.BaseExpression;

public class ExpressionStatement extends BaseStatement {
    private BaseExpression expression;

    public ExpressionStatement(BaseExpression _expression) {
        this.expression = _expression;
    }

    public BaseExpression getExpression() {
        return expression;
    }
}
