package Type;

public class IntType extends NonArrayType {
    private static final IntType instance = new IntType();

    private IntType() {}

    static public IntType getInstance() {
        return instance;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        return other == IntType.getInstance();
    }

    @Override
    public String getTypeName() {
        return "Int";
    }
}
