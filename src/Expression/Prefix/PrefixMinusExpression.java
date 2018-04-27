package Expression.Prefix;

import Expression.BaseExpression;
import Type.IntType;
import Error.CompilationError;

public class PrefixMinusExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixMinusExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no prefix minus for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixMinusExpression(_objectExpression);
    }
}
