package Expression.Arithmetic;

import Constant.IntConstant;
import Constant.StringConstant;
import Expression.BaseExpression;
import Expression.FunctionExpression;
import Expression.IdentifierExpression;
import Type.BaseType;
import Type.IntType;
import Type.StringType;
import Error.CompilationError;

import java.util.List;
import java.util.Vector;

public class AdditionExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private AdditionExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
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
        if (firstType == IntType.getInstance() && secondType == IntType.getInstance()) {
            if (_firstExpression instanceof IntConstant && _secondExpression instanceof IntConstant) {
                return new IntConstant(((IntConstant) _firstExpression).getValue() + ((IntConstant) _secondExpression).getValue());
            }
            return new AdditionExpression(_firstExpression, _secondExpression);
        }
        if (firstType == StringType.getInstance() && secondType == StringType.getInstance()) {
            if (_firstExpression instanceof StringConstant && _secondExpression instanceof StringConstant) {
                return new StringConstant(((StringConstant) _firstExpression).getValue() + ((StringConstant) _secondExpression).getValue());
            }
            List<BaseExpression> expressionList = new Vector<>();
            expressionList.add(_firstExpression);
            expressionList.add(_secondExpression);
            return FunctionExpression.getExpression(IdentifierExpression.getExpression("_builtin_add"), expressionList);
        }
        throw new CompilationError("There is an invalid addition expression");
    }
}
