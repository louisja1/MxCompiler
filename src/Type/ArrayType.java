package Type;

import Error.CompilationError;

public class ArrayType extends BaseType {
    private int dimension;
    private NonArrayType baseType;

    public ArrayType(NonArrayType _baseType, int _dimension) {
        if (_baseType == VoidType.getInstance()) {
            throw new CompilationError("The base type of array is not permitted");
        }
        dimension = _dimension;
        baseType = _baseType;
    }

    public NonArrayType getBaseType() {
        return baseType;
    }

    public int getDimension() {
        return dimension;
    }

    public BaseType reduceDimension() {
        if (dimension == 1) {
            return baseType;
        } else {
            return new ArrayType(baseType, dimension - 1);
        }
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        if (other == NullType.getInstance()) {
            return true;
        }
        if ((other instanceof ArrayType) && (baseType.beCompatibleWith(((ArrayType) other).getBaseType())) && (dimension == ((ArrayType) other).getDimension())) {
            return true;
        }
        return false;
    }

    @Override
    public String getTypeName() {
        return "Array";
    }
}
