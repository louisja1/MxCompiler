package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalAddress;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import Generater.PhysicalOperand.PhysicalImmediate;
import IR.Operand.Address;
import IR.Operand.Operand;
import Error.RuntimeError;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

public class CompareInstruction extends BaseInstruction {
    public Operand target;
    public Operand source;

    public CompareInstruction(Operand _target, Operand _source) {
        this.target = _target;
        this.source = _source;
        if (_target instanceof Address && _source instanceof Address) {
            throw new RuntimeError("The target and source of compare instruction can not be address at the same time");
        }
    }

    @Override
    public String toString() {
        return String.format("cmp %s %s", target, source);
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(target);
        VirtualRegisterManager.markUsedOperand(source);
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        PhysicalBaseOperand physicalTarget = PhysicalBaseOperand.get(str, target);
        PhysicalBaseOperand physicalSource = PhysicalBaseOperand.get(str, source);
        if (physicalTarget instanceof PhysicalImmediate || (physicalTarget instanceof PhysicalAddress && physicalSource instanceof PhysicalAddress)) {
            str.append(Generater.formatInstruction("mov","rax", physicalTarget.toString()));
            str.append(Generater.formatInstruction("cmp","rax", physicalSource.toString()));
        } else {
            str.append(Generater.formatInstruction("cmp", physicalTarget.toString(), physicalSource.toString()));
        }
        return str.toString();
    }
}
