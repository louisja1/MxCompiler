import AST.Constructor.AST;
import AST.Constructor.ClassNameListener;
import AST.Constructor.DeclarationListener;
import AST.Constructor.TreeListener;
import Optimizer.Optimizer;
import Parser.MxStarLexer;
import Parser.MxStarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import Error.CompilationError;
import AST.Constructor.MxStarErrorListener;
import IR.IR;
import Generater.Generater;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        //File file = new File("program.txt");
        InputStream fin = System.in;
        //InputStream fin = new FileInputStream(file);
        buildAST(fin);
        generateIR();
        optimize();
        codegen();
        //System.exit(0);
    }

    public static void buildAST(InputStream fin) throws Exception {
        CharStream input = CharStreams.fromStream(fin);
        MxStarLexer lexer = new MxStarLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(MxStarErrorListener.getInstance());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxStarParser parser = new MxStarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(MxStarErrorListener.getInstance());
        try {
            ParseTree tree = parser.program();
            AST.init();
            AST.setBuiltinFunction();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new ClassNameListener(), tree);
            walker.walk(new DeclarationListener(), tree);
            walker.walk(new TreeListener(), tree);
        } catch (CompilationError ce) {
            System.out.println(ce.getMessage());
            System.exit(1);
        }
    }

    public static void generateIR() throws Exception {
        IR.init();
        IR.generateIR();
        IR.printIR();
    }

    public static void codegen() throws Exception {
        Generater.codegen();
    }

    public static void optimize() throws Exception {
        Optimizer.optimize();
    }
}
