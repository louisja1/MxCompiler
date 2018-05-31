package IR.Operand;

import IR.IR;

public class VirtualRegister extends Operand {
    public String name;
    public String physicalRegisterName;
    public boolean global;

    public VirtualRegister(String _name) {
        this.name = _name;
        this.physicalRegisterName = null;
        this.global = false;
    }

    public void setGlobal(String _globalRegName) {
        this.physicalRegisterName = _globalRegName;
        this.global = true;
    }

    public void setPhysicalRegisterName(String _physicalRegisterName) {
        this.physicalRegisterName = _physicalRegisterName;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (IR.currentFunction != null && IR.currentFunction.registerMap.containsKey(this)) {
            return "$" + name + "(" + IR.currentFunction.registerMap.get(this) + ")";
        } else {
            return "$" + name + "(" + physicalRegisterName + ")";
        }
    }
}
