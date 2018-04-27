package Expression;

import Error.CompilationError;

public class AssignExpression extends BaseExpression {
    private BaseExpression objectExpression;
    private BaseExpression valueExpression;

    private AssignExpression(BaseExpression _objectExpression, BaseExpression _valueExpression) {
        super(_objectExpression.getType(), true);
        this.objectExpression = _objectExpression;
        this.valueExpression = _valueExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public BaseExpression getValueExpression() {
        return valueExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression, BaseExpression _valueExpression) {
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("The object expression is not a left value");
        }
        if (!_objectExpression.getType().beCompatibleWith(_valueExpression.getType())) {
            throw new CompilationError("The objective expression is incompatible with value expression");
        }
        return new AssignExpression(_objectExpression, _valueExpression);
    }
}
