package Constant;


import Type.BoolType;

public class BoolConstant extends BaseConstant {
    private boolean value;
    public BoolConstant(boolean _value) {
        super(BoolType.getInstance());
        this.value = _value;
    }
    public boolean getValue() {
        return this.value;
    }
}
