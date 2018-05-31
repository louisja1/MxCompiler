package AST.Constructor;

import AST.SymbolTable.Symbol;
import AST.Type.*;

import java.util.List;
import java.util.Vector;

public class BuiltinFunctionConstructor {
    public static void setAll() {
        //array builtin function
        setSize();
        //builtin function
        setPrint();
        setPrintln();
        setGetString();
        setGetInt();
        setToString();
        //string builtin function
        setLength();
        setSubString();
        setParseInt();
        setOrd();
        //string operator
        setAdd();
        setEQ();
        setNEQ();
        setGR();
        setGREQ();
        setLE();
        setLEEQ();
    }

    private static void setSize() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("this", null));
        FunctionType size = new FunctionType("_builtin_size", IntType.getInstance(), paralist);
        size.setBuiltin();
        AST.globalFunction.addFunction(size);
    }

    private static void setPrint() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string", StringType.getInstance()));
        FunctionType print = new FunctionType("print", VoidType.getInstance(), paralist);
        print.setBuiltin();
        AST.globalFunction.addFunction(print);
    }

    private static void setPrintln() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string", StringType.getInstance()));
        FunctionType println = new FunctionType("println", VoidType.getInstance(), paralist);
        println.setBuiltin();
        AST.globalFunction.addFunction(println);
    }

    private static void setGetString() {
        List<Symbol> paralist = new Vector<>();
        FunctionType getstring = new FunctionType("getString", StringType.getInstance(), paralist);
        getstring.setBuiltin();
        AST.globalFunction.addFunction(getstring);
    }

    private static void setGetInt() {
        List<Symbol> paralist = new Vector<>();
        FunctionType getint = new FunctionType("getInt", IntType.getInstance(), paralist);
        getint.setBuiltin();
        AST.globalFunction.addFunction(getint);
    }

    private static void setToString() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("int", IntType.getInstance()));
        FunctionType tostring = new FunctionType("toString", StringType.getInstance(), paralist);
        tostring.setBuiltin();
        AST.globalFunction.addFunction(tostring);
    }

    private static void setLength() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("this", null));
        FunctionType length = new FunctionType("_builtin_length", IntType.getInstance(), paralist);
        length.setBuiltin();
        AST.globalFunction.addFunction(length);
    }

    private static void setSubString() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("this", null));
        paralist.add(new Symbol("int1", IntType.getInstance()));
        paralist.add(new Symbol("int2", IntType.getInstance()));
        FunctionType substring = new FunctionType("_builtin_substring", StringType.getInstance(), paralist);
        substring.setBuiltin();
        AST.globalFunction.addFunction(substring);
    }

    private static void setParseInt() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("this", null));
        FunctionType parseint = new FunctionType("_builtin_parseint", IntType.getInstance(), paralist);
        parseint.setBuiltin();
        AST.globalFunction.addFunction(parseint);
    }

    private static void setOrd() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("this", null));
        paralist.add(new Symbol("pos", IntType.getInstance()));
        FunctionType ord = new FunctionType("_builtin_ord", IntType.getInstance(), paralist);
        ord.setBuiltin();
        AST.globalFunction.addFunction(ord);
    }

    private static void setAdd() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType add = new FunctionType("_builtin_add", StringType.getInstance(), paralist);
        add.setBuiltin();
        AST.globalFunction.addFunction(add);
    }

    private static void setEQ() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType EQ = new FunctionType("_builtin_EQ", BoolType.getInstance(), paralist);
        EQ.setBuiltin();
        AST.globalFunction.addFunction(EQ);
    }

    private static void setNEQ() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType NEQ = new FunctionType("_builtin_NEQ", BoolType.getInstance(), paralist);
        NEQ.setBuiltin();
        AST.globalFunction.addFunction(NEQ);
    }

    private static void setLE() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType LE = new FunctionType("_builtin_LE", BoolType.getInstance(), paralist);
        LE.setBuiltin();
        AST.globalFunction.addFunction(LE);
    }

    private static void setLEEQ() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType LEEQ = new FunctionType("_builtin_LEEQ", BoolType.getInstance(), paralist);
        LEEQ.setBuiltin();
        AST.globalFunction.addFunction(LEEQ);
    }

    private static void setGR() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType GR = new FunctionType("_builtin_GR", BoolType.getInstance(), paralist);
        GR.setBuiltin();
        AST.globalFunction.addFunction(GR);
    }

    private static void setGREQ() {
        List<Symbol> paralist = new Vector<>();
        paralist.add(new Symbol("string1", StringType.getInstance()));
        paralist.add(new Symbol("string2", StringType.getInstance()));
        FunctionType GREQ = new FunctionType("_builtin_GREQ", BoolType.getInstance(), paralist);
        GREQ.setBuiltin();
        AST.globalFunction.addFunction(GREQ);
    }

}
