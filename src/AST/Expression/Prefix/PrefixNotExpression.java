package AST.Expression.Prefix;

import AST.Expression.BaseExpression;
import Error.CompilationError;
import AST.Type.BoolType;
import IR.Instruction.BaseInstruction;
import IR.Instruction.CompareInstruction;
import IR.Instruction.CsetInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.Immediate;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;

public class PrefixNotExpression extends BaseExpression{
    private BaseExpression objectExpression;

    private PrefixNotExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != BoolType.getInstance()) {
            throw new CompilationError("There is no prefix not for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixNotExpression(_objectExpression);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        objectExpression.generateIR(instructionList);
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new MoveInstruction(result, objectExpression.getOperand()));
        instructionList.add(new CompareInstruction(result, new Immediate(1)));
        instructionList.add(new CsetInstruction(Operator.ConditionOp.NEQ, result));
        this.setOperand(result);
    }
}
