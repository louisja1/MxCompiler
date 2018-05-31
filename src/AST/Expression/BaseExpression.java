package AST.Expression;

import AST.Type.BaseType;
import IR.Instruction.BaseInstruction;
import IR.Operand.Operand;

import java.util.List;

public abstract class BaseExpression {
    public BaseType type;
    public boolean isLeftValue;
    private Operand operand;

    public BaseExpression(BaseType _type, boolean _isLeftValue) {
        this.type = _type;
        this.isLeftValue = _isLeftValue;
        this.operand = null;
    }

    public BaseType getType() {
        return this.type;
    }

    public boolean isLeftValue() {
        return this.isLeftValue;
    }

    public void setOperand(Operand _operand) {
        this.operand = _operand;
    }

    public Operand getOperand() {
        return this.operand;
    }

    public abstract void generateIR(List<BaseInstruction> instructionList);

}
