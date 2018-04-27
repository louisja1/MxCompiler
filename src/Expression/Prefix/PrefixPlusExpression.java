package Expression.Prefix;

import Expression.BaseExpression;
import Error.CompilationError;
import Type.IntType;

public class PrefixPlusExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixPlusExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no prefix plus for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixPlusExpression(_objectExpression);
    }
}
