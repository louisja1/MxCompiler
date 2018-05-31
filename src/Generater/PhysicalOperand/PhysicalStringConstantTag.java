package Generater.PhysicalOperand;

public class PhysicalStringConstantTag extends PhysicalBaseOperand {
    public String tagName;

    public PhysicalStringConstantTag(String _tagName) {
        this.tagName = _tagName;
    }

    @Override
    public String toString() {
        return tagName;
    }
}
