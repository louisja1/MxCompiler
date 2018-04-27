package Expression;

import Type.ArrayType;
import Type.BaseType;
import Type.ClassType;
import Error.CompilationError;
import Type.NonArrayType;

import java.beans.Expression;
import java.util.List;

public class NewExpression extends BaseExpression {
    private List<BaseExpression> expressions;

    private NewExpression(BaseType type, List<BaseExpression> _expressions) {
        super(type, false);
        this.expressions = _expressions;
    }

    public static BaseExpression getExpression(BaseType _type, List<BaseExpression> _expressions) {
        int size = _expressions.size();
        if (size == 0) {
            //new type;
            if (!(_type instanceof ClassType)) {
                throw new CompilationError("It is forbidden to new a [" + _type.getTypeName() + "] type");
            }
            return new NewExpression(_type, _expressions);
        } else {
            //new type [][]
            boolean first = true;
            boolean acceptive = true;
            boolean restarenull = false;
            for (BaseExpression expression : _expressions) {
                if (first == true) {
                    first = false;
                    if (expression == null) {
                        acceptive = false;
                        break;
                    }
                }
                if (restarenull) {
                    if (expression != null) {
                        acceptive = false;
                        break;
                    }
                } else {
                    if (expression == null) {
                        restarenull = true;
                    }
                }
            }
            if (acceptive == false) {
                throw new CompilationError("It is an error format for new array expression");
            }
            BaseType current = new ArrayType((NonArrayType) _type, size);
            return new NewExpression(current, _expressions);
        }
    }
}
