package AST.Type;

public class VoidType extends NonArrayType {
    private static final VoidType instance = new VoidType();

    private VoidType() {}

    static public VoidType getInstance() {
        return instance;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        return false;
    }

    @Override
    public String getTypeName() {
        return "Void";
    }
}
