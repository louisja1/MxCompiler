package IR;

import Generater.Generater;
import IR.Operand.Address;
import IR.Operand.Operand;
import IR.Operand.VirtualRegister;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class VirtualRegisterManager {
    public static int temporaryRegisterCnt = 0;
    public static int cntOfRegisterInRedZone;
    public static List<String> parameterRegList = new Vector<String>() {{
        add("rdi");
        add("rsi");
        add("rdx");
        add("rcx");
        add("r8");
        add("r9");
    }};

    public static Set<String> usedRegister;

    public static VirtualRegister getTemporaryRegister() {
        return new VirtualRegister("t" + String.valueOf(temporaryRegisterCnt ++));
    }

    public static void initialize() {
        cntOfRegisterInRedZone = 0;
        usedRegister = new HashSet<>();
    }

    private static void markUsedRegister(VirtualRegister reg) {
        if (Generater.currentFunction.registerMap.containsKey(reg)) {
            usedRegister.add(Generater.currentFunction.registerMap.get(reg));
        }
    }

    private static void loginID(VirtualRegister reg) {
        if (!Generater.currentFunction.registerMap.containsKey(reg)) {
            if (!Generater.currentFunction.idMap.containsKey(reg)) {
                ++ cntOfRegisterInRedZone;
                Generater.currentFunction.idMap.put(reg, cntOfRegisterInRedZone);
            }
        }
    }

    public static void markUsedOperand(Operand operand) {
        if (operand instanceof VirtualRegister) {
            loginID((VirtualRegister) operand);
            markUsedRegister((VirtualRegister) operand);
        }
        if (operand instanceof Address) {
            loginID(((Address) operand).base);
            markUsedRegister(((Address) operand).base);
        }
    }
}
