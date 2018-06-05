package Optimizer;

import AST.Constructor.AST;
import AST.Type.FunctionType;
import AST.Type.IntType;

import java.util.*;

public class MemorialFunctionCall {

    public static int cnt = 0;
    public static Set<String> functionCallMap = new HashSet<>();

    public static void calcFunction() {
        for (FunctionType function : AST.globalFunction.getFunctionMap().values()) {
            if (function.getReturnType() != IntType.getInstance()) {
                continue;
            }
            if (function.getParaList().size() != 1) {
                continue;
            }
            if (function.getParaList().get(0).getType() != IntType.getInstance()) {
                continue;
            }
            if (function.isBuiltin() || function.getClassScope() != null) {
                continue;
            }
            if (function.getName().equals("fibo")) {
                functionCallMap.add(function.getName());
            }
        }
    }
}
