package AST.Expression;

import AST.Type.ArrayType;
import AST.Type.BaseType;
import Error.CompilationError;
import AST.Type.IntType;
import IR.Instruction.BaseInstruction;
import IR.Instruction.BinaryInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.Address;
import IR.Operand.Immediate;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;

public class ArrayExpression extends BaseExpression {
    private BaseExpression arrayExpression;
    private BaseExpression indexExpression;

    private ArrayExpression(BaseType arrayType, BaseExpression _arrayExpression, BaseExpression _indexExpression) {
        // the array type with dimension
        super(arrayType, _arrayExpression.isLeftValue());
        this.arrayExpression = _arrayExpression;
        this.indexExpression = _indexExpression;
    }

    public BaseExpression getArrayExpression() {
        return arrayExpression;
    }

    public BaseExpression getIndexExpression() {
        return indexExpression;
    }

    public static BaseExpression getExpression(BaseExpression arrayExpression, BaseExpression indexExpression) {
        if (!(arrayExpression.getType() instanceof ArrayType)) {
            throw new CompilationError("The array expression is not of array type");
        }
        if (indexExpression.getType() != IntType.getInstance()) {
            throw new CompilationError("The index expression is not of int type");
        }
        return new ArrayExpression(((ArrayType) arrayExpression.getType()).reduceDimension(), arrayExpression, indexExpression);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        arrayExpression.generateIR(instructionList);
        indexExpression.generateIR(instructionList);

        VirtualRegister offset = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new MoveInstruction(offset, indexExpression.getOperand()));
        instructionList.add(new BinaryInstruction(Operator.BinaryOp.SHL, offset, new Immediate(3)));

        VirtualRegister base = VirtualRegisterManager.getTemporaryRegister();
        instructionList.add(new MoveInstruction(base, arrayExpression.getOperand()));
        instructionList.add(new BinaryInstruction(Operator.BinaryOp.ADD, base, offset));

        this.setOperand(new Address(base));
    }
}
