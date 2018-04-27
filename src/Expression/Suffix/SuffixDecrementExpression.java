package Expression.Suffix;

import Expression.BaseExpression;
import Type.IntType;
import Error.CompilationError;

public class SuffixDecrementExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private SuffixDecrementExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no suffix decrement for [" + _objectExpression.getType().toString() + "]");
        }
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("Object should be a left-value for suffix increment");
        }
        return new SuffixDecrementExpression(_objectExpression);
    }
}
