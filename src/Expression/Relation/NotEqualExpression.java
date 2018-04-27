package Expression.Relation;

import Constant.BoolConstant;
import Constant.IntConstant;
import Constant.NullConstant;
import Constant.StringConstant;
import Expression.BaseExpression;
import Expression.FunctionExpression;
import Expression.IdentifierExpression;
import Type.BaseType;
import Type.BoolType;
import Type.StringType;
import Error.CompilationError;

import java.util.List;
import java.util.Vector;

public class NotEqualExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private NotEqualExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
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
        if (!firstType.beCompatibleWith(secondType)) {
            throw new CompilationError("There is a pair of unmatched expression for not equal expression");
        }
        if (_firstExpression instanceof BoolConstant && _secondExpression instanceof BoolConstant) {
            return new BoolConstant(((BoolConstant) _firstExpression).getValue() != ((BoolConstant) _secondExpression).getValue());
        }
        if (_firstExpression instanceof IntConstant && _secondExpression instanceof IntConstant) {
            return new BoolConstant(((IntConstant) _firstExpression).getValue() != ((IntConstant) _secondExpression).getValue());
        }
        if (_firstExpression instanceof NullConstant && _secondExpression instanceof NullConstant) {
            return new BoolConstant(false);
        }
        if (_firstExpression instanceof StringConstant && _secondExpression instanceof StringConstant) {
            return new BoolConstant(!((StringConstant) _firstExpression).getValue().equals(((StringConstant) _secondExpression).getValue()));
        }
        if (firstType == StringType.getInstance() && secondType == StringType.getInstance()) {
            List<BaseExpression> expressionList = new Vector<>();
            expressionList.add(_firstExpression);
            expressionList.add(_secondExpression);
            return FunctionExpression.getExpression(IdentifierExpression.getExpression("_builtin_NEQ"), expressionList);
        }
        return new NotEqualExpression(_firstExpression, _secondExpression);
    }
}
