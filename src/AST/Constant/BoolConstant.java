package AST.Constant;


import AST.Type.BoolType;
import IR.Instruction.BaseInstruction;
import IR.Operand.Immediate;

import java.util.List;

public class BoolConstant extends BaseConstant {
    private boolean value;
    public BoolConstant(boolean _value) {
        super(BoolType.getInstance());
        this.value = _value;
    }
    public boolean getValue() {
        return this.value;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(new Immediate(value ? 1 : 0));
    }
}
