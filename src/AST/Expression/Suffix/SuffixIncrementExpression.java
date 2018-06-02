package AST.Expression.Suffix;

import AST.Expression.BaseExpression;
import AST.Type.IntType;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.MoveInstruction;
import IR.Instruction.UnaryInstruction;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;

public class SuffixIncrementExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private SuffixIncrementExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no suffix increment for [" + _objectExpression.getType().toString() + "]");
        }
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("Object should be a left-value for suffix increment");
        }
        return new SuffixIncrementExpression(_objectExpression);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        objectExpression.generateIR(instructionList);
        this.setOperand(VirtualRegisterManager.getTemporaryRegister());
        instructionList.add(new MoveInstruction(this.getOperand(), objectExpression.getOperand()));
        instructionList.add(new UnaryInstruction(Operator.UnaryOp.INC, objectExpression.getOperand()));
    }
}
