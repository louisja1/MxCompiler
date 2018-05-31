package Generater.PhysicalOperand;

public class PhysicalImmediate extends PhysicalBaseOperand {
    public int value;

    public PhysicalImmediate(int _value) {
        this.value = _value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
