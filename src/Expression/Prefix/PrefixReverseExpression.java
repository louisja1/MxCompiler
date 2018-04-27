package Expression.Prefix;

import Expression.BaseExpression;
import Error.CompilationError;
import Type.IntType;

public class PrefixReverseExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixReverseExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no prefix reverse for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixReverseExpression(_objectExpression);
    }
}
