package Constant;

import Type.IntType;

public class IntConstant extends BaseConstant {
    private int value;
    public IntConstant(int _value) {
        super(IntType.getInstance());
        this.value = _value;
    }

    public int getValue() {
        return this.value;
    }
}
