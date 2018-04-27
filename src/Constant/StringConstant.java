package Constant;

import Type.StringType;

public class StringConstant extends BaseConstant {
    private String value;
    public StringConstant(String _value) {
        super(StringType.getInstance());
        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }
}
