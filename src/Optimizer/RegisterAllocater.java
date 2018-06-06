package Optimizer;

import Generater.Generater;
import IR.FunctionIR;
import IR.Operand.VirtualRegister;
import Error.RuntimeError;

import java.util.*;

public class RegisterAllocater {
    private static final int K = 11;
    private static List<String> registerList = new Vector<String>(){{
        add("rbx");
        add("rsi");
        add("rdi");
        add("r8");
        add("r9");
        add("r10");
        add("r11");
        add("r12");
        add("r13");
        add("r14");
        add("r15");
    }};

    private static Map<VirtualRegister, String> registerMap;
    private static List<VirtualRegister> markedVirtualRegister;
    private static List<VirtualRegister> rawVirtualRegister;

    private static FunctionIR currentFunction;
    private static Map<VirtualRegister, Set<VirtualRegister>> conflictEdge;

    public static void registerAllocate(FunctionIR _currentFunction, Map<VirtualRegister, Set<VirtualRegister>> _conflictEdge) {
        currentFunction = _currentFunction;
        conflictEdge = new HashMap<>(_conflictEdge);

        registerMap = new HashMap<>();
        markedVirtualRegister = new Vector<>();
        rawVirtualRegister = new Vector<>();

        for (VirtualRegister reg : conflictEdge.keySet()) {
            if (reg.physicalRegisterName != null) {
                markedVirtualRegister.add(reg);
            } else {
                rawVirtualRegister.add(reg);
            }
        }
        for (VirtualRegister reg : markedVirtualRegister) {
            if (!color(reg, reg.physicalRegisterName)) {
                throw new RuntimeError("Marked Virtual Register colors error");
            }
        }
        Stack<VirtualRegister> stack = new Stack<>();
        while (rawVirtualRegister.size() > 0) {
            int pos = -1;
            for (int i = 0; i < rawVirtualRegister.size(); i++) {
                VirtualRegister reg = rawVirtualRegister.get(i);
                if (conflictEdge.get(reg).size() < K) {
                    pos = i;
                    break;
                }
            }
            if (pos != -1) {
                VirtualRegister cur = rawVirtualRegister.get(pos);
                stack.push(cur);
                rawVirtualRegister.remove(pos);
                for (VirtualRegister nxt : conflictEdge.get(cur)) {
                    conflictEdge.get(cur).remove(cur);
                }
            } else {
                VirtualRegister reg = rawVirtualRegister.get(0);
                for (String col : registerList) {
                    if (color(reg, col)) {
                        break;
                    }
                }
                rawVirtualRegister.remove(0);
            }
        }
        while (stack.size() > 0) {
            VirtualRegister reg = stack.pop();
            for (String col : registerList) {
                if (color(reg, col)) {
                    break;
                }
            }
        }
        currentFunction.registerMap = registerMap;
    }

    private static boolean color(VirtualRegister cur, String col) {
        for (VirtualRegister nxt : conflictEdge.get(cur)) {
            if (registerMap.containsKey(nxt) && registerMap.get(nxt).equals(col)) {
                return false;
            }
        }
        registerMap.put(cur, col);
        cur.physicalRegisterName = col;
        return true;
    }
}