package AST.Statement;

import AST.SymbolTable.Scope;
import IR.Instruction.BaseInstruction;
import IR.Instruction.LabelInstruction;

import java.util.ArrayList;
import java.util.List;

public class BlockStatement extends BaseStatement implements Scope {
    private List<BaseStatement> statements;

    public BlockStatement() {
        this.statements = new ArrayList<>();
    }
    public void addStatement(BaseStatement extra) {
        this.statements.add(extra);
    }
    public List<BaseStatement> getStatements() {
        return statements;
    }

    @Override
    public String getName() {
        return "Block AST.Statement";
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        for (BaseStatement statement : statements) {
            statement.generateIR(instructionList);
        }
    }
}
