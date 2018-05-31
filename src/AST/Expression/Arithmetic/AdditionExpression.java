package AST.Expression.Arithmetic;

import AST.Constant.IntConstant;
import AST.Constant.StringConstant;
import AST.Expression.BaseExpression;
import AST.Expression.FunctionExpression;
import AST.Expression.IdentifierExpression;
import AST.Type.BaseType;
import AST.Type.IntType;
import AST.Type.StringType;
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
import java.util.Vector;

public class AdditionExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private AdditionExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        super(_firstExpression.getType(), false);
        this.firstExpression = _firstExpression;
        this.secondExpression = _secondExpression;
    }

    public BaseExpression getFirstExpression() {
        return firstExpression;
    }

    public BaseExpression getSecondExpression() {
        return secondExpression;
    }

    public static BaseExpression getExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        BaseType firstType = _firstExpression.getType();
        BaseType secondType = _secondExpression.getType();
        if (firstType == IntType.getInstance() && secondType == IntType.getInstance()) {
            if (_firstExpression instanceof IntConstant && _secondExpression instanceof IntConstant) {
                return new IntConstant(((IntConstant) _firstExpression).getValue() + ((IntConstant) _secondExpression).getValue());
            }
            return new AdditionExpression(_firstExpression, _secondExpression);
        }
        if (firstType == StringType.getInstance() && secondType == StringType.getInstance()) {
            if (_firstExpression instanceof StringConstant && _secondExpression instanceof StringConstant) {
                return new StringConstant(((StringConstant) _firstExpression).getValue() + ((StringConstant) _secondExpression).getValue());
            }
            List<BaseExpression> expressionList = new Vector<>();
            expressionList.add(_firstExpression);
            expressionList.add(_secondExpression);
            return FunctionExpression.getExpression(IdentifierExpression.getExpression("_builtin_add"), expressionList);
        }
        throw new CompilationError("There is an invalid addition expression");
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        firstExpression.generateIR(instructionList);
        secondExpression.generateIR(instructionList);
        Operand first =  firstExpression.getOperand();
        Operand second = secondExpression.getOperand();
        if (first instanceof Immediate && ((Immediate) first).value == 0) {
            this.setOperand(second);
            return;
        }
        if (second instanceof Immediate && ((Immediate) second).value == 0) {
            this.setOperand(first);
            return;
        }
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new MoveInstruction(result, first));
        instructionList.add(new BinaryInstruction(Operator.BinaryOp.ADD, result, second));
        this.setOperand(result);
    }
}
