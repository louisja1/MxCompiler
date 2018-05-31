package AST.Expression;

import AST.Type.ArrayType;
import AST.Type.BaseType;
import AST.Type.ClassType;
import Error.CompilationError;
import AST.Type.NonArrayType;
import IR.Instruction.*;
import IR.Operand.Address;
import IR.Operand.Immediate;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import Other.Operator;
import IR.VirtualRegisterManager;

import java.util.List;
import java.util.Vector;

public class NewExpression extends BaseExpression {
    private List<BaseExpression> expressions;

    private NewExpression(BaseType type, List<BaseExpression> _expressions) {
        super(type, false);
        this.expressions = _expressions;
    }

    public static BaseExpression getExpression(BaseType _type, List<BaseExpression> _expressions) {
        int size = _expressions.size();
        if (size == 0) {
            //new type;
            if (!(_type instanceof ClassType)) {
                throw new CompilationError("It is forbidden to new a [" + _type.getTypeName() + "] type");
            }
            return new NewExpression(_type, _expressions);
        } else {
            //new type [][]
            boolean first = true;
            boolean acceptive = true;
            boolean restarenull = false;
            for (BaseExpression expression : _expressions) {
                if (first == true) {
                    first = false;
                    if (expression == null) {
                        acceptive = false;
                        break;
                    }
                }
                if (restarenull) {
                    if (expression != null) {
                        acceptive = false;
                        break;
                    }
                } else {
                    if (expression == null) {
                        restarenull = true;
                    }
                }
            }
            if (acceptive == false) {
                throw new CompilationError("It is an error format for new array expression");
            }
            BaseType current = new ArrayType((NonArrayType) _type, size);
            return new NewExpression(current, _expressions);
        }
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        this.setOperand(VirtualRegisterManager.getTemporaryRegister());
        List<Operand> operandList = new Vector<>();
        for (int i = 0; i < expressions.size(); i++) {
            BaseExpression expression = expressions.get(i);
            if (expression == null) continue;
            expression.generateIR(instructionList);
            operandList.add(expression.getOperand());
        }
        allocate((VirtualRegister) this.getOperand(), getType(), operandList, instructionList);
    }

    private void allocate(VirtualRegister base, BaseType type, List<Operand> operandList, List<BaseInstruction> instructionList) {
        if (type instanceof ClassType) {
            instructionList.add(new AllocateInstruction(base, new Immediate(((ClassType) type).getAllocateSize())));
            if (((ClassType) type).getConstructionFunction() != null) {
                List<Operand> parameterList = new Vector<>();
                VirtualRegister reg = VirtualRegisterManager.getTemporaryRegister();
                reg.setPhysicalRegisterName(VirtualRegisterManager.parameterRegList.get(0));

                instructionList.add(new MoveInstruction(reg, base));
                instructionList.add(new FunctionCallInstruction(((ClassType) type).getConstructionFunction(), null, parameterList));
            }
        } else {
            VirtualRegister allocateSize = VirtualRegisterManager.getTemporaryRegister();
            instructionList.add(new MoveInstruction(allocateSize, operandList.get(0)));
            instructionList.add(new UnaryInstruction(Operator.UnaryOp.INC, allocateSize));
            instructionList.add(new BinaryInstruction(Operator.BinaryOp.SHL, allocateSize, new Immediate(3)));
            instructionList.add(new AllocateInstruction(base, allocateSize));

            if (operandList.get(0) instanceof Address) {
                VirtualRegister tmp = VirtualRegisterManager.getTemporaryRegister();
                instructionList.add(new MoveInstruction(tmp, operandList.get(0)));
                instructionList.add(new MoveInstruction(new Address(base), tmp));
            } else {
                instructionList.add(new MoveInstruction(new Address(base), operandList.get(0)));
            }

            instructionList.add(new BinaryInstruction(Operator.BinaryOp.ADD, base, new Immediate(8)));
            BaseType nextType = ((ArrayType) type).reduceDimension();
            operandList.remove(0);

            if (nextType instanceof ClassType || !operandList.isEmpty()) {
                LabelInstruction allocate_body = new LabelInstruction("allocate_body");
                LabelInstruction allocate_condition = new LabelInstruction("allocate_condition");
                LabelInstruction allocate_exit = new LabelInstruction("allocate_exit");

                VirtualRegister cur = VirtualRegisterManager.getTemporaryRegister();
                VirtualRegister lst = VirtualRegisterManager.getTemporaryRegister();

                instructionList.add(new MoveInstruction(cur, base));
                instructionList.add(new MoveInstruction(lst, base));
                instructionList.add(new BinaryInstruction(Operator.BinaryOp.SUB, allocateSize, new Immediate(8)));
                instructionList.add(new BinaryInstruction(Operator.BinaryOp.ADD, lst, allocateSize));
                instructionList.add(new JumpInstruction(allocate_condition));

                instructionList.add(allocate_body);
                VirtualRegister tmp = VirtualRegisterManager.getTemporaryRegister();
                instructionList.add(new MoveInstruction(tmp, new Address(cur)));
                allocate(tmp, nextType, operandList, instructionList);
                instructionList.add(new MoveInstruction(new Address(cur), tmp));
                instructionList.add(new BinaryInstruction(Operator.BinaryOp.ADD, cur, new Immediate(8)));
                instructionList.add(new JumpInstruction(allocate_condition));

                instructionList.add(allocate_condition);
                instructionList.add(new CompareInstruction(cur, lst));
                instructionList.add(new CjumpInstruction(Operator.ConditionOp.LE, allocate_body));
                instructionList.add(new JumpInstruction(allocate_exit));

                instructionList.add(allocate_exit);
            }
        }
    }
                /*
					%...:
						(init : cur , lst)
						jump %allocate_condition
					%allocate_body:
						(statement)
						(allocate_increment)
						jump %allocate_condition
					%allocate_condition:
						cmp pos end
						cjump LE bodyLabel
						jump exitLabel
					%allocate_exit:
						...
				*/
}
