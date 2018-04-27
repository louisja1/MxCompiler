package Expression.Logic;

import Constant.BoolConstant;
import Expression.BaseExpression;
import Type.BaseType;
import Type.BoolType;
import Error.CompilationError;

public class LogicOrExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private LogicOrExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        super(_firstExpression.getType(), false);
        this.firstExpression = _firstExpression;
        this.secondExpression = _secondExpression;
    }

    public BaseExpression getFirstExpression() {
        return firstExpression;
    }

    public BaseExpression getSecondExpression() {
        return secondExpression;
    }

    public static BaseExpression getExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        BaseType firstType = _firstExpression.getType();
        BaseType secondType = _secondExpression.getType();
        if (firstType == BoolType.getInstance() && secondType == BoolType.getInstance()) {
            if (_firstExpression instanceof BoolConstant && _secondExpression instanceof BoolConstant) {
                return new BoolConstant(((BoolConstant) _firstExpression).getValue() || ((BoolConstant) _secondExpression).getValue());
            }
            return new LogicOrExpression(_firstExpression, _secondExpression);
        }
        throw new CompilationError("There is an invalid logic or expression");
    }
}
