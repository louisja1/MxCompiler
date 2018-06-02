package AST.Constructor;

import AST.Statement.VariableDeclarationStatement;
import AST.SymbolTable.ClassTable;
import AST.SymbolTable.FunctionTable;
import AST.SymbolTable.VariableTable;
import AST.SymbolTable.SymbolTable;

import java.util.List;
import java.util.Vector;

public class AST {
    public static ClassTable globalClass;
    public static FunctionTable globalFunction;
    public static VariableTable globalVariable;
    public static List<VariableDeclarationStatement> orderedGlobalVariable;
    public static SymbolTable symbolTable;

    public static void init() {
        globalClass = new ClassTable();
        globalFunction = new FunctionTable();
        globalVariable = new VariableTable();
        orderedGlobalVariable = new Vector<>();
        symbolTable = new SymbolTable();
    }

    public static void setBuiltinFunction() {
        BuiltinFunctionConstructor.setAll();
    }
}
