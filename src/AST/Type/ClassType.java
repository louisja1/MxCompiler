package AST.Type;

import AST.Statement.VariableDeclarationStatement;
import AST.SymbolTable.FunctionTable;
import AST.SymbolTable.Scope;
import AST.SymbolTable.VariableTable;
import Error.CompilationError;

import java.util.Map;

public class ClassType extends NonArrayType implements Scope {
    private String name;
    private VariableTable memberVarTable;
    private FunctionTable memberFuncTable;
    private FunctionType constructionFunc;

    private int allocateSize;

    public ClassType(String _name) {
        this.name = _name;
        this.memberFuncTable = new FunctionTable();
        this.memberVarTable = new VariableTable();
        this.constructionFunc = null;
        this.allocateSize = 0;
    }

    public Map<String, VariableDeclarationStatement> getMemberVariableTable() {
        return memberVarTable.getVariableMap();
    }

    public Map<String, FunctionType> getMemberFunctionTable() {
        return memberFuncTable.getFunctionMap();
    }

    public VariableDeclarationStatement getMemberVariable(String name) {
        return memberVarTable.getVariable(name);
    }

    public FunctionType getMemberFunction(String name) {
        return memberFuncTable.getFunctionType(name);
    }

    public FunctionType getConstructionFunction() {
        return constructionFunc;
    }

    public void addMemberVariable(VariableDeclarationStatement extra) {
        extra.getSymbol().classScope = this;
        memberVarTable.addVariable(extra);
        extra.setOffset(allocateSize);
        this.allocateSize += 8;
    }

    public void addMemberFunction(FunctionType extra) {
        memberFuncTable.addFunction(extra);
    }

    public void addConstructionFunction(FunctionType _constructionFunction) {
        if (constructionFunc != null) {
            throw new CompilationError("There is already a construction function in class [" + name + "]");
        }
        if (!this.beCompatibleWith(_constructionFunction.getReturnType())) {
            throw new CompilationError("Construction function return error type");
        }
        constructionFunc = _constructionFunction;
    }

    public boolean existMemberFunction(String name) {
        return memberFuncTable.existFunction(name);
    }

    public boolean existMemberVariable(String name) {
        return memberVarTable.existVariable(name);
    }

    public String getName() {
        return name;
    }

    public int getAllocateSize() {
        return allocateSize;
    }

    @Override
    public boolean beCompatibleWith(BaseType other) {
        if (other == NullType.getInstance()) {
            return true;
        }
        if (other == this) {
            return true;
        }
        return false;
    }

    @Override
    public String getTypeName() {
        return "Class";
    }
}
