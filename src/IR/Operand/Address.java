package IR.Operand;

public class Address extends Operand {
    public VirtualRegister base;
    public Immediate offset;

    public Address(VirtualRegister _base) {
        this.base = _base;
        this.offset = new Immediate(0);
    }

    public Address(VirtualRegister _base, Immediate _offset) {
        this.base = _base;
        this.offset = _offset;
    }

    @Override
    public String toString() {
        return String.format("Address(%s + %s)", base, offset);
    }
}
