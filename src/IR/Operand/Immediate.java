package IR.Operand;

public class Immediate extends Operand {
    public int value;

    public Immediate(int _value) {
        this.value = _value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
