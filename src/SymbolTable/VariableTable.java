package SymbolTable;

import Statement.VariableDeclarationStatement;
import Error.CompilationError;

import java.util.HashMap;

public class VariableTable {
    private HashMap<String, VariableDeclarationStatement> variableMap;

    public VariableTable() {
        variableMap = new HashMap<>();
    }

    public HashMap<String, VariableDeclarationStatement> getVariableMap() {
        return variableMap;
    }

    public void addVariable(VariableDeclarationStatement extra) {
        String name = extra.getName();
        if (variableMap.containsKey(name)) {
            throw new CompilationError("There is already a variable [" + name + "] in this scope");
        }
        variableMap.put(name, extra);
    }

    public boolean existVariable(String name) {
        return variableMap.containsKey(name);
    }
    public VariableDeclarationStatement getVariable(String name) {
        return variableMap.get(name);
    }
}
