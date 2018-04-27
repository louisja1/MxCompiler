package Expression;

import SymbolTable.Symbol;
import Type.BaseType;
import Type.FunctionType;
import Error.CompilationError;

import java.util.List;

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
}
