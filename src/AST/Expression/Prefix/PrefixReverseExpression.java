package AST.Expression.Prefix;

import AST.Expression.BaseExpression;
import Error.CompilationError;
import AST.Type.IntType;
import IR.Instruction.*;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;

public class PrefixReverseExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixReverseExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no prefix reverse for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixReverseExpression(_objectExpression);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        objectExpression.generateIR(instructionList);
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new MoveInstruction(result, objectExpression.getOperand()));
        instructionList.add(new UnaryInstruction(Operator.UnaryOp.REV, result));
        this.setOperand(result);
    }
}
