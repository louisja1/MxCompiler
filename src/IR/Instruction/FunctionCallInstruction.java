package IR.Instruction;

import AST.Type.FunctionType;
import Generater.Generater;
import Generater.PhysicalOperand.PhysicalBaseOperand;
import IR.Operand.Address;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;
import IR.VirtualRegisterManager;

import java.util.List;
import java.util.Vector;

public class FunctionCallInstruction extends BaseInstruction {
    public FunctionType function;
    public VirtualRegister returnValue;
    public List<Operand> parameterList;

    public FunctionCallInstruction(FunctionType _function, VirtualRegister _returnValue, List<Operand> _parameterList) {
        this.function = _function;
        this.returnValue = _returnValue;
        this.parameterList = _parameterList;
        livenessAnalysis();
    }

    private void livenessAnalysis() {
        if (returnValue != null) {
            defSet.add(returnValue);
        }
        for (Operand tmp : parameterList) {
            if (tmp instanceof VirtualRegister) {
                useSet.add((VirtualRegister) tmp);
            } else if (tmp instanceof Address) {
                useSet.add(((Address) tmp).base);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("call " + function.getName());
        for (Operand tmp : parameterList) {
            str.append(" " + tmp);
        }
        return str.toString();
    }

    @Override
    public void prepareRegister() {
        VirtualRegisterManager.markUsedOperand(returnValue);
        for (int i = 0; i < parameterList.size(); i++) {
            VirtualRegisterManager.markUsedOperand(parameterList.get(i));
        }
    }

    @Override
    public String toNASM() {
        StringBuilder str = new StringBuilder();
        str.append(Generater.pushCaller(Generater.currentFunction.usedCallerRegisterList));

        boolean flag = false;
        int numToMemory = parameterList.size();
        if ((Generater.rsp + numToMemory) % 2 == 1) {
            str.append(Generater.formatInstruction("sub", "rsp", "8"));
            Generater.rsp ++;
            flag = true;
        }

        for (int i = parameterList.size() - 1; i >= 0; i--) {
            PhysicalBaseOperand physicalParameter = PhysicalBaseOperand.get(str, parameterList.get(i));
            str.append(Generater.formatInstruction("push", physicalParameter.toString()));
        }

        str.append(Generater.formatInstruction("call", function.getName()));

        if (flag) {
            numToMemory += 1;
        }
        Generater.rsp -= numToMemory;
        if (numToMemory > 0) {
            str.append(Generater.formatInstruction("add", "rsp", String.valueOf(8 * numToMemory)));
        }

        str.append(Generater.popCaller(Generater.currentFunction.usedCallerRegisterList));

        return str.toString();
    }
}
