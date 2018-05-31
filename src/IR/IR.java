package IR;

import AST.Constructor.AST;
import AST.Statement.BlockStatement;
import AST.Statement.VariableDeclarationStatement;
import AST.Type.ClassType;
import AST.Type.FunctionType;
import AST.Type.VoidType;
import IR.Operand.Address;
import IR.Operand.VirtualRegister;
import Other.Indent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class IR {
    public static Map<String, FunctionIR> functionMap;
    public static List<String> constString;
    public static FunctionIR currentFunction;

    public static void init() {
        functionMap = new HashMap<String, FunctionIR>();
        constString = new Vector<>();
        currentFunction = null;
    }

    public static void generateIR() {
        for (VariableDeclarationStatement variable : AST.globalVariable.getVariableMap().values()) {
            VirtualRegister reg = new VirtualRegister(variable.getSymbol().getName());
            reg.setGlobal("@" + variable.getSymbol().getName());
            variable.getSymbol().setOperand(new Address(reg));
        }
        for (FunctionType function : AST.globalFunction.getFunctionMap().values()) {
            if (!function.isBuiltin()) {
                functionMap.put(function.getName(), new FunctionIR(function));
            }
        }
        for (ClassType _class : AST.globalClass.getClassMap().values()) {
            if (_class.getConstructionFunction() != null) {
                FunctionType constructionFunction = _class.getConstructionFunction();
                functionMap.put(constructionFunction.getName(), new FunctionIR(constructionFunction));
            }
            for (FunctionType function : _class.getMemberFunctionTable().values()) {
                if (!function.isBuiltin()) {
                    functionMap.put(function.getName(), new FunctionIR(function));
                }
            }
        }
        // combine global variable declaration as a global function
        BlockStatement blockStatement = new BlockStatement();
        for (VariableDeclarationStatement variable : AST.globalVariable.getVariableMap().values()) {
            blockStatement.addStatement(variable);
        }
        FunctionType function = new FunctionType("@GlobalDeclaration", VoidType.getInstance(), new Vector<>());
        function.addBlockStatement(blockStatement);
        functionMap.put(function.getName(), new FunctionIR(function));

    }

    public static void printIR() throws Exception {
        File file = new File("IR.txt");
        OutputStream fout = new FileOutputStream(file);
        PrintStream fprint = new PrintStream(fout);
        fprint.print(toString(0));
        //System.out.print(toString(0));
    }

    public static String toString(int cnt) {
        StringBuilder str = new StringBuilder();
        //str.append(Indent.appendIndent(cnt));
        for (FunctionIR function : functionMap.values()) {
            IR.currentFunction = function;
            str.append(function.toString(cnt));
        }
        return str.toString();
    }
}
