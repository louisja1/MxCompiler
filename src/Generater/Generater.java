package Generater;

import AST.Constructor.AST;
import AST.Statement.VariableDeclarationStatement;
import IR.FunctionIR;
import IR.IR;
import Other.Operator;
import Other.StringFormatter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Generater {
    public static FunctionIR currentFunction;
    public static int rsp;
    public static final List<String> caller = new Vector<String>() {{
        add("rsi");
        add("rdi");
        add("r8");
        add("r9");
        add("r10");
        add("r11");
    }};
    public static final List<String> callee = new Vector<String>() {{
        add("rbx");
        add("r12");
        add("r13");
        add("r14");
        add("r15");
    }};
    public static final Map<String, String> lowest8Reg = new HashMap<String, String>() {{
        put("rax", "al");
        put("rcx", "cl");
        put("rdx", "dl");
        put("rbx", "bl");
        put("rsp", "spl");
        put("rbp", "bpl");
        put("rsi", "sil");
        put("rdi", "dil");
        put("r8", "r8b");
        put("r9", "r9b");
        put("r10", "r10b");
        put("r11", "r11b");
        put("r12", "r12b");
        put("r13", "r13b");
        put("r14", "r14b");
        put("r15", "r15b");
    }};


    public static void codegen() throws Exception {
        File file = new File("program.asm");
        OutputStream fout = new FileOutputStream(file);
        PrintStream fprint = new PrintStream(fout);
        String code = Generater.toNASM();
        fprint.print(code);
        System.out.println(code);
    }
    public static String toNASM() {
        StringBuilder str = new StringBuilder();
        str.append(formatInstruction("global","main"));
        str.append(formatInstruction("extern","printf"));
        str.append(formatInstruction("extern","malloc"));
        str.append(formatInstruction("extern","strcpy"));
        str.append(formatInstruction("extern","scanf"));
        str.append(formatInstruction("extern","strlen"));
        str.append(formatInstruction("extern","sscanf"));
        str.append(formatInstruction("extern","sprintf"));
        str.append(formatInstruction("extern","memcpy"));
        str.append(formatInstruction("extern","strcmp"));
        str.append(formatInstruction("extern","puts"));

        str.append("\n");
        str.append(Generater.getTextSection());
        str.append("\n");
        str.append(Generater.getDataSection());
        str.append("\n");
        str.append(Generater.getBssSection());
        str.append("\n");
        str.append(BuiltinFunctionGenerater.getBuiltinFunction());

        return str.toString();
    }

    public static String getTextSection() {
        StringBuilder str = new StringBuilder();
        str.append("section\t.text\n");
        for (FunctionIR function : IR.functionMap.values()) {
            currentFunction = function;
            str.append(function.toNASM());
        }
        return str.toString();
    }

    public static String getDataSection() {
        StringBuilder str = new StringBuilder();
        str.append("section\t.data\n");
        for (int i = 0; i < IR.constString.size(); i++) {
            String stringConstant = IR.constString.get(i);
            str.append(Generater.formatInstruction("dq", String.valueOf(stringConstant.length())));
            str.append("_string_constant_" + String.valueOf(i) + ":\n");
            str.append(Generater.formatInstruction("db", StringFormatter.modifyInvisibleCharacters(stringConstant)));
        }
        return str.toString();
    }

    public static String getBssSection() {
        StringBuilder str = new StringBuilder();
        str.append("section\t.bss\n");
        for (VariableDeclarationStatement variable : AST.globalVariable.getVariableMap().values()) {
            str.append("@" + variable.getName() + ":\n");
            str.append(Generater.formatInstruction("resq", "1"));
        }
        return str.toString();
    }

    public static String callInstruction(String operator) {
        StringBuilder str = new StringBuilder();
        if (rsp % 2 == 0) {
            str.append(formatInstruction("call", operator));
        } else {
            str.append(formatInstruction("sub", "rsp", "8"));
            str.append(formatInstruction("call", operator));
            str.append(formatInstruction("add", "rsp", "8"));
        }
        return str.toString();
    }


    public static String formatInstruction(String operator) {
        return String.format("%8s\n", operator);
    }

    public static String formatInstruction(String operator, String operand) {
        if (operator.equals("push")) {
            rsp ++;
        }
        if (operator.equals("pop")) {
            rsp --;
        }
        return String.format("%8s %20s\n", operator, operand);
    }

    public static String formatInstruction(String operator, String operand1, String operand2) {
        if (operator.equals("mov") && operand1.equals(operand2)) {
            return "";
        }
        return String.format("%8s %20s, %20s\n", operator, operand1, operand2);
    }

    public static String pushCallee() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < currentFunction.usedCalleeRegisterList.size(); i++) {
            str.append(formatInstruction("push", currentFunction.usedCalleeRegisterList.get(i)));
        }
        return str.toString();
    }

    public static String popCallee() {
        StringBuilder str = new StringBuilder();
        for (int i = currentFunction.usedCalleeRegisterList.size() - 1; i >=0; i--) {
            str.append(formatInstruction("pop",currentFunction.usedCalleeRegisterList.get(i)));
        }
        return str.toString();
    }

    public static String pushCaller(List<String> callerList) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < callerList.size(); i++) {
            str.append(formatInstruction("push", callerList.get(i)));
        }
        return str.toString();
    }

    public static String popCaller(List<String> callerList) {
        StringBuilder str = new StringBuilder();
        for (int i = callerList.size() - 1; i >=0; i--) {
            str.append(formatInstruction("pop", callerList.get(i)));
        }
        return str.toString();
    }

    public static String getConditionOPNASM(Operator.ConditionOp condition) {
        switch (condition) {
            case EQ : return "e";
            case NEQ : return "ne";
            case GR : return "g";
            case GREQ : return "ge";
            case LE : return "l";
            case LEEQ : return "le";
        }
        return "!!!! ERROR condition operator nasm";
    }

    public static String getBinaryOPNASM(Operator.BinaryOp binaryOp) {
        switch (binaryOp) {
            case ADD : return "add";
            case SUB : return "sub";
            case MUL : return "mul";
            case DIV : return "div";
            case MOD : return "mod";
            case SHL : return "shl";
            case SHR : return "shr";
            case AND : return "and";
            case OR : return "or";
            case XOR : return "xor";
        }
        return "!!!! ERROR binary operator nasm";
    }
}
