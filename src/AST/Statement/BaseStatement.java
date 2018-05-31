package AST.Statement;

import IR.Instruction.BaseInstruction;

import java.util.List;

public abstract class BaseStatement {

    public abstract void generateIR(List<BaseInstruction> instructionList);
}
