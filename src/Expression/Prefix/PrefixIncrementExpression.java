package Expression.Prefix;

import Expression.BaseExpression;
import Type.IntType;
import Error.CompilationError;

public class PrefixIncrementExpression extends BaseExpression {
    private BaseExpression objecteExpression;

    private PrefixIncrementExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), true);
        this.objecteExpression = _objectExpression;
    }

    public BaseExpression getObjecteExpression() {
        return objecteExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no suffix increment for [" + _objectExpression.getType().toString() + "]");
        }
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("Object should be a left-value for prefix increment");
        }
        return new PrefixIncrementExpression(_objectExpression);
    }
}
