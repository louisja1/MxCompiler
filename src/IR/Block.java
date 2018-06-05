package IR;

import IR.Instruction.BaseInstruction;
import IR.Instruction.JumpInstruction;
import IR.Instruction.LabelInstruction;
import IR.Operand.VirtualRegister;
import Other.Indent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Block {
    public FunctionIR function;
    public String blockName;
    public int id;
    public LabelInstruction labelInstruction;
    public List<BaseInstruction> instructionList;
    public Set<Block> blockIn, blockOut;
    public boolean haveJumpInstruction;
    public Set<VirtualRegister> useSet, defSet, liveIn, liveOut;

    public Block(FunctionIR _function, String _blockName, int _id, LabelInstruction _label) {
        this.function = _function;
        this.blockName = _blockName;
        this.id = _id;
        this.labelInstruction = _label;
        this.instructionList = new Vector<>();
        this.blockIn = new HashSet<>();
        this.blockOut = new HashSet<>();
        this.haveJumpInstruction = false;
    }

    public void addInstruction(BaseInstruction instruction) {
        if (haveJumpInstruction) {
            return;
        }
        instructionList.add(instruction);
        if (instruction instanceof JumpInstruction) {
            haveJumpInstruction = true;
        }
    }

    public String getName() {
        return String.format("%s.%d.%s", function.getName(), id, blockName);
    }

    @Override
    public String toString() {
        return String.format("%s.%d.%s", function.getName(), id, blockName);
    }

    public String toString(int cnt) {
        StringBuilder str = new StringBuilder();
        str.append(Indent.appendIndent(cnt));
        str.append(this.getName());
        str.append(" :\n");
        for (BaseInstruction instruction : instructionList) {
            str.append(instruction.toString(cnt + 1));
        }
        return str.toString();
    }
}
