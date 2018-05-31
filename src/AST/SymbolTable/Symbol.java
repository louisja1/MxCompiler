package AST.SymbolTable;

import AST.Type.BaseType;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;

public class Symbol {
    private String name;
    private BaseType type;
    public Scope classScope;
    public boolean global;
    public Operand operand;

    public Symbol(String _name, BaseType _type) {
        this.name = _name;
        this.type = _type;
        this.classScope = null;
        this.global = false;
        this.operand = new VirtualRegister(_name);
    }

    public void setGlobal() {
        this.global = true;
    }

    public void setOperand(Operand _operand) {
        this.operand = _operand;
    }

    public String getName() {
        return this.name;
    }

    public BaseType getType() {
        return this.type;
    }

    public Operand getOperand() {
        return this.operand;
    }
}
