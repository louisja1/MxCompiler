package AST.Statement;

import AST.Expression.BaseExpression;
import AST.Type.BoolType;
import Error.CompilationError;
import IR.Instruction.*;
import IR.Operand.Immediate;
import Other.Operator;

import java.util.List;

public class IfStatement extends BaseStatement {
    private BaseExpression condition;
    private BaseStatement trueStatement, falseStatement;

    public IfStatement(BaseExpression _condition, BaseStatement _trueStatemnt) {
        if (_condition.getType() != BoolType.getInstance()) {
            throw new CompilationError("The condition expression for if statement is not a bool type");
        }
        this.condition = _condition;
        this.trueStatement = _trueStatemnt;
        this.falseStatement = null;
    }

    public void addFalseStatement(BaseStatement _falseStatement) {
        this.falseStatement = _falseStatement;
    }

    public BaseExpression getConditionn() {
        return this.condition;
    }

    public BaseStatement getTrueStatemnt() {
        return this.trueStatement;
    }

    public BaseStatement getFalseStatement() {
        return this.falseStatement;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        LabelInstruction ifTrueLabel = new LabelInstruction("if_true");
        LabelInstruction ifFalseLabel = new LabelInstruction("if_false");
        LabelInstruction ifExitLabel = new LabelInstruction("if_exit");

        if (condition != null) {
            condition.generateIR(instructionList);
        }
        instructionList.add(new CompareInstruction(condition.getOperand(), new Immediate(1)));
        instructionList.add(new CjumpInstruction(Operator.ConditionOp.EQ, ifTrueLabel));
        instructionList.add(new JumpInstruction(ifFalseLabel));

        instructionList.add(ifTrueLabel);
        if (trueStatement != null) {
            trueStatement.generateIR(instructionList);
        }
        instructionList.add(new JumpInstruction(ifExitLabel));

        instructionList.add(ifFalseLabel);
        if (falseStatement != null) {
            falseStatement.generateIR(instructionList);
        }
        instructionList.add(new JumpInstruction(ifExitLabel));

        instructionList.add(ifExitLabel);
    }
}

/*
    %... :
        (condition)
        cmp condition true
        cjump EQ if_true
        jump if_false
    %if_true :
        (true_statement)
        jump if_Exit
    %if_false :
        (false_statement)
        jump if_exit
    %if_exit :
        ...

*/