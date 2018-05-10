package SymbolTable;

import Type.FunctionType;
import java.util.HashMap;

import Error.CompilationError;

public class FunctionTable {
    private HashMap<String, FunctionType> functionMap;

    public FunctionTable() {
        functionMap = new HashMap<>();
    }

    public HashMap<String, FunctionType> getFunctionMap() {
        return functionMap;
    }

    public void addFunction(FunctionType extra) {
        String name = extra.getRawName();
        if (functionMap.containsKey(name)) {
            throw new CompilationError("There is already a function [" + name + "] in this scope");
        }
        functionMap.put(name, extra);
    }

    public boolean existFunction(String name) {
        return functionMap.containsKey(name);
    }

    public FunctionType getFunctionType(String name) {
        if (!functionMap.containsKey(name)) {
            throw new CompilationError("There is not a function [" + name + "]");
        }
        return functionMap.get(name);
    }

}
