package Expression;

import Constructor.AST;
import Statement.VariableDeclarationStatement;
import Error.CompilationError;
import Type.*;

public class MemberExpression extends BaseExpression {
    private BaseExpression expression;
    private String idname;

    private MemberExpression(BaseType _type, BaseExpression _expression, String _idname) {
        super(_type, !(_type instanceof FunctionType));
        this.expression = _expression;
        this.idname = _idname;
    }

    public BaseExpression getExpression() {
        return expression;
    }

    public String getIDName() {
        return idname;
    }

    public static BaseExpression getExpression(BaseExpression _expression, String _idname) {
        if (_expression.getType() instanceof ClassType) {
            ClassType currentClass = (ClassType) _expression.getType();
            if (currentClass.existMemberFunction(_idname)) {
                FunctionType functionType = currentClass.getMemberFunction(_idname);
                return new MemberExpression(functionType, _expression, _idname);
            }
            if (currentClass.existMemberVariable(_idname)) {
                VariableDeclarationStatement variable = currentClass.getMemberVariable(_idname);
                return new MemberExpression(variable.getType(), _expression, _idname);
            }
            throw new CompilationError("There is not a member named [" + _idname + "] belongs to the class");
        }
        if (_expression.getType() instanceof StringType) {
            if (_idname.equals("length")) {
                FunctionType functionType = AST.globalFunction.getFunctionType("_builtin_length");
                return new MemberExpression(functionType, _expression, _idname);
            }
            if (_idname.equals("substring")) {
                FunctionType functionType = AST.globalFunction.getFunctionType("_builtin_substring");
                return new MemberExpression(functionType, _expression, _idname);
            }
            if (_idname.equals("parseInt")) {
                FunctionType functionType = AST.globalFunction.getFunctionType("_builtin_parseint");
                return new MemberExpression(functionType, _expression, _idname);
            }
            if (_idname.equals("ord")) {
                FunctionType functionType = AST.globalFunction.getFunctionType("_builtin_ord");
                return new MemberExpression(functionType, _expression, _idname);
            }
            throw new CompilationError("There is not a member named [" + _idname + "] belongs to the string");
        }
        if (_expression.getType() instanceof ArrayType) {
            if (_idname.equals("size")) {
                FunctionType functionType = AST.globalFunction.getFunctionType("_builtin_size");
                return new MemberExpression(functionType, _expression, _idname);
            }
            throw new CompilationError("There is not a member named [" + _idname + "] belongs to the array");
        }
        throw new CompilationError("There is not a member named [" + _idname + "] belongs to the class, string nor array");
    }


}
