package Generater;

import Other.Operator;

public class BuiltinFunctionGenerater {
    private static int rsp;

    public static String getBuiltinFunction() {
        StringBuilder str = new StringBuilder();

        str.append("\n");
        str.append(BuiltinFunctionGenerater.getTextSection());
        str.append("\n");
        str.append(BuiltinFunctionGenerater.getDataSection());
        str.append("\n");
        str.append(BuiltinFunctionGenerater.getBssSection());

        return str.toString();
    }

    private static String getTextSection() {
        StringBuilder str = new StringBuilder();
        str.append("section\t.text\n");
        str.append(getSizeNASM());

        str.append(getPrintNASM());
        str.append(getPrintlnNASM());
        str.append(getGetStringNASM());
        str.append(getGetIntNASM());
        str.append(getToStringNASM());

        str.append(getLengthNASM());
        str.append(getSubStringNASM());
        str.append(getParseIntNASM());
        str.append(getOrdNASM());

        str.append(getAddNASM());
        str.append(getCompareNASM(Operator.ConditionOp.EQ));
        str.append(getCompareNASM(Operator.ConditionOp.GR));
        str.append(getCompareNASM(Operator.ConditionOp.GREQ));
        str.append(getCompareNASM(Operator.ConditionOp.LE));
        str.append(getCompareNASM(Operator.ConditionOp.LEEQ));
        str.append(getCompareNASM(Operator.ConditionOp.NEQ));

        return str.toString();
    }

    private static String getSizeNASM() {
        StringBuilder str = new StringBuilder();
        str.append("_builtin_size:\n");
        str.append(formatInstruction("mov", "rax", "qword [rdi - 8]"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getPrintNASM() {
        StringBuilder str = new StringBuilder();
        str.append("print:\n");
        rsp = 1;
        str.append(formatInstruction("mov", "rsi", "rdi"));
        str.append(formatInstruction("mov", "rdi", "_print_format"));
        str.append(callInstruction("printf"));
        return str.toString();
    }

    private static String getPrintlnNASM() {
        StringBuilder str = new StringBuilder();
        str.append("println:\n");
        str.append(callInstruction("puts"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getGetStringNASM() {
        StringBuilder str = new StringBuilder();
        str.append("getString:\n");
        rsp = 1;
        str.append(formatInstruction("push", "r15"));
        str.append(formatInstruction("mov", "rdi","300"));
        str.append(callInstruction("malloc"));
        str.append(formatInstruction("mov","r15","rax"));
        str.append(formatInstruction("add","r15","8"));
        str.append(formatInstruction("mov","rdi","_getString_format"));
        str.append(formatInstruction("mov","rsi","r15"));
        str.append(callInstruction("scanf"));
        str.append(formatInstruction("mov","rdi","r15"));
        str.append(callInstruction("strlen"));
        str.append(formatInstruction("mov","qword [r15 - 8]", "rax"));
        str.append(formatInstruction("mov","rax","r15"));
        str.append(formatInstruction("pop","r15"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getGetIntNASM() {
        StringBuilder str = new StringBuilder();
        str.append("getInt:\n");
        rsp = 1;
        str.append(formatInstruction("mov","rdi","_getInt_format"));
        str.append(formatInstruction("mov","rsi","@getIntBuffer"));
        str.append(callInstruction("scanf"));
        str.append(formatInstruction("mov","rax","qword [@getIntBuffer]"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getToStringNASM() {
        StringBuilder str = new StringBuilder();
        str.append("toString:\n");
        rsp = 1;
        str.append(formatInstruction("push","r15"));
        str.append(formatInstruction("push","rdi"));
        str.append(formatInstruction("mov","rdi", "20"));
        str.append(callInstruction("malloc"));
        str.append(formatInstruction("mov","r15","rax"));
        str.append(formatInstruction("add","r15","8"));
        str.append(formatInstruction("mov","rdi","r15"));
        str.append(formatInstruction("mov","rsi","_toString_format"));
        str.append(formatInstruction("pop","rxi"));
        str.append(callInstruction("sprintf"));
        str.append(formatInstruction("mov","rdi","r15"));
        str.append(callInstruction("strlen"));
        str.append(formatInstruction("mov","qword [r15 - 8]", "rax"));
        str.append(formatInstruction("mov","rax","r15"));
        str.append(formatInstruction("pop","r15"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getLengthNASM() {
        StringBuilder str = new StringBuilder();
        str.append("_builtin_length:\n");
        str.append(formatInstruction("mov","rax","qword [rdi - 8]"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getSubStringNASM() {
        StringBuilder str = new StringBuilder();
        str.append("_builtin_substring:\n");
        rsp = 1;
        str.append(formatInstruction("push","r15"));
        str.append(formatInstruction("mov","r15","rdi"));
        str.append(formatInstruction("add","r15","rsi"));
        str.append(formatInstruction("push","r14"));
        str.append(formatInstruction("mov","r14","rdx"));
        str.append(formatInstruction("sub","r14","rsi"));
        str.append(formatInstruction("add","r14","1"));
        str.append(formatInstruction("mov","rdi","r14"));
        str.append(formatInstruction("add","rdi","9"));
        str.append(callInstruction("malloc"));
        str.append(formatInstruction("add","rax","8"));
        str.append(formatInstruction("mov","rdi","rax"));
        str.append(formatInstruction("mov","rsi","r15"));
        str.append(formatInstruction("mov","rdx","r14"));
        str.append(callInstruction("memcpy"));
        str.append(formatInstruction("mov", "qword [rax - 8]", "r14"));
        str.append(formatInstruction("mov","r15","rax"));
        str.append(formatInstruction("add","r15","r14"));
        str.append(formatInstruction("mov","qword [r15]","0"));
        str.append(formatInstruction("pop","r14"));
        str.append(formatInstruction("pop","r15"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getParseIntNASM() {
        StringBuilder str = new StringBuilder();
        str.append("_builtin_parseint:\n");
        rsp = 1;
        str.append(formatInstruction("mov","rsi","_parseInt_format"));
        str.append(formatInstruction("mov","rdx","@parseIntBuffer"));
        str.append(callInstruction("sscanf"));
        str.append(formatInstruction("mov","rax", "qword [@parseIntBuffer]"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getOrdNASM() {
        StringBuilder str= new StringBuilder();
        str.append("_builtin_ord:\n");
        rsp = 1;
        str.append(formatInstruction("add","rdi","rsi"));
        str.append(formatInstruction("movsx","rax","byte [rdi]"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getAddNASM() {
        StringBuilder str = new StringBuilder();
        str.append("_builtin_add:\n");
        rsp = 1;
        str.append(formatInstruction("push","r15"));
        str.append(formatInstruction("mov","r15","qword [rdi - 8]"));
        str.append(formatInstruction("add","r15","qword [rsi - 8]"));
        str.append(formatInstruction("add", "r15", "9"));
        str.append(formatInstruction("push","r14"));
        str.append(formatInstruction("mov","r14","rdi")); // left string
        str.append(formatInstruction("push","r13"));
        str.append(formatInstruction("mov","r13","rsi")); // right string
        str.append(formatInstruction("mov","rdi","r15"));
        str.append(callInstruction("malloc"));
        str.append(formatInstruction("sub","r15","9"));
        str.append(formatInstruction("mov","qword [rax]", "r15"));
        str.append(formatInstruction("mov","r15","rax"));
        str.append(formatInstruction("add","r15","8"));
        str.append(formatInstruction("mov","rdi","r15"));
        str.append(formatInstruction("mov","rsi","r14"));
        str.append(callInstruction("strcpy"));
        str.append(formatInstruction("add","r15","qword [r14 - 8]"));
        str.append(formatInstruction("mov","r14","rax"));
        str.append(formatInstruction("mov","rdi","r15"));
        str.append(formatInstruction("mov","rsi","r13"));
        str.append(callInstruction("strcpy"));
        str.append(formatInstruction("mov","rax","r14"));
        str.append(formatInstruction("add","r15","qword [r13 - 8]"));
        str.append(formatInstruction("mov","qword [r15]", "0"));
        str.append(formatInstruction("pop","r13"));
        str.append(formatInstruction("pop","r14"));
        str.append(formatInstruction("pop","r15"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String getCompareNASM(Operator.ConditionOp condition) {
        StringBuilder str = new StringBuilder();
        str.append("_builtin_" + condition + ":\n");
        rsp = 1;
        str.append(callInstruction("strcmp"));
        str.append(formatInstruction("cmp", "eax", "0"));
        str.append(formatInstruction("mov","rax","0"));
        str.append(formatInstruction("set" + BuiltinFunctionGenerater.getConditionOPNASM(condition), "al"));
        str.append(formatInstruction("ret"));
        return str.toString();
    }

    private static String callInstruction(String operator) {
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

    private static String formatInstruction(String operator) {
        return String.format("%8s\n", operator);
    }

    private static String formatInstruction(String operator, String operand) {
        if (operator.equals("push")) {
            rsp ++;
        }
        if (operator.equals("pop")) {
            rsp --;
        }
        return String.format("%8s %20s\n", operator, operand);
    }

    private static String formatInstruction(String operator, String operand1, String operand2) {
        if (operator.equals("mov") && operand1.equals(operand2)) {
            return "";
        }
        return String.format("%8s %20s, %20s\n", operator, operand1, operand2);
    }

    private static String getConditionOPNASM(Operator.ConditionOp condition) {
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

    private static String getDataSection() {
        StringBuilder str = new StringBuilder();
        str.append("section\t.data\n");
        str.append("_print_format:\n");
        str.append(formatInstruction("db","\"%s\", 0"));
        str.append("_getString_format:\n");
        str.append(formatInstruction("db","\"%s\", 0"));
        str.append("_getInt_format:\n");
        str.append(formatInstruction("db","\"%ld\", 0"));
        str.append("_toString_format:\n");
        str.append(formatInstruction("db","\"%ld\", 0"));
        str.append("_parseInt_format:\n");
        str.append(formatInstruction("db","\"%ld\", 0"));
        return str.toString();
    }

    private static String getBssSection() {
        StringBuilder str = new StringBuilder();
        str.append("section\t.bss\n");
        str.append("@getIntBuffer:\n");
        str.append(formatInstruction("resq","1"));
        str.append("@parseIntBuffer:\n");
        str.append(formatInstruction("resq","1"));
        return str.toString();
    }
}
