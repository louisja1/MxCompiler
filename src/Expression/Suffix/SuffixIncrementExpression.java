package Expression.Suffix;

import Expression.BaseExpression;
import Type.IntType;
import Error.CompilationError;

public class SuffixIncrementExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private SuffixIncrementExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no suffix increment for [" + _objectExpression.getType().toString() + "]");
        }
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("Object should be a left-value for suffix increment");
        }
        return new SuffixIncrementExpression(_objectExpression);
    }
}
