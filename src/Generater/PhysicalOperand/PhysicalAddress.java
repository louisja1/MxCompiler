package Generater.PhysicalOperand;

public class PhysicalAddress extends PhysicalBaseOperand {
    public String base;
    public int offset;

    public PhysicalAddress(String _base, int _offset) {
        this.base = _base;
        this.offset = _offset;
    }

    @Override
    public String toString() {
        if (offset < 0) {
            return String.format("qword [%s - %d]", base, -offset);
        }
        if (offset > 0) {
            return String.format("qword [%s + %d]", base, offset);
        }
        return String.format("qword [%s]", base);
    }
}
