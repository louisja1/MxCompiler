package Generater.PhysicalOperand;

public class PhysicalRegister extends PhysicalBaseOperand {
    public String regName;

    public PhysicalRegister(String _regName) {
        this.regName = _regName;
    }

    @Override
    public String toString() {
        return regName;
    }
}
