package AST.Statement;

import AST.Constant.BoolConstant;
import AST.Expression.BaseExpression;
import AST.Type.BoolType;
import Error.CompilationError;
import IR.Instruction.*;
import IR.Operand.Immediate;
import Other.Operator;

import java.util.List;

public class WhileStatement extends LoopStatement {
    private BaseExpression condition;
    private BaseStatement statement;

    public WhileStatement() {
        this.condition = new BoolConstant(true);
        this.statement = null;
    }

    public void addCondition(BaseExpression _condition) {
        if (!(_condition.getType() instanceof BoolType)) {
            throw new CompilationError("The condition of while statement should be boolean");
        }
        this.condition = _condition;
    }

    public void addStatement(BaseStatement _statement) {
        this.statement = _statement;
    }

    public BaseStatement getStatement() {
        return statement;
    }

    public BaseExpression getCondition() {
        return condition;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.loopConditionLabel = new LabelInstruction("loop_condition");
        this.loopBodyLabel = new LabelInstruction("loop_body");
        this.loopNextLabel = this.loopConditionLabel;
        this.loopExitLabel = new LabelInstruction("loop_exit");

        instructionList.add(new JumpInstruction(loopConditionLabel));

        instructionList.add(loopConditionLabel);
        if (condition != null) {
            condition.generateIR(instructionList);
        }
        instructionList.add(new CompareInstruction(condition.getOperand(), new Immediate(1)));
        instructionList.add(new CjumpInstruction(Operator.ConditionOp.EQ, loopBodyLabel));
        instructionList.add(new JumpInstruction(loopExitLabel));

        instructionList.add(loopBodyLabel);
        if (statement != null) {
            statement.generateIR(instructionList);
        }
        instructionList.add(new JumpInstruction(loopConditionLabel));

        instructionList.add(loopExitLabel);
    }
}
