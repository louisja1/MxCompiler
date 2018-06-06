package IR.Instruction;

import IR.Block;
import Error.RuntimeError;

public class LabelInstruction extends BaseInstruction {
    public String name;
    public Block block;
    public boolean isLoopEntry;
    public LabelInstruction loopExit;

    public LabelInstruction(String name) {
        this.name = name;
        this.block = null;
        this.isLoopEntry = false;
        this.loopExit = null;
        livenessAnalysis();
    }

    private void livenessAnalysis(){

    }

    public void setBlock(Block _block) {
        this.block = _block;
    }

    public String getName() {
        return name;
    }

    public void setEntry(LabelInstruction _loopExit) {
        isLoopEntry = true;
        loopExit = _loopExit;
    }

    @Override
    public String toString() {
        return String.format("% %s", name);
    }

    @Override
    public void prepareRegister() {

    }

    @Override
    public String toNASM() {
        throw new RuntimeError("There is no nasm instruction for label instruction");
    }

    @Override
    public boolean isNotAllowedToEliminate() {
        return false;
    }
}
