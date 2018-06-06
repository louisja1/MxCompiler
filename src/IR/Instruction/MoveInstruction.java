package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalAddress;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Address;
import IR.Operand.Operand;
import Error.RuntimeError;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

public class MoveInstruction extends BaseInstruction {
    public Operand target;
    public Operand source;

    public MoveInstruction(Operand _target, Operand _source) {
        if (_target instanceof Address && _source instanceof Address) {
            throw new RuntimeError("The target and source of move instruction can not be address at the same time");
        }
        this.target = _target;
        this.source = _source;
        livenessAnalysis();
    }

    public void modifyTarget(Operand _target) {
        this.target = _target;
        livenessAnalysis();
    }

    private void livenessAnalysis() {
        defSet.clear();
        useSet.clear();
        if (target instanceof VirtualRegister) {
            defSet.add((VirtualRegister) target);
        } else if (target instanceof Address) {
            useSet.add(((Address) target).base);
        }

        if (source instanceof VirtualRegister) {
            useSet.add((VirtualRegister) source);
        } else if (source instanceof Address) {
            useSet.add(((Address) source).base);
        }
    }

    @Override
    public String toString() {
        return String.format("mov %s %s", target, source);
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
        if (physicalTarget instanceof PhysicalAddress && physicalSource instanceof PhysicalAddress) {
            str.append(Generater.formatInstruction("mov","rax", physicalSource.toString()));
            str.append(Generater.formatInstruction("mov", physicalTarget.toString(),"rax"));
        } else {
            str.append(Generater.formatInstruction("mov", physicalTarget.toString(), physicalSource.toString()));
        }
        return str.toString();
    }

    @Override
    public boolean isNotAllowedToEliminate() {
        return target.isMemoryRelated() || source.isMemoryRelated();
    }
}
