package IR;

import AST.SymbolTable.Symbol;
import AST.Type.FunctionType;
import AST.Type.VoidType;
import Generater.Generater;
import IR.Instruction.BaseInstruction;
import IR.Instruction.JumpInstruction;
import IR.Instruction.LabelInstruction;
import IR.Instruction.MoveInstruction;
import IR.Operand.VirtualRegister;
import Other.Indent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class FunctionIR {
    public FunctionType function;
    public List<VirtualRegister> parameterList;
    public List<Block> blockList;
    public LabelInstruction enterBlock, exitBlock;
    public Map<VirtualRegister, String> registerMap;
    public Map<VirtualRegister, Integer> idMap;

    public List<String> usedCalleeRegisterList;
    public List<String> usedCallerRegisterList;

    public FunctionIR(FunctionType _function) {
        this.function = _function;
        this.parameterList = new Vector<>();
        for (Symbol tmp : function.getParaList()) {
            parameterList.add((VirtualRegister) tmp.operand);
        }
        this.blockList = new Vector<>();
        this.registerMap = new HashMap<>();
        this.idMap = new HashMap<>();

        this.enterBlock = new LabelInstruction("enter");
        this.exitBlock = new LabelInstruction("exit");
        function.setLabel(enterBlock, exitBlock);

        List<BaseInstruction> instructionList = new Vector<>();
        instructionList.add(enterBlock);
        for (int i = 0; i < parameterList.size(); i++) {
            if (i < 6) {
                VirtualRegister tmp = VirtualRegisterManager.getTemporaryRegister();
                tmp.physicalRegisterName = VirtualRegisterManager.parameterRegList.get(i);
                instructionList.add(new MoveInstruction(parameterList.get(i), tmp));
                registerMap.put(tmp, tmp.physicalRegisterName);
            } else {
                idMap.put(parameterList.get(i), new Integer(4 - i));
            }
        }
        function.getBlockStatement().generateIR(instructionList);
        if (instructionList.size() == 1 || !(instructionList.get(instructionList.size() - 1) instanceof JumpInstruction)) {
            instructionList.add(new JumpInstruction(exitBlock));
        }
        instructionList.add(exitBlock);

        for (int i = 0, j; i < instructionList.size(); i = j) {
            LabelInstruction label = (LabelInstruction) instructionList.get(i);
            Block block = new Block(this, label.getName(), blockList.size(), label);
            for (j = i + 1; j < instructionList.size(); j++) {
                BaseInstruction instruction = instructionList.get(j);
                if (instruction instanceof LabelInstruction) break;
                block.addInstruction(instruction);
            }
            label.setBlock(block);
            blockList.add(block);
        }

    }

    public String getName() {
        return function.getName();
    }

    public String toString(int cnt) {
        StringBuilder str = new StringBuilder();
        str.append(Indent.appendIndent(cnt));
        if (function.getReturnType() == VoidType.getInstance()) {
            str.append("void ");
        } else {
            str.append("func ");
        }
        str.append(function.getName());
        for (VirtualRegister parameter : parameterList) {
            str.append(parameter.getName());
        }
        str.append(" { \n");
        for (Block block : blockList) {
            str.append(block.toString(cnt + 1));
        }
        str.append("}\n");
        return str.toString();
    }

    public String toNASM() {
        StringBuilder str = new StringBuilder();
        str.append(function.getName() + ":\n");
        VirtualRegisterManager.initialize();

        for (Block block : blockList) {
            for (BaseInstruction instruction : block.instructionList) {
                instruction.prepareRegister();
            }
        }

        //reserved register
        usedCalleeRegisterList = new Vector<>();
        usedCallerRegisterList = new Vector<>();
        for (String reg : VirtualRegisterManager.usedRegister) {
            if (Generater.callee.contains(reg)) {
                usedCalleeRegisterList.add(reg);
            }
            if (Generater.caller.contains(reg)) {
                usedCallerRegisterList.add(reg);
            }
        }

        Generater.rsp = 1;
        str.append(Generater.formatInstruction("push","rbp"));
        str.append(Generater.formatInstruction("mov","rbp","rsp"));

        //global declaration
        if (function.getName().equals("main")) {
            str.append(Generater.formatInstruction("call","@GlobalDeclaration"));
        }

        //temporary
        if (VirtualRegisterManager.cntOfRegisterInRedZone > 0) {
            str.append(Generater.formatInstruction("sub", "rsp", String.valueOf(8 * VirtualRegisterManager.cntOfRegisterInRedZone)));
        }

        Generater.rsp += VirtualRegisterManager.cntOfRegisterInRedZone;

        //push callee
        str.append(Generater.pushCallee());

        for (Block block : blockList) {
            str.append(block.getName() + ":\n");
            for (BaseInstruction instruction : block.instructionList) {
                str.append(instruction.toNASM());
            }
        }

        if (VirtualRegisterManager.cntOfRegisterInRedZone > 0) {
            str.append(Generater.formatInstruction("add", "rsp", String.valueOf(8 * VirtualRegisterManager.cntOfRegisterInRedZone)));
        }

        //pop callee
        str.append(Generater.popCallee());

        str.append(Generater.formatInstruction("pop","rbp"));
        str.append(Generater.formatInstruction("ret"));

        return str.toString();
    }
}
