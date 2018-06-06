package IR.Instruction;

import Generater.Generater;
import Other.Operator;

public class CjumpInstruction extends BaseInstruction {
    public Operator.ConditionOp condition;
    public LabelInstruction target;

    public CjumpInstruction(Operator.ConditionOp _condition, LabelInstruction _target) {
        this.condition = _condition;
        this.target = _target;
        livenessAnalysis();
    }

    private void livenessAnalysis(){
    }

    @Override
    public String toString() {
        return String.format("cjump %s %s", condition, target.block);
    }

    @Override
    public void prepareRegister() {
    }

    @Override
    public String toNASM() {
        return Generater.formatInstruction("j" + Generater.getConditionOPNASM(condition), target.block.getName());
    }

    @Override
    public boolean isNotAllowedToEliminate() {
        return false;
    }
}
