package AST.Constant;

import AST.Type.StringType;
import IR.Instruction.BaseInstruction;
import IR.Operand.StringConstantTag;

import java.util.List;

public class StringConstant extends BaseConstant {
    private String value;
    public StringConstant(String _value) {
        super(StringType.getInstance());
        this.value = _value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(StringConstantTag.getStringConstantTag(value));
    }
}
