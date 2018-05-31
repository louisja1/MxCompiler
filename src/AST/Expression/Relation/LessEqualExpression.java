package AST.Expression.Relation;

import AST.Constant.BoolConstant;
import AST.Constant.IntConstant;
import AST.Constant.StringConstant;
import AST.Expression.BaseExpression;
import AST.Expression.FunctionExpression;
import AST.Expression.IdentifierExpression;
import AST.Type.BaseType;
import AST.Type.BoolType;
import AST.Type.IntType;
import AST.Type.StringType;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.CompareInstruction;
import IR.Instruction.CsetInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.Address;
import IR.Operand.Immediate;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;
import java.util.Vector;

public class LessEqualExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private LessEqualExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
        super(BoolType.getInstance(), false);
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
                return new BoolConstant(((IntConstant) _firstExpression).getValue() <= ((IntConstant) _secondExpression).getValue());
            }
            return new LessEqualExpression(_firstExpression, _secondExpression);
        }
        if (firstType == StringType.getInstance() && secondType == StringType.getInstance()) {
            if (_firstExpression instanceof StringConstant && _secondExpression instanceof StringConstant) {
                return new BoolConstant(((StringConstant) _firstExpression).getValue().compareTo(((StringConstant) _secondExpression).getValue()) <= 0);
            }
            List<BaseExpression> expressionList = new Vector<>();
            expressionList.add(_firstExpression);
            expressionList.add(_secondExpression);
            return FunctionExpression.getExpression(IdentifierExpression.getExpression("_builtin_LEEQ"), expressionList);
        }
        throw new CompilationError("There is an invalid less equal expression");
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        firstExpression.generateIR(instructionList);
        secondExpression.generateIR(instructionList);
        Operand first =  firstExpression.getOperand();
        Operand second = secondExpression.getOperand();
        if (first == second) {
            this.setOperand(new Immediate(1));
            return;
        }
        if (first instanceof Immediate && second instanceof Immediate && ((Immediate) first).value == ((Immediate) second).value) {
            this.setOperand(new Immediate(1));
            return;
        }
        if (first instanceof Address && second instanceof Address) {
            VirtualRegister media = VirtualRegisterManager.getTemporaryRegister();
            instructionList.add(new MoveInstruction(media, first));
            instructionList.add(new CompareInstruction(media, second));
        } else {
            instructionList.add(new CompareInstruction(first, second));
        }
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new CsetInstruction(Operator.ConditionOp.LEEQ, result));
        this.setOperand(result);
    }
}
