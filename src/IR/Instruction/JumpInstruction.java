package IR.Instruction;

import Generater.Generater;

public class JumpInstruction extends BaseInstruction {
    public LabelInstruction target;

    public JumpInstruction(LabelInstruction _target) {
        this.target = _target;
        livenessAnalysis();
    }

    public void modifyTarget(LabelInstruction _target) {
        this.target = _target;
        livenessAnalysis();
    }

    private void livenessAnalysis() {

    }

    @Override
    public String toString() {
        return String.format("jump %s", target.block);
    }

    @Override
    public void prepareRegister() {

    }

    @Override
    public String toNASM() {
        return Generater.formatInstruction("jmp", target.block.getName());
    }

    @Override
    public boolean isNotAllowedToEliminate() {
        return false;
    }
}
