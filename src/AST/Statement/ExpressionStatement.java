package AST.Statement;

import AST.Expression.BaseExpression;
import IR.Instruction.BaseInstruction;

import java.util.List;

public class ExpressionStatement extends BaseStatement {
    private BaseExpression expression;

    public ExpressionStatement(BaseExpression _expression) {
        this.expression = _expression;
    }

    public BaseExpression getExpression() {
        return expression;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        if (expression == null) return;
        expression.generateIR(instructionList);
    }
}
