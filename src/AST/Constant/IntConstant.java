package AST.Constant;

import AST.Type.IntType;
import IR.Instruction.BaseInstruction;
import IR.Operand.Immediate;

import java.util.List;

public class IntConstant extends BaseConstant {
    private int value;
    public IntConstant(int _value) {
        super(IntType.getInstance());
        this.value = _value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(new Immediate(value));
    }
}
