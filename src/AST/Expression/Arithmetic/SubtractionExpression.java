package AST.Expression.Arithmetic;

import AST.Constant.IntConstant;
import AST.Expression.BaseExpression;
import AST.Type.BaseType;
import AST.Type.IntType;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.BinaryInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.Immediate;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;

public class SubtractionExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private SubtractionExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        super(IntType.getInstance(), false);
        this.firstExpression = _firstExpression;
        this.secondExpression = _secondExpression;
    }

    public BaseExpression getSecondExpression() {
        return secondExpression;
    }

    public BaseExpression getFirstExpression() {
        return firstExpression;
    }

    public static BaseExpression getExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        BaseType firstType = _firstExpression.getType();
        BaseType secondType = _secondExpression.getType();
        if (firstType == IntType.getInstance() && secondType == IntType.getInstance()) {
            if (_firstExpression instanceof IntConstant && _secondExpression instanceof IntConstant) {
                return new IntConstant(((IntConstant) _firstExpression).getValue() - ((IntConstant) _secondExpression).getValue());
            }
            return new SubtractionExpression(_firstExpression, _secondExpression);
        }
        throw new CompilationError("There is an invalid subtraction expression");
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        firstExpression.generateIR(instructionList);
        secondExpression.generateIR(instructionList);
        Operand first =  firstExpression.getOperand();
        Operand second = secondExpression.getOperand();
        if (first == second) {
            this.setOperand(new Immediate(0));
            return;
        }
        if (first instanceof Immediate && second instanceof Immediate && ((Immediate) first).value == ((Immediate) second).value) {
            this.setOperand(new Immediate(0));
            return;
        }
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new MoveInstruction(result, first));
        instructionList.add(new BinaryInstruction(Operator.BinaryOp.SUB, result, second));
        this.setOperand(result);
    }
}
