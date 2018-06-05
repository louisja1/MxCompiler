package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Address;
import IR.Operand.Immediate;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;
import Other.Operator;
import Error.RuntimeError;

public class UnaryInstruction extends BaseInstruction {
    public Operator.UnaryOp op;
    public Operand target;

    public UnaryInstruction(Operator.UnaryOp _op, Operand _target) {
        if (_target instanceof Immediate) {
            throw new RuntimeError("The target and source of unary instruction can not be address at the same time");
        }
        this.op = _op;
        this.target = _target;
        livenessAnalysis();
    }

    private void livenessAnalysis() {
        if (target instanceof VirtualRegister) {
            defSet.add((VirtualRegister) target);
            useSet.add((VirtualRegister) target);
        } else if (target instanceof Address) {
            useSet.add(((Address) target).base);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s", op, target);
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(target);
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        PhysicalBaseOperand physicalTarget = PhysicalBaseOperand.get(str, target);
        switch (op) {
            case INC :
                str.append(Generater.formatInstruction("add", physicalTarget.toString(), "1"));
                return str.toString();
            case DEC :
                str.append(Generater.formatInstruction("sub", physicalTarget.toString(), "1"));
                return str.toString();
            case NEG :
                str.append(Generater.formatInstruction("neg", physicalTarget.toString()));
                return str.toString();
            case REV :
                str.append(Generater.formatInstruction("not", physicalTarget.toString()));
                return str.toString();
        }
        throw new RuntimeError("There is no a nasm instruction for this unary opreator");
    }
}
