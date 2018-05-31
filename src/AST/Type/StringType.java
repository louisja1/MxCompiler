package AST.Type;

public class StringType extends NonArrayType {
    private static final StringType instance = new StringType();

    private StringType() {}

    static public StringType getInstance() {
        return instance;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        return other == StringType.getInstance();
    }

    @Override
    public String getTypeName() {
        return "String";
    }
}
