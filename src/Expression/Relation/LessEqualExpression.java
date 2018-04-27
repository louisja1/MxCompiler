package Expression.Relation;

import Constant.BoolConstant;
import Constant.IntConstant;
import Constant.StringConstant;
import Expression.BaseExpression;
import Expression.FunctionExpression;
import Expression.IdentifierExpression;
import Type.BaseType;
import Type.BoolType;
import Type.IntType;
import Type.StringType;
import Error.CompilationError;

import java.util.List;
import java.util.Vector;

public class LessEqualExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private LessEqualExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        super(BoolType.getInstance(), false);
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
                return new BoolConstant(((IntConstant) _firstExpression).getValue() <= ((IntConstant) _secondExpression).getValue());
            }
            return new LessEqualExpression(_firstExpression, _secondExpression);
        }
        if (firstType == StringType.getInstance() && secondType == StringType.getInstance()) {
            if (_firstExpression instanceof StringConstant && _secondExpression instanceof StringConstant) {
                return new BoolConstant(((StringConstant) _firstExpression).getValue().compareTo(((StringConstant) _secondExpression).getValue()) <= 0);
            }
            List<BaseExpression> expressionList = new Vector<>();
            expressionList.add(_firstExpression);
            expressionList.add(_secondExpression);
            return FunctionExpression.getExpression(IdentifierExpression.getExpression("_builtin_LEEQ"), expressionList);
        }
        throw new CompilationError("There is an invalid less equal expression");
    }
}
