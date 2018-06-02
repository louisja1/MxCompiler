package AST.Constructor;

import Parser.MxStarParser;
import AST.Statement.VariableDeclarationStatement;
import AST.SymbolTable.Symbol;
import AST.Type.*;
import org.antlr.v4.runtime.tree.ParseTree;
import Error.CompilationError;

import java.util.List;
import java.util.Vector;

public class DeclarationListener extends PositionListener {

    @Override
    public void exitProgram(MxStarParser.ProgramContext ctx) {
        boolean flag = false;
        for (ParseTree tmp : ctx.functionDeclaration()) {
            FunctionType function = (FunctionType) map.get(tmp);
            if (function.getName().equals("main")) {
                flag = true;
                if (!(function.getReturnType() instanceof IntType)) {
                    throw new CompilationError("The return type is not a int type");
                }
                if (function.getParaList().size() != 0) {
                    throw new CompilationError("The main function have parameter");
                }
            }
            AST.globalFunction.addFunction(function);
        }
        if (!flag) {
            throw new CompilationError("The program does not have a main function");
        }
        for (ParseTree tmp : ctx.variableDeclaration()) {
            VariableDeclarationStatement variable = (VariableDeclarationStatement) map.get(tmp);
            variable.getSymbol().setGlobal();
            AST.globalVariable.addVariable(variable);
            AST.orderedGlobalVariable.add(variable);
        }
    }

    @Override
    public void exitIntType(MxStarParser.IntTypeContext ctx) {
        map.put(ctx, IntType.getInstance());
    }

    @Override
    public void exitStringType(MxStarParser.StringTypeContext ctx) {
        map.put(ctx, StringType.getInstance());
    }

    @Override
    public void exitVoidType(MxStarParser.VoidTypeContext ctx) {
        map.put(ctx, VoidType.getInstance());
    }

    @Override
    public void exitBoolType(MxStarParser.BoolTypeContext ctx) {
        map.put(ctx, BoolType.getInstance());
    }

    @Override
    public void exitArrayType(MxStarParser.ArrayTypeContext ctx) {
        BaseType type = (BaseType) map.get(ctx.type());
        if (type instanceof ArrayType) {
            map.put(ctx, new ArrayType(((ArrayType) type).getBaseType(), ((ArrayType) type).getDimension() + 1));
        } else {
            map.put(ctx, new ArrayType((NonArrayType) type,1));
        }
    }

    @Override
    public void exitClassType(MxStarParser.ClassTypeContext ctx) {
        String name = ctx.Identifier().getText();
        map.put(ctx, AST.globalClass.getClassType(name));
    }

    @Override
    public void exitFunctionDeclaration(MxStarParser.FunctionDeclarationContext ctx) {
        BaseType returnType = (BaseType) map.get(ctx.getChild(0));
        String name = null;
        if (ctx.type().size() == ctx.Identifier().size()) {
            name = ctx.Identifier(0).getText();
            List<Symbol> parameterList = new Vector<>();
            for (int i = 1; i < ctx.type().size(); i++) {
                String parameterName = ctx.Identifier(i).getText();
                BaseType parameterType = (BaseType) map.get(ctx.type(i));
                parameterList.add(new Symbol(parameterName, parameterType));
            }
            FunctionType function = new FunctionType(name, returnType, parameterList);
            map.put(ctx, function);
        } else {
            // construction function
            List<Symbol> parameterList = new Vector<>();
            for (int i = 0; i < ctx.Identifier().size(); i++) {
                String parameterName = ctx.Identifier(i).getText();
                BaseType parameterType = (BaseType) map.get(ctx.type(i + 1));
                parameterList.add(new Symbol(parameterName, parameterType));
            }
            FunctionType function = new FunctionType(name, returnType, parameterList);
            map.put(ctx, function);
        }
    }

    @Override
    public void enterClassDeclaration(MxStarParser.ClassDeclarationContext ctx) {
        ClassType classType = (ClassType) map.get(ctx);
        AST.symbolTable.enterScope(classType);
    }

    @Override
    public void exitClassDeclaration(MxStarParser.ClassDeclarationContext ctx) {
        ClassType currentClass = (ClassType) map.get(ctx);
        for (ParseTree tmp : ctx.variableDeclaration()) {
            VariableDeclarationStatement variable = (VariableDeclarationStatement) map.get(tmp);
            currentClass.addMemberVariable(variable);
            variable.addClassScope(currentClass);
        }
        for (ParseTree tmp : ctx.functionDeclaration()) {
            FunctionType function = (FunctionType) map.get(tmp);
            function.getParaList().add(0, new Symbol("this", currentClass));
            if (function.getRawName() == null) {
                currentClass.addConstructionFunction(function);
            } else {
                currentClass.addMemberFunction(function);
            }
            function.addClassScope(currentClass);
        }
        AST.symbolTable.exitScope();
    }

    @Override
    public void exitVariableDeclaration(MxStarParser.VariableDeclarationContext ctx) {
        String name = ctx.Identifier().getText();
        BaseType type = (BaseType) map.get(ctx.type());
        if (type == VoidType.getInstance()) {
            throw new CompilationError("Variable type can not be void type");
        }
        VariableDeclarationStatement currentVariable = new VariableDeclarationStatement(type, name);
        map.put(ctx, currentVariable);
    }
}
