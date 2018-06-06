package IR.Instruction;

import Generater.Generater;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;
import Other.Operator;
import Error.RuntimeError;

public class CsetInstruction extends BaseInstruction {
    public Operator.ConditionOp condition;
    public VirtualRegister target;

    public CsetInstruction(Operator.ConditionOp _condition, Operand _target) {
        if (!(_target instanceof VirtualRegister)) {
            throw new RuntimeError("The target of condition set instruction should be virtual register");
        }
        this.condition = _condition;
        this.target = (VirtualRegister) _target;
        livenessAnalysis();
    }

    private void livenessAnalysis() {
        defSet.add(target);
    }

    @Override
    public String toString() {
        return String.format("set %s %s", condition, target);
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(target);
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        PhysicalBaseOperand physicalTarget = PhysicalBaseOperand.get(str, target);
        if (Generater.currentFunction.idMap.containsKey(target)) {
            str.append(Generater.formatInstruction("mov","rax", physicalTarget.toString()));
            str.append(Generater.formatInstruction("mov","rax","0"));
            str.append(Generater.formatInstruction("set" + Generater.getConditionOPNASM(condition), "al"));
            str.append(Generater.formatInstruction("mov", physicalTarget.toString(), "rax"));
        } else {
            str.append(Generater.formatInstruction("mov", physicalTarget.toString(), "0"));
            str.append(Generater.formatInstruction("set" + Generater.getConditionOPNASM(condition), Generater.lowest8Reg.get(physicalTarget.toString())));
        }
        return str.toString();
    }

    @Override
    public boolean isNotAllowedToEliminate() {
        return target.isMemoryRelated();
    }
}
