package AST.Statement;

import AST.Constant.BoolConstant;
import AST.Expression.BaseExpression;
import AST.Type.BoolType;
import Error.CompilationError;
import IR.Instruction.*;
import IR.Operand.Immediate;
import Other.Operator;

import java.util.List;

public class ForStatement extends LoopStatement {
    private BaseExpression initiate, condition, variance;
    private BaseStatement statement;

    public ForStatement() {
        this.initiate = null;
        this.condition = new BoolConstant(true);
        this.variance = null;
        this.statement = null;
    }

    public void addInitiate(BaseExpression _initiate) {
        this.initiate = _initiate;
    }

    public void addCondition(BaseExpression _condition) {
        if (!(_condition.getType() == BoolType.getInstance())) {
            throw new CompilationError("The condition expression of for statement is not a bool type");
        }
        this.condition = _condition;
    }

    public void addVariance(BaseExpression _variance) {
        this.variance = _variance;
    }

    public void addStatement(BaseStatement _statement) {
        this.statement = _statement;
    }

    public BaseExpression getCondition() {
        return condition;
    }

    public BaseExpression getInitiate() {
        return initiate;
    }

    public BaseExpression getVariance() {
        return variance;
    }

    public BaseStatement getStatement() {
        return statement;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.loopConditionLabel = new LabelInstruction("loop_condition");
        this.loopBodyLabel = new LabelInstruction("loop_body");
        this.loopNextLabel = new LabelInstruction("loop_next");
        this.loopExitLabel = new LabelInstruction("loop_exit");

        if (initiate != null) {
            initiate.generateIR(instructionList);
        }
        instructionList.add(new JumpInstruction(loopConditionLabel));

        instructionList.add(loopConditionLabel);
        condition.generateIR(instructionList);
        instructionList.add(new CompareInstruction(condition.getOperand(), new Immediate(1)));
        instructionList.add(new CjumpInstruction(Operator.ConditionOp.EQ, loopBodyLabel));
        instructionList.add(new JumpInstruction(loopExitLabel));

        instructionList.add(loopBodyLabel);
        if (statement != null) {
            statement.generateIR(instructionList);
        }
        instructionList.add(new JumpInstruction(loopNextLabel));

        instructionList.add(loopNextLabel);
        if (variance != null) {
            variance.generateIR(instructionList);
        }
        instructionList.add(new JumpInstruction(loopConditionLabel));

        instructionList.add(loopExitLabel);
    }
}
