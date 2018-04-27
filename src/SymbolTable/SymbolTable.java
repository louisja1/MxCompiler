package SymbolTable;

import Statement.LoopStatement;
import Type.ClassType;
import Type.FunctionType;
import Error.CompilationError;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class SymbolTable {
    private FunctionType currentFunction;
    private ClassType currentClass;
    private Stack<Scope> scopeStack;
    private Stack<LoopStatement> loopStack;
    private Stack<HashMap<String, Symbol>> localTable;
    private HashMap<String, Stack<Symbol>> symbolHistory;

    public SymbolTable() {
        currentFunction = null;
        currentClass = null;
        scopeStack = new Stack<>();
        loopStack = new Stack<>();
        localTable = new Stack<>();
        symbolHistory = new HashMap<>();
    }

    public LoopStatement getCurrentLoop() {
        if (loopStack.empty()) {
            return null;
        }
        return loopStack.peek();
    }

    public ClassType getCurrentClass() {
        return currentClass;
    }

    public FunctionType getCurrentFunction() {
        return currentFunction;
    }

    public Scope getCurrentScope() {
        return scopeStack.peek();
    }

    public void enterScope(Scope scope) {
        if (scope instanceof LoopStatement) {
            loopStack.push((LoopStatement) scope);
        }
        if (scope instanceof FunctionType) {
            currentFunction = (FunctionType) scope;
        }
        if (scope instanceof ClassType) {
            currentClass = (ClassType) scope;
        }
        scopeStack.push(scope);
        localTable.push(new HashMap<String, Symbol>());
    }

    public void exitScope() {
        Scope last = scopeStack.peek();
        if (last instanceof LoopStatement) {
            loopStack.pop();
        }
        if (last instanceof FunctionType) {
            currentFunction = null;
        }
        if (last instanceof ClassType) {
            currentClass = null;
        }
        scopeStack.pop();
        HashMap<String, Symbol> local = localTable.pop();
        Iterator iter = local.keySet().iterator();
        while (iter.hasNext()) {
            String name = (String) iter.next();
            symbolHistory.get(name).pop();
        }
    }

    public void addSymbol(Symbol extra) {
        String name = extra.getName();
        if (localTable.peek().containsKey(name)) {
            throw new CompilationError("There is already a symbol [" + name + "] in this scope");
        }
        if (!symbolHistory.containsKey(name)) {
            symbolHistory.put(name, new Stack<>());
        }
        localTable.peek().put(name, extra);
        symbolHistory.get(name).push(extra);
    }

    public boolean existSymbol(String name) {
        if (symbolHistory.containsKey(name) &&!symbolHistory.get(name).empty()) {
            return true;
        }
        return false;
    }

    public Symbol getSymbol(String name) {
        return symbolHistory.get(name).peek();
    }
}
