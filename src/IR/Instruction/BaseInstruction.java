package IR.Instruction;

import IR.Operand.VirtualRegister;
import Other.Indent;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseInstruction {
    public Set<VirtualRegister> defSet, useSet, liveIn, liveOut;

    public BaseInstruction() {
        defSet = new HashSet<>();
        useSet = new HashSet<>();
        liveIn = new HashSet<>();
        liveOut = new HashSet<>();
    }

    public String toString(int cnt) {
        return Indent.appendIndent(cnt) + this.toString() + "\n";
    }

    public abstract void prepareRegister();

    public abstract String toNASM();

    public abstract boolean isNotAllowedToEliminate();
}
