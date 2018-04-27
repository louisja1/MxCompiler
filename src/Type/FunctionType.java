package Type;

import Statement.BaseStatement;
import Statement.BlockStatement;
import SymbolTable.Scope;
import SymbolTable.Symbol;

import java.util.List;

public class FunctionType extends BaseType implements Scope {
    public String name;
    private BaseType returnType;
    private List<Symbol> paraList;
    private BlockStatement blockStatement;
    private Scope classScope;
    private boolean builtin;

    public FunctionType(String _name, BaseType _returnType, List<Symbol> _paraList) {
        this.name = _name;
        this.returnType = _returnType;
        this.paraList = _paraList;
        this.classScope = null;
        this.builtin = false;
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

    public boolean isBuiltin() {
        return builtin;
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
