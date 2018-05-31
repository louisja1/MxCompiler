package AST.Expression.Prefix;

import AST.Expression.BaseExpression;
import Error.CompilationError;
import AST.Type.IntType;
import IR.Instruction.BaseInstruction;

import java.util.List;

public class PrefixPlusExpression extends BaseExpression {
    private BaseExpression objectExpression;

    private PrefixPlusExpression(BaseExpression _objectExpression) {
        super(_objectExpression.getType(), false);
        this.objectExpression = _objectExpression;
    }

    public BaseExpression getObjectExpression() {
        return objectExpression;
    }

    public static BaseExpression getExpression(BaseExpression _objectExpression) {
        if (_objectExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("There is no prefix plus for [" + _objectExpression.getType().toString() + "]");
        }
        return new PrefixPlusExpression(_objectExpression);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(objectExpression.getOperand());
    }
}
