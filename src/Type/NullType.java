package Type;

public class NullType extends NonArrayType {
    private static final NullType instance = new NullType();

    private NullType() {}

    static public NullType getInstance() {
        return instance;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        if (other == NullType.getInstance()) return true;
        if (other instanceof ArrayType) return true;
        if (other instanceof ClassType) return true;
        return false;
    }

    @Override
    public String getTypeName() {
        return "Null";
    }
}
