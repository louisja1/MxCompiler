package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Address;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

public class ReturnInstruction extends BaseInstruction {
    public Operand returnValue;

    public ReturnInstruction(Operand _returnValue) {
        this.returnValue = _returnValue;
        livenessAnalysis();
    }

    private void livenessAnalysis(){
        if (returnValue instanceof VirtualRegister) {
            useSet.add((VirtualRegister) returnValue);
        } else if (returnValue instanceof Address) {
            useSet.add(((Address) returnValue).base);
        }
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

    @Override
    public boolean isNotAllowedToEliminate() {
        return true;
    }
}
