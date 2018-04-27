package Constant;

import Expression.BaseExpression;
import Type.BaseType;

public abstract class BaseConstant extends BaseExpression {

    public BaseConstant(BaseType _type) {
        super(_type, false);
    }

    /*public BaseType getType() {
        return type;
    }*/

}
