package Constructor;

import SymbolTable.ClassTable;
import SymbolTable.FunctionTable;
import SymbolTable.VariableTable;
import SymbolTable.SymbolTable;

public class AST {
    public static ClassTable globalClass;
    public static FunctionTable globalFunction;
    public static VariableTable globalVariable;
    public static SymbolTable symbolTable;

    public static void init() {
        globalClass = new ClassTable();
        globalFunction = new FunctionTable();
        globalVariable = new VariableTable();
        symbolTable = new SymbolTable();
    }

    public static void setBuiltinFunction() {
        BuiltinFunctionConstructor.setAll();
    }
}
