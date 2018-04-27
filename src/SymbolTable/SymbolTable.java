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
            //System.out.println("enter loop");
            loopStack.push((LoopStatement) scope);
        }
        if (scope instanceof FunctionType) {
            //System.out.println(((FunctionType) scope).getRawName());
            //System.out.println("enter function");
            currentFunction = (FunctionType) scope;
        }
        if (scope instanceof ClassType) {
            //System.out.println("enter class");
            currentClass = (ClassType) scope;
        }
        scopeStack.push(scope);
        localTable.push(new HashMap<String, Symbol>());
    }

    public void exitScope() {
        Scope last = scopeStack.peek();
        if (last instanceof LoopStatement) {
            //System.out.println("exit loop");
            loopStack.pop();
        }
        if (last instanceof FunctionType) {
            //System.out.println(((FunctionType) last).getRawName());
            //System.out.println("exit function");
            currentFunction = null;
        }
        if (last instanceof ClassType) {
            //System.out.println("exit class");
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
