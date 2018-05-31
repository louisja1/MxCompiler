package AST.Type;

public class BoolType extends NonArrayType {
    private static final BoolType instance = new BoolType();

    private BoolType() {}

    static public BoolType getInstance() {
        return instance;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        return other == BoolType.getInstance();
    }

    @Override
    public String getTypeName() {
        return "Bool";
    }
}
