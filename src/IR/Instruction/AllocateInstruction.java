package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

public class AllocateInstruction extends BaseInstruction {
    private VirtualRegister target;
    private Operand allocateSize;

    public AllocateInstruction(VirtualRegister _target, Operand _allocateSize) {
        this.target = _target;
        this.allocateSize = _allocateSize;
    }

    @Override
    public String toString() {
        return String.format("%s = allocate %s", target, allocateSize);
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(target);
        VirtualRegisterManager.markUsedOperand(allocateSize);
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        PhysicalBaseOperand physicalAllocateSize = PhysicalBaseOperand.get(str, allocateSize);
        str.append(Generater.pushCaller(Generater.currentFunction.usedCallerRegisterList));

        str.append(Generater.formatInstruction("mov","rdi", physicalAllocateSize.toString()));
        str.append(Generater.callInstruction("malloc"));
        str.append(Generater.popCaller(Generater.currentFunction.usedCallerRegisterList));
        PhysicalBaseOperand physicalTarget = PhysicalBaseOperand.get(str, target);
        str.append(Generater.formatInstruction("mov", physicalTarget.toString(),"rax"));

        return str.toString();
    }
}
