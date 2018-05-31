package IR.Operand;

import IR.IR;

public class StringConstantTag extends Operand {
    public String tagName;

    private StringConstantTag(String _tagName) {
        this.tagName = _tagName;
    }

    public static StringConstantTag getStringConstantTag(String name) {
        int id = IR.constString.size();
        IR.constString.add(name);
        return new StringConstantTag("_string_constant_" + String.valueOf(id));
    }

    @Override
    public String toString() {
        return tagName;
    }
}
