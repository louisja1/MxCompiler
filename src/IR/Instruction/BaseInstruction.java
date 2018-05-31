package IR.Instruction;

import Other.Indent;

public abstract class BaseInstruction {

    public BaseInstruction() {
    }

    public String toString(int cnt) {
        return Indent.appendIndent(cnt) + this.toString() + "\n";
    }

    public abstract void prepareRegister();

    public abstract String toNASM();
}
