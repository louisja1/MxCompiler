package Expression;

import Type.BaseType;

public abstract class BaseExpression {
    public BaseType type;
    public boolean isLeftValue;

    public BaseExpression(BaseType _type, boolean _isLeftValue) {
        this.type = _type;
        this.isLeftValue = _isLeftValue;
    }

    public BaseType getType() {
        return this.type;
    }


    public boolean isLeftValue() {
        return this.isLeftValue;
    }
}
