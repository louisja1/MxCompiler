package Generater.PhysicalOperand;

import Generater.Generater;
import IR.Operand.*;
import Error.RuntimeError;

public class PhysicalBaseOperand {
    public static PhysicalBaseOperand get(StringBuilder str, Operand operand) {
        if (operand instanceof Immediate) {
            return new PhysicalImmediate(((Immediate) operand).value);
        }
        if (operand instanceof StringConstantTag) {
            return new PhysicalStringConstantTag(((StringConstantTag) operand).tagName);
        }
        if (operand instanceof VirtualRegister) {
            VirtualRegister reg = (VirtualRegister) operand;
            if (getPhysicalRegister(reg) != null) {
                return new PhysicalRegister(getPhysicalRegister(reg));
            } else {
                return new PhysicalAddress("rbp", -getID(reg) * 8);
            }
        }
        if (operand instanceof Address) {
            Address address = (Address) operand;
            if (getPhysicalRegister(address.base) != null) {
                return new PhysicalAddress(getPhysicalRegister(address.base), address.offset.value);
            } else {
                PhysicalAddress base = new PhysicalAddress("rbp", -getID(address.base) * 8);
                str.append(Generater.formatInstruction("mov","rcx", base.toString()));
                return new PhysicalAddress("rcx", address.offset.value);
            }
        }
        throw new RuntimeError("There is a error in getting a physical operand");
    }

    private static String getPhysicalRegister(VirtualRegister reg) {
        if (reg.physicalRegisterName != null) {
            return reg.physicalRegisterName;
        }
        if (Generater.currentFunction.registerMap.containsKey(reg)) {
            return Generater.currentFunction.registerMap.get(reg);
        }
        return null;
    }

    private static int getID(VirtualRegister reg) {
        if (Generater.currentFunction.idMap.containsKey(reg)) {
            return Generater.currentFunction.idMap.get(reg);
        }
        throw new RuntimeError("There is no such a parameter in current function");
    }
}
