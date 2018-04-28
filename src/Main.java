import Constructor.AST;
import Constructor.ClassNameListener;
import Constructor.DeclarationListener;
import Constructor.TreeListener;
import Parser.MxStarLexer;
import Parser.MxStarParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import Error.CompilationError;
import Error.MxStarErrorListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        //File file = new File("program.txt");
        InputStream fin = System.in;/*new FileInputStream(file);*/
        buildAST(fin);
    }

    public static void buildAST(InputStream fin) throws Exception {
        CharStream input = CharStreams.fromStream(fin);
        MxStarLexer lexer = new MxStarLexer(input);
        lexer.addErrorListener(MxStarErrorListener.getInstance());
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MxStarParser parser = new MxStarParser(tokens);
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
        System.exit(0);
    }
}
