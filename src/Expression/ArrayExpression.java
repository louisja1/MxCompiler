package Expression;

import Type.ArrayType;
import Type.BaseType;
import Error.CompilationError;
import Type.IntType;

public class ArrayExpression extends BaseExpression {
    private BaseExpression arrayExpression;
    private BaseExpression indexExpression;

    private ArrayExpression(BaseType arrayType, BaseExpression _arrayExpression, BaseExpression _indexExpression) {
        // the array type with dimension
        super(arrayType, _arrayExpression.isLeftValue());
        this.arrayExpression = _arrayExpression;
        this.indexExpression = _indexExpression;
    }

    public BaseExpression getArrayExpression() {
        return arrayExpression;
    }

    public BaseExpression getIndexExpression() {
        return indexExpression;
    }

    public static BaseExpression getExpression(BaseExpression arrayExpression, BaseExpression indexExpression) {
        if (!(arrayExpression.getType() instanceof ArrayType)) {
            throw new CompilationError("The array expression is not of array type");
        }
        if (indexExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("The index expression is not of int type");
        }
        return new ArrayExpression(((ArrayType) arrayExpression.getType()).reduceDimension(), arrayExpression, indexExpression);
    }
}
