package IR;

import AST.Constant.IntConstant;
import AST.Constructor.AST;
import AST.Expression.*;
import AST.Expression.Relation.LessExpression;
import AST.Expression.Suffix.SuffixIncrementExpression;
import AST.Statement.BlockStatement;
import AST.Statement.ExpressionStatement;
import AST.Statement.ForStatement;
import AST.Statement.VariableDeclarationStatement;
import AST.Type.*;
import IR.Operand.Address;
import IR.Operand.VirtualRegister;
import Optimizer.MemorialFunctionCall;
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
            for (FunctionType function : _class.getMemberFunctionTable().values()) {
                if (!function.isBuiltin()) {
                    functionMap.put(function.getName(), new FunctionIR(function));
                }
            }
            if (_class.getConstructionFunction() != null) {
                FunctionType constructionFunction = _class.getConstructionFunction();
                functionMap.put(constructionFunction.getName(), new FunctionIR(constructionFunction));
            }
        }
        // combine global variable declaration as a global function
        BlockStatement blockStatement = new BlockStatement();
        for (VariableDeclarationStatement variable : AST.orderedGlobalVariable) {
            blockStatement.addStatement(variable);
        }

        /*if (!MemorialFunctionCall.functionCallMap.isEmpty()) {
            // int ii
            VariableDeclarationStatement ii = new VariableDeclarationStatement(IntType.getInstance(), "ii");
            AST.symbolTable.addSymbol(ii.getSymbol());
            blockStatement.addStatement(ii);
            for (String raw_name : MemorialFunctionCall.functionCallMap) {
                String name = "@@" + raw_name;
                // int [] a = new int[60]
                ArrayType arrayType = new ArrayType(IntType.getInstance(), 1);
                VariableDeclarationStatement variable = new VariableDeclarationStatement(arrayType, name);
                AST.symbolTable.addSymbol(variable.getSymbol());
                List<BaseExpression> list = new Vector<>();
                list.add(new IntConstant(60));
                variable.addExpression(NewExpression.getExpression(IntType.getInstance(), list));
                blockStatement.addStatement(variable);

                // for (ii = 0; ii < 60; ii ++) {}
                ForStatement forStatement = new ForStatement();
                forStatement.addInitiate(AssignExpression.getExpression(IdentifierExpression.getExpression("ii"), new IntConstant(0)));
                forStatement.addCondition(LessExpression.getExpression(IdentifierExpression.getExpression("ii"), new IntConstant(60)));
                forStatement.addVariance(SuffixIncrementExpression.getExpression(IdentifierExpression.getExpression("ii")));
                BlockStatement forBody = new BlockStatement();
                forStatement.addStatement(forBody);
                blockStatement.addStatement(forStatement);

                //{ a[ii] = -1 }
                AssignExpression assign = (AssignExpression) AssignExpression.getExpression(ArrayExpression.getExpression(IdentifierExpression.getExpression(name), IdentifierExpression.getExpression("ii")), new IntConstant(-1));
                blockStatement.addStatement(new ExpressionStatement(assign));
            }
        }*/

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
