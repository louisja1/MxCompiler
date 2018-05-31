package AST.Expression.Relation;

import AST.Constant.BoolConstant;
import AST.Constant.IntConstant;
import AST.Constant.NullConstant;
import AST.Constant.StringConstant;
import AST.Expression.BaseExpression;
import AST.Expression.FunctionExpression;
import AST.Expression.IdentifierExpression;
import AST.Type.BaseType;
import AST.Type.BoolType;
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

public class NotEqualExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private NotEqualExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
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
        if (!firstType.beCompatibleWith(secondType)) {
            throw new CompilationError("There is a pair of unmatched expression for not equal expression");
        }
        if (_firstExpression instanceof BoolConstant && _secondExpression instanceof BoolConstant) {
            return new BoolConstant(((BoolConstant) _firstExpression).getValue() != ((BoolConstant) _secondExpression).getValue());
        }
        if (_firstExpression instanceof IntConstant && _secondExpression instanceof IntConstant) {
            return new BoolConstant(((IntConstant) _firstExpression).getValue() != ((IntConstant) _secondExpression).getValue());
        }
        if (_firstExpression instanceof NullConstant && _secondExpression instanceof NullConstant) {
            return new BoolConstant(false);
        }
        if (_firstExpression instanceof StringConstant && _secondExpression instanceof StringConstant) {
            return new BoolConstant(!((StringConstant) _firstExpression).getValue().equals(((StringConstant) _secondExpression).getValue()));
        }
        if (firstType == StringType.getInstance() && secondType == StringType.getInstance()) {
            List<BaseExpression> expressionList = new Vector<>();
            expressionList.add(_firstExpression);
            expressionList.add(_secondExpression);
            return FunctionExpression.getExpression(IdentifierExpression.getExpression("_builtin_NEQ"), expressionList);
        }
        return new NotEqualExpression(_firstExpression, _secondExpression);
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
        if (first instanceof Address && second instanceof Address) {
            VirtualRegister media = VirtualRegisterManager.getTemporaryRegister();
            instructionList.add(new MoveInstruction(media, first));
            instructionList.add(new CompareInstruction(media, second));
        } else {
            instructionList.add(new CompareInstruction(first, second));
        }
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new CsetInstruction(Operator.ConditionOp.NEQ, result));
        this.setOperand(result);
    }
}
