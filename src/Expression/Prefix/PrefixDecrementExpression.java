package Expression.Prefix;

import Expression.BaseExpression;
import Type.IntType;
import Error.CompilationError;

public class PrefixDecrementExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixDecrementExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), true);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no prefix decrement for [" + _objectExpression.getType().toString() + "]");
        }
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("Object should be a left-value for prefix decrement");
        }
        return new PrefixDecrementExpression(_objectExpression);
    }
}
