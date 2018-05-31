package AST.Constant;

import AST.Type.NullType;
import IR.Instruction.BaseInstruction;
import IR.Operand.Immediate;
import IR.Operand.Operand;

import java.util.List;

public class NullConstant extends BaseConstant {
    public NullConstant() {
        super(NullType.getInstance());
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(new Immediate(0)); //??
    }
}
