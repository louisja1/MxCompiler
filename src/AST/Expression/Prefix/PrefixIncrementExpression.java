package AST.Expression.Prefix;

import AST.Expression.BaseExpression;
import AST.Type.IntType;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.UnaryInstruction;
import Other.Operator;

import java.util.List;

public class PrefixIncrementExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixIncrementExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), true);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getobjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no suffix increment for [" + _objectExpression.getType().toString() + "]");
        }
        if (!_objectExpression.isLeftValue()) {
            throw new CompilationError("Object should be a left-value for prefix increment");
        }
        return new PrefixIncrementExpression(_objectExpression);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        objectExpression.generateIR(instructionList);
        this.setOperand(objectExpression.getOperand());
        instructionList.add(new UnaryInstruction(Operator.UnaryOp.INC, this.getOperand()));
    }
}
