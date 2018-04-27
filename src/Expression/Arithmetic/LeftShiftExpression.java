package Expression.Arithmetic;

import Constant.IntConstant;
import Expression.BaseExpression;
import Type.BaseType;
import Type.IntType;
import Error.CompilationError;

public class LeftShiftExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private LeftShiftExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        super(IntType.getInstance(), false);
        this.firstExpression = _firstExpression;
        this.secondExpression = _secondExpression;
    }

    public BaseExpression getSecondExpression() {
        return secondExpression;
    }

    public BaseExpression getFirstExpression() {
        return firstExpression;
    }

    public static BaseExpression getExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        BaseType firstType = _firstExpression.getType();
        BaseType secondType = _secondExpression.getType();
        if (firstType == IntType.getInstance() && secondType == IntType.getInstance()) {
            if (_firstExpression instanceof IntConstant && _secondExpression instanceof IntConstant) {
                return new IntConstant(((IntConstant) _firstExpression).getValue() << ((IntConstant) _secondExpression).getValue());
            }
            return new LeftShiftExpression(_firstExpression, _secondExpression);
        }
        throw new CompilationError("There is an invalid left shift expression");
    }
}
