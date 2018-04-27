package Expression.Prefix;

import Expression.BaseExpression;
import Error.CompilationError;
import Type.BoolType;

public class PrefixNotExpression extends BaseExpression{
    private BaseExpression objectExpression;

    private PrefixNotExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != BoolType.getInstance()) {
            throw new CompilationError("There is no prefix not for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixNotExpression(_objectExpression);
    }
}
