package AST.SymbolTable;

import AST.Type.ClassType;

import java.util.HashMap;
import Error.CompilationError;

public class ClassTable {
    private HashMap<String, ClassType> classMap;

    public ClassTable() {
        classMap = new HashMap<>();
    }

    public HashMap<String, ClassType> getClassMap() {
        return classMap;
    }

    public void addClass(String name, ClassType extra) {
        if (classMap.containsKey(name)) {
            throw new CompilationError("There is already a class [" + name + "]");
        }
        classMap.put(name, extra);
    }

    public ClassType getClassType(String name) {
        if (!classMap.containsKey(name)) {
            throw new CompilationError("There is not a class [" + name + "]");
        }
        return classMap.get(name);
    }
}
