package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalAddress;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import Generater.PhysicalOperand.PhysicalImmediate;
import Generater.PhysicalOperand.PhysicalRegister;
import IR.Operand.Address;
import IR.Operand.Immediate;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;
import Other.Operator;
import Error.RuntimeError;

public class BinaryInstruction extends BaseInstruction {
    public Operator.BinaryOp op;
    public Operand target;
    public Operand source;

    public BinaryInstruction(Operator.BinaryOp _op, Operand _target, Operand _source) {
        this.op = _op;
        this.target = _target;
        this.source = _source;
        if (_target instanceof Immediate) {
            throw new RuntimeError("The target of a binary instruction should not be immediate");
        }
        if (_target instanceof Address && _source instanceof Address) {
            throw new RuntimeError("The target and source of binary instruction can not be address at the same time");
        }
        if (_target instanceof Address && (_op == Operator.BinaryOp.DIV || _op == Operator.BinaryOp.MOD || _op == Operator.BinaryOp.SHL || _op == Operator.BinaryOp.SHR)) {
            throw new RuntimeError("The target of binary div, mod, shl, shr can not be address");
        }
        livenessAnalysis();
    }

    private void livenessAnalysis() {
        if (target instanceof VirtualRegister) {
            defSet.add((VirtualRegister) target);
            useSet.add((VirtualRegister) target);
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
        return String.format("%s %s %s", op, target, source);
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(target);
        VirtualRegisterManager.markUsedOperand(source);
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        String opNASM = Generater.getBinaryOPNASM(op);
        PhysicalBaseOperand physicalTarget = PhysicalBaseOperand.get(str, target);
        PhysicalBaseOperand physicalSource = PhysicalBaseOperand.get(str, source);
        if (opNASM.equals("shl")) {
            if (physicalSource instanceof PhysicalImmediate) {
                str.append(Generater.formatInstruction("sal", physicalTarget.toString(), physicalSource.toString()));
            } else {
                str.append(Generater.formatInstruction("mov", "rcx", physicalSource.toString()));
                str.append(Generater.formatInstruction("sal", physicalTarget.toString(),"cl"));
            }
            return str.toString();
        }
        if (opNASM.equals("shr")) {
            if (physicalSource instanceof PhysicalImmediate) {
                str.append(Generater.formatInstruction("sar", physicalTarget.toString(), physicalSource.toString()));
            } else {
                str.append(Generater.formatInstruction("mov", "rcx", physicalSource.toString()));
                str.append(Generater.formatInstruction("sar", physicalTarget.toString(),"cl"));
            }
            return str.toString();
        }
        if (opNASM.equals("mul")) {
            if (physicalTarget instanceof PhysicalRegister) {
                str.append(Generater.formatInstruction("imul", physicalTarget.toString(), physicalSource.toString()));
            } else {
                str.append(Generater.formatInstruction("mov", "rax", physicalTarget.toString()));
                str.append(Generater.formatInstruction("imul", "rax", physicalSource.toString()));
                str.append(Generater.formatInstruction("mov", physicalTarget.toString(),"rax"));
            }
            return str.toString();
        }
        if (opNASM.equals("div") || opNASM.equals("mod")) {
            str.append(Generater.formatInstruction("mov","rax", physicalTarget.toString()));
            str.append(Generater.formatInstruction("mov","rcx", physicalSource.toString()));
            str.append(Generater.formatInstruction("cdq"));
            str.append(Generater.formatInstruction("idiv","ecx"));
            if (opNASM.equals("div")) {
                str.append(Generater.formatInstruction("mov", physicalTarget.toString(), "rax"));
            } else {
                str.append(Generater.formatInstruction("mov", physicalTarget.toString(), "rdx"));
            }
            return str.toString();
        }
        if (physicalSource instanceof PhysicalAddress && physicalTarget instanceof PhysicalAddress) {
            str.append(Generater.formatInstruction("mov","rax", physicalSource.toString()));
            str.append(Generater.formatInstruction(opNASM, physicalTarget.toString(), "rax"));
        } else {
            str.append(Generater.formatInstruction(opNASM, physicalTarget.toString(), physicalSource.toString()));
        }
        return str.toString();
    }

    @Override
    public boolean isNotAllowedToEliminate() {
        return target.isMemoryRelated() || source.isMemoryRelated();
    }
}
