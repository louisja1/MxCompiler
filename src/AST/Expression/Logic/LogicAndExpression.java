package AST.Expression.Logic;

import AST.Constant.BoolConstant;
import AST.Expression.BaseExpression;
import AST.Type.BaseType;
import AST.Type.BoolType;
import Error.CompilationError;
import IR.Instruction.*;
import IR.Operand.Immediate;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;

public class LogicAndExpression extends BaseExpression {
    private BaseExpression firstExpression, secondExpression;

    private LogicAndExpression(BaseExpression _firstExpression, BaseExpression _secondExpression) {
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
        if (firstType == BoolType.getInstance() && secondType == BoolType.getInstance()) {
            if (_firstExpression instanceof BoolConstant && _secondExpression instanceof BoolConstant) {
                return new BoolConstant(((BoolConstant) _firstExpression).getValue() && ((BoolConstant) _secondExpression).getValue());
            }
            return new LogicAndExpression(_firstExpression, _secondExpression);
        }
        throw new CompilationError("There is an invalid logic and expression");
    }

    /*
        %... :
            (first_expression)
            cmp first true
            cjump EQ logic_true
            jump logic_false
        %logic_true :
            (second_expression)
            move result second
            jump logic_exit
        %logic_false :
            move result false
            jump logic_exit
        %logic_exit :
            ...
    */

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        LabelInstruction logic_true = new LabelInstruction("logic_true");
        LabelInstruction logic_false = new LabelInstruction("logic_false");
        LabelInstruction logic_exit = new LabelInstruction("logic_exit");
        firstExpression.generateIR(instructionList);
        VirtualRegister result = VirtualRegisterManager.getTemporaryRegister();

        instructionList.add(new CompareInstruction(firstExpression.getOperand(), new Immediate(1)));
        instructionList.add(new CjumpInstruction(Operator.ConditionOp.EQ, logic_true));
        instructionList.add(new JumpInstruction(logic_false));

        instructionList.add(logic_true);
        secondExpression.generateIR(instructionList);
        instructionList.add(new MoveInstruction(result, secondExpression.getOperand()));
        instructionList.add(new JumpInstruction(logic_exit));

        instructionList.add(logic_false);
        instructionList.add(new MoveInstruction(result, new Immediate(0)));
        instructionList.add(new JumpInstruction(logic_exit));

        instructionList.add(logic_exit);
        this.setOperand(result);
    }
}
