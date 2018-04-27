package SymbolTable;

import Type.BaseType;

public class Symbol {
    private String name;
    private BaseType type;
    public Scope classScope;
    public boolean global;

    public Symbol(String _name, BaseType _type) {
        this.name = _name;
        this.type = _type;
        this.classScope = null;
        this.global = false;
    }

    public void setGlobal() {
        this.global = true;
    }

    public String getName() {
        return this.name;
    }

    public BaseType getType() {
        return this.type;
    }
}
