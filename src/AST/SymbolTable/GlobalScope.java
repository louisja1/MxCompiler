package AST.SymbolTable;

public class GlobalScope implements Scope {
    @Override
    public String getName() {
        return "Global";
    }
}
