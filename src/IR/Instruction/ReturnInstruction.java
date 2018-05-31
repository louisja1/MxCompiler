package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Operand;
import IR.VirtualRegisterManager;

public class ReturnInstruction extends BaseInstruction {
    public Operand returnValue;

    public ReturnInstruction(Operand _returnValue) {
        this.returnValue = _returnValue;
    }

    @Override
    public String toString() {
        return String.format("ret %s", returnValue);
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(returnValue);
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        PhysicalBaseOperand physicalReturnValue = PhysicalBaseOperand.get(str, returnValue);
        str.append(Generater.formatInstruction("mov", "rax", physicalReturnValue.toString()));
        return str.toString();
    }
}
