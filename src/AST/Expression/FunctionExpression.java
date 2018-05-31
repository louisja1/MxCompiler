package AST.Expression;

import AST.SymbolTable.Symbol;
import AST.Type.BaseType;
import AST.Type.FunctionType;
import AST.Type.VoidType;
import Error.CompilationError;
import IR.Instruction.BaseInstruction;
import IR.Instruction.FunctionCallInstruction;
import IR.Instruction.LabelInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

import java.util.List;
import java.util.Vector;

public class FunctionExpression extends BaseExpression {
    private FunctionType function;
    private List<BaseExpression> expressionList;

    private FunctionExpression(FunctionType _function, List<BaseExpression> _expressionList) {
        super(_function.getReturnType(), false);
        this.function = _function;
        this.expressionList = _expressionList;
    }

    public FunctionType getFunction() {
        return function;
    }

    public List<BaseExpression> getExpressionList() {
        return expressionList;
    }

    public static BaseExpression getExpression(BaseExpression functionExpression, List<BaseExpression> expressionList) {
        if (!(functionExpression.getType() instanceof FunctionType)) {
            throw new CompilationError("There is not a function in the function call");
        }
        FunctionType function = (FunctionType) functionExpression.getType();
        if (functionExpression instanceof MemberExpression) {
            expressionList.add(0, ((MemberExpression) functionExpression).getExpression());
        } else if ((function.getClassScope() != null)) {
            expressionList.add(0, IdentifierExpression.getExpression("this"));
        }
        List<Symbol> paraList = function.getParaList();
        if (paraList.size() != expressionList.size()) {
            throw new CompilationError("There is different size between expression list and parameter list");
        }
        for (int i = 0; i < paraList.size(); i++) {
            BaseType parameterListType = paraList.get(i).getType();
            if (i == 0 && functionExpression instanceof MemberExpression && parameterListType == null) {
                continue;
            }
            BaseType expressionListType = expressionList.get(i).getType();
            if (parameterListType.beCompatibleWith(expressionListType)) {
                continue;
            }
            throw new CompilationError("There is an unmatched type between expression list and parameter list");
        }
        return new FunctionExpression(function, expressionList);
    }

    @Override
    public void generateIR(List<BaseInstruction> instructionList) {
        List<Operand> parameterList = new Vector<>();
        for (BaseExpression expression : expressionList) {
            expression.generateIR(instructionList);
            parameterList.add(expression.getOperand());
        }
        VirtualRegister returnReg = null;
        if (function.getReturnType() != VoidType.getInstance()) {
            returnReg = VirtualRegisterManager.getTemporaryRegister();
            returnReg.setPhysicalRegisterName("rax");
        }
        for (int i = 0; i < 6 && i < parameterList.size(); i++) {
            VirtualRegister reg = VirtualRegisterManager.getTemporaryRegister();
            reg.setPhysicalRegisterName(VirtualRegisterManager.parameterRegList.get(i));
            instructionList.add(new MoveInstruction(reg, parameterList.get(i)));
        }
        for (int i = 0; i < 6 && i < parameterList.size(); i++) {
            parameterList.remove(0);
        }
        instructionList.add(new FunctionCallInstruction(function, returnReg, parameterList));
        if (function.getReturnType() != VoidType.getInstance()) {
            this.setOperand(VirtualRegisterManager.getTemporaryRegister());
            instructionList.add(new MoveInstruction(this.getOperand(), returnReg));
        }
    }
}
