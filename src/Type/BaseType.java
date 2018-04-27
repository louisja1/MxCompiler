package Type;

public abstract class BaseType {
    public abstract boolean beCompatibleWith(BaseType other);
    public abstract String getTypeName();
}
