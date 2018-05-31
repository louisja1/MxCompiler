package AST.Statement;

import AST.Expression.BaseExpression;
import AST.Type.BaseType;
import AST.Type.ClassType;
import AST.SymbolTable.Symbol;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.Address;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

import java.util.List;

public class VariableDeclarationStatement extends BaseStatement {
    private BaseType type;
    private String name;
    private BaseExpression expression;
    private ClassType classScope;
    private Symbol symbol;
    private int offset;

    public VariableDeclarationStatement(BaseType _type, String _name) {
        this.type = _type;
        this.name = _name;
        this.expression = null;
        this.classScope = null;
        this.symbol = new Symbol(_name, _type);
        this.offset = 0;
    }

    public void addExpression(BaseExpression expression) {
        if (!type.beCompatibleWith(expression.getType())) {
            throw new CompilationError("variable declaration with incompatible type");
        }
        this.expression = expression;
    }

    public void addClassScope(ClassType _classScope) {
        this.classScope = _classScope;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public BaseType getType() {
        return type;
    }

    public BaseExpression getExpression() {
        return expression;
    }

    public ClassType getClassScope() {
        return classScope;
    }

    public void setOffset(int _offset) {
        this.offset = _offset;
    }

    public int getOffset() {
        return offset;
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        if (expression != null) {
            expression.generateIR(instructionList);
            Operand target = this.symbol.getOperand();
            Operand source = expression.getOperand();
            if (target instanceof Address && source instanceof Address) {
                VirtualRegister media = VirtualRegisterManager.getTemporaryRegister();
                instructionList.add(new MoveInstruction(media, source));
                instructionList.add(new MoveInstruction(target, media));
            } else {
                instructionList.add(new MoveInstruction(target, source));
            }
        }
    }
}
