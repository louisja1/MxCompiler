package AST.Type;

import AST.Statement.BaseStatement;
import AST.Statement.BlockStatement;
import AST.SymbolTable.Scope;
import AST.SymbolTable.Symbol;
import IR.Instruction.LabelInstruction;

import java.util.List;

public class FunctionType extends BaseType implements Scope {
    public String name;
    private BaseType returnType;
    private List<Symbol> paraList;
    private BlockStatement blockStatement;
    private Scope classScope;
    private boolean builtin;
    private LabelInstruction enterLabel, exitLabel;

    public FunctionType(String _name, BaseType _returnType, List<Symbol> _paraList) {
        this.name = _name;
        this.returnType = _returnType;
        this.paraList = _paraList;
        this.classScope = null;
        this.builtin = false;
        this.enterLabel = null;
        this.exitLabel = null;
    }

    public void addClassScope(Scope _classScope) {
        this.classScope = _classScope;
    }

    public void addBlockStatement(BlockStatement _blockStatement) {
        this.blockStatement = _blockStatement;
    }

    public String getName() {
        if (classScope == null) {
            return name;
        } else {
            return classScope.getName() + "." + name;
        }
    }

    public String getRawName() {
        return name;
    }

    public BaseType getReturnType() {
        return returnType;
    }

    public List<Symbol> getParaList() {
        return paraList;
    }

    public BlockStatement getBlockStatement() {
        return blockStatement;
    }

    public List<BaseStatement> getBlockStatementList() {
        return blockStatement.getStatements();
    }

    public Scope getClassScope() {
        return classScope;
    }

    public void setBuiltin() {
        builtin = true;
    }

    public void setLabel(LabelInstruction _enterLabel, LabelInstruction _exitLabel) {
        this.enterLabel = _enterLabel;
        this.exitLabel = _exitLabel;
    }

    public boolean isBuiltin() {
        return builtin;
    }

    public LabelInstruction getEnterLabel() {
        return this.enterLabel;
    }

    public LabelInstruction getExitLabel() {
        return this.exitLabel;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        return false;
    }

    @Override
    public String getTypeName() {
        return "Class";
    }
}
