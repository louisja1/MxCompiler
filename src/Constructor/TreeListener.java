package Constructor;

import Constant.BoolConstant;
import Constant.IntConstant;
import Constant.NullConstant;
import Constant.StringConstant;
import Expression.*;
import Expression.Arithmetic.*;
import Expression.Bit.AndExpression;
import Expression.Bit.OrExpression;
import Expression.Bit.XorExpression;
import Expression.Logic.LogicAndExpression;
import Expression.Logic.LogicOrExpression;
import Expression.Prefix.*;
import Expression.Relation.*;
import Expression.Suffix.SuffixDecrementExpression;
import Expression.Suffix.SuffixIncrementExpression;
import Parser.MxStarParser;
import Statement.*;
import SymbolTable.GlobalScope;
import SymbolTable.Scope;
import SymbolTable.Symbol;
import Type.BaseType;
import Type.ClassType;
import Type.FunctionType;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;
import java.util.Vector;

public class TreeListener extends PositionListener {
    @Override
    public void enterProgram(MxStarParser.ProgramContext ctx) {
        AST.symbolTable.enterScope(new GlobalScope());
        AST.globalFunction.getFunctionMap().forEach((name, function) -> AST.symbolTable.addSymbol(new Symbol(name, function)));
    }

    @Override
    public void exitProgram(MxStarParser.ProgramContext ctx) {
        AST.symbolTable.exitScope();
    }

    @Override
    public void enterFunctionDeclaration(MxStarParser.FunctionDeclarationContext ctx) {
        AST.symbolTable.enterScope((FunctionType) map.get(ctx));
    }

    @Override
    public void exitFunctionDeclaration(MxStarParser.FunctionDeclarationContext ctx) {
        FunctionType currentFunction = (FunctionType) map.get(ctx);
        BlockStatement blockStatement = (BlockStatement) map.get(ctx.functionBody().blockStatement());
        currentFunction.addBlockStatement(blockStatement);
        AST.symbolTable.exitScope();
    }

    @Override
    public void enterClassDeclaration(MxStarParser.ClassDeclarationContext ctx) {
        ClassType currentClass = (ClassType) map.get(ctx);
        AST.symbolTable.enterScope(currentClass);
        currentClass.getMemberFunctionTable().forEach((name, function) -> AST.symbolTable.addSymbol(new Symbol(name, function)));
        currentClass.getMemberVariableTable().forEach((name, variable) -> AST.symbolTable.addSymbol(variable.getSymbol()));
    }

    @Override
    public void exitClassDeclaration(MxStarParser.ClassDeclarationContext ctx) {
        AST.symbolTable.exitScope();
    }

    @Override
    public void exitBoolConstant(MxStarParser.BoolConstantContext ctx) {
        boolean currentValue = ctx.getText().equals("true");
        BoolConstant currentConstant = new BoolConstant(currentValue);
        map.put(ctx, currentConstant);
    }

    @Override
    public void exitNumberConstant(MxStarParser.NumberConstantContext ctx) {
        int currentValue = Integer.parseInt(ctx.getText());
        IntConstant currentConstant = new IntConstant(currentValue);
        map.put(ctx, currentConstant);
    }

    @Override
    public void exitNullConstant(MxStarParser.NullConstantContext ctx) {
        NullConstant currentConstant = new NullConstant();
        map.put(ctx, currentConstant);
    }

    @Override
    public void exitStringConstant(MxStarParser.StringConstantContext ctx) {
        String currentValue = ctx.getText().substring(1, ctx.getText().length() - 1);
        StringConstant currentConstant = new StringConstant(currentValue);
        map.put(ctx, currentConstant);
    }

    @Override
    public void enterStatement(MxStarParser.StatementContext ctx) {
        if (ctx.getParent() instanceof MxStarParser.IfStatementContext) {
            AST.symbolTable.enterScope(new BlockStatement());
        }
    }

    @Override
    public void exitStatement(MxStarParser.StatementContext ctx) {
        if (ctx.getParent() instanceof MxStarParser.IfStatementContext) {
            AST.symbolTable.exitScope();
        }
        map.put(ctx, (BaseStatement) map.get(ctx.getChild(0)));
    }

    @Override
    public void enterBlockStatement(MxStarParser.BlockStatementContext ctx) {
        BlockStatement currentStatement = new BlockStatement();
        Scope currentScope = AST.symbolTable.getCurrentScope();
        AST.symbolTable.enterScope(currentStatement);
        if (currentScope instanceof FunctionType) {
            FunctionType function = (FunctionType) currentScope;
            for (Symbol symbol : function.getParaList()) {
                AST.symbolTable.addSymbol(symbol);
            }
        }
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitBlockStatement(MxStarParser.BlockStatementContext ctx) {
        AST.symbolTable.exitScope();
        BlockStatement currentStatement = (BlockStatement) map.get(ctx);
        ctx.statement().forEach(statementContext -> currentStatement.addStatement((BaseStatement) map.get(statementContext)));
    }

    @Override
    public void exitBreakStatement(MxStarParser.BreakStatementContext ctx) {
        BreakStatement currentStatement = new BreakStatement();
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitContinueStatement(MxStarParser.ContinueStatementContext ctx) {
        ContinueStatement currentStatement = new ContinueStatement();
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitReturnStatement(MxStarParser.ReturnStatementContext ctx) {
        BaseExpression returnExpression = null;
        if (ctx.expression() != null) {
            returnExpression = (BaseExpression) map.get(ctx.expression());
        }
        ReturnStatement currentStatement = new ReturnStatement(returnExpression);
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitIfStatement(MxStarParser.IfStatementContext ctx) {
        BaseExpression condition = (BaseExpression) map.get(ctx.expression());
        BaseStatement trueStatement = (BaseStatement) map.get(ctx.statement(0));
        IfStatement currentStatement = new IfStatement(condition, trueStatement);
        if (ctx.statement(1) != null) {
            BaseStatement falseStatement = (BaseStatement) map.get(ctx.statement(1));
            currentStatement.addFalseStatement(falseStatement);
        }
        map.put(ctx, currentStatement);
    }

    @Override
    public void enterForStatement(MxStarParser.ForStatementContext ctx) {
        ForStatement currentStatement = new ForStatement();
        AST.symbolTable.enterScope(currentStatement);
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitForStatement(MxStarParser.ForStatementContext ctx) {
        ForStatement currentStatement = (ForStatement) map.get(ctx);
        int pos = 1;
        for (ParseTree tmp : ctx.children) {
            if (tmp.getText().equals(";")) {
                pos ++;
            }
            if (tmp instanceof MxStarParser.ExpressionContext) {
                if (pos == 1) {
                    currentStatement.addInitiate((BaseExpression) map.get(tmp));
                }
                if (pos == 2) {
                    currentStatement.addCondition((BaseExpression) map.get(tmp));
                }
                if (pos == 3) {
                    currentStatement.addVariance((BaseExpression) map.get(tmp));
                }
            }
        }
        BaseStatement bodyStatement = (BaseStatement) map.get(ctx.statement());
        currentStatement.addStatement(bodyStatement);
        AST.symbolTable.exitScope();
    }

    @Override
    public void enterWhileStatement(MxStarParser.WhileStatementContext ctx) {
        WhileStatement currentStatement = new WhileStatement();
        AST.symbolTable.enterScope(currentStatement);
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitWhileStatement(MxStarParser.WhileStatementContext ctx) {
        WhileStatement currentStatement = (WhileStatement) map.get(ctx);
        if (ctx.expression() != null) {
            currentStatement.addCondition((BaseExpression) map.get(ctx.expression()));
        }
        BaseStatement bodyStatement = (BaseStatement) map.get(ctx.statement());
        currentStatement.addStatement(bodyStatement);
        AST.symbolTable.exitScope();
    }

    @Override
    public void exitVariableDeclaration(MxStarParser.VariableDeclarationContext ctx) {
        VariableDeclarationStatement currentStatement = (VariableDeclarationStatement) map.get(ctx);
        if (ctx.expression() != null) {
            currentStatement.addExpression((BaseExpression) map.get(ctx.expression()));
        }
        if (currentStatement.getClassScope() == null) {
            AST.symbolTable.addSymbol(currentStatement.getSymbol());
        }
    }

    @Override
    public void exitExpressionStatement(MxStarParser.ExpressionStatementContext ctx) {
        BaseExpression expression = null;
        if (ctx.expression() != null) {
            expression = (BaseExpression) map.get(ctx.expression());
        }
        ExpressionStatement currentStatement = new ExpressionStatement(expression);
        map.put(ctx, currentStatement);
    }

    @Override
    public void exitConstantExpression(MxStarParser.ConstantExpressionContext ctx) {
        BaseExpression currentExpression = (BaseExpression) map.get(ctx.constant());
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx) {
        BaseExpression currentExpression = IdentifierExpression.getExpression(ctx.Identifier().getText());
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitThisExpression(MxStarParser.ThisExpressionContext ctx) {
        BaseExpression currentExpression = IdentifierExpression.getExpression("this");
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitNewArrayExpression(MxStarParser.NewArrayExpressionContext ctx) {
        BaseType type = (BaseType) map.get(ctx.type());
        List<BaseExpression> expressionList = new Vector<>();
        boolean last = false;
        for (ParseTree tmp : ctx.children) {
            if (last) {
                if (tmp.getText().equals("]")) {
                    expressionList.add(null);
                } else {
                    expressionList.add((BaseExpression) map.get(tmp));
                }
            }
            if (tmp.getText().equals("[")) {
                last = true;
            } else {
                last = false;
            }
        }
        BaseExpression currentExpression = NewExpression.getExpression(type, expressionList);
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitNewTypeExpression(MxStarParser.NewTypeExpressionContext ctx) {
        BaseType type = (BaseType) map.get(ctx.type());
        List<BaseExpression> expressionList = new Vector<>();
        BaseExpression currentExpression = NewExpression.getExpression(type, expressionList);
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitSubgroupExpression(MxStarParser.SubgroupExpressionContext ctx) {
        BaseExpression currentExpression = (BaseExpression) map.get(ctx.expression());
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitFunctionExpression(MxStarParser.FunctionExpressionContext ctx) {
        BaseExpression function = (BaseExpression) map.get(ctx.expression(0));
        List<BaseExpression> expressionList = new Vector<>();
        for (int i = 1; i < ctx.expression().size(); i++) {
            expressionList.add((BaseExpression) map.get(ctx.expression(i)));
        }
        BaseExpression currentExpression = FunctionExpression.getExpression(function, expressionList);
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitArrayExpression(MxStarParser.ArrayExpressionContext ctx) {
        BaseExpression arrayExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression indexExpression = (BaseExpression) map.get(ctx.expression(1));
        BaseExpression currentExpression = ArrayExpression.getExpression(arrayExpression, indexExpression);
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitMemberExpression(MxStarParser.MemberExpressionContext ctx) {
        BaseExpression expression = (BaseExpression) map.get(ctx.expression());
        BaseExpression currentExpression = MemberExpression.getExpression(expression, ctx.Identifier().getText());
        map.put(ctx, currentExpression);
    }

    @Override
    public void exitSuffixExpression(MxStarParser.SuffixExpressionContext ctx) {
        BaseExpression object = (BaseExpression) map.get(ctx.expression());
        if (ctx.op.getText().equals("++")) {
            map.put(ctx, SuffixIncrementExpression.getExpression(object));
        } else {
            map.put(ctx, SuffixDecrementExpression.getExpression(object));
        }
    }

    @Override
    public void exitPrefixExpression(MxStarParser.PrefixExpressionContext ctx) {
        BaseExpression object = (BaseExpression) map.get(ctx.expression());
        if (ctx.op.getText().equals("++")) {
            map.put(ctx, PrefixIncrementExpression.getExpression(object));
        }
        if (ctx.op.getText().equals("--")) {
            map.put(ctx, PrefixDecrementExpression.getExpression(object));
        }
        if (ctx.op.getText().equals("+")) {
            map.put(ctx, PrefixPlusExpression.getExpression(object));
        }
        if (ctx.op.getText().equals("-")) {
            map.put(ctx, PrefixMinusExpression.getExpression(object));
        }
        if (ctx.op.getText().equals("~")) {
            map.put(ctx, PrefixReverseExpression.getExpression(object));
        }
        if (ctx.op.getText().equals("!")) {
            map.put(ctx, PrefixNotExpression.getExpression(object));
        }
    }

    @Override
    public void exitAddSubExpression(MxStarParser.AddSubExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        if (ctx.op.getText().equals("+")) {
            map.put(ctx, AdditionExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals("-")) {
            map.put(ctx, SubtractionExpression.getExpression(firstExpression, secondExpression));
        }
    }

    @Override
    public void exitShiftExpression(MxStarParser.ShiftExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        if (ctx.op.getText().equals("<<")) {
            map.put(ctx, LeftShiftExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals(">>")) {
            map.put(ctx, RightShiftExpression.getExpression(firstExpression, secondExpression));
        }
    }

    @Override
    public void exitMulDivModExpression(MxStarParser.MulDivModExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        if (ctx.op.getText().equals("*")) {
            map.put(ctx, MultiplicationExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals("/")) {
            map.put(ctx, DivisionExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals("%")) {
            map.put(ctx, ModuleExpression.getExpression(firstExpression, secondExpression));
        }
    }

    @Override
    public void exitEqualityExpression(MxStarParser.EqualityExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        if (ctx.op.getText().equals("==")) {
            map.put(ctx, EqualExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals("!=")) {
            map.put(ctx, NotEqualExpression.getExpression(firstExpression, secondExpression));
        }
    }

    @Override
    public void exitRelationExpression(MxStarParser.RelationExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        if (ctx.op.getText().equals("<")) {
            map.put(ctx, LessExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals("<=")) {
            map.put(ctx, LessEqualExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals(">")) {
            map.put(ctx, GreaterExpression.getExpression(firstExpression, secondExpression));
        }
        if (ctx.op.getText().equals(">=")) {
            map.put(ctx, GreaterEqualExpression.getExpression(firstExpression, secondExpression));
        }
    }

    @Override
    public void exitBinaryAndExpression(MxStarParser.BinaryAndExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        map.put(ctx, AndExpression.getExpression(firstExpression, secondExpression));
    }

    @Override
    public void exitBinaryOrExpression(MxStarParser.BinaryOrExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        map.put(ctx, OrExpression.getExpression(firstExpression, secondExpression));
    }

    @Override
    public void exitBinaryXorExpression(MxStarParser.BinaryXorExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        map.put(ctx, XorExpression.getExpression(firstExpression, secondExpression));
    }

    @Override
    public void exitLogicAndExpression(MxStarParser.LogicAndExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        map.put(ctx, LogicAndExpression.getExpression(firstExpression, secondExpression));
    }

    @Override
    public void exitLogicOrExpression(MxStarParser.LogicOrExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        map.put(ctx, LogicOrExpression.getExpression(firstExpression, secondExpression));
    }

    @Override
    public void exitAssignExpression(MxStarParser.AssignExpressionContext ctx) {
        BaseExpression firstExpression = (BaseExpression) map.get(ctx.expression(0));
        BaseExpression secondExpression = (BaseExpression) map.get(ctx.expression(1));
        map.put(ctx, AssignExpression.getExpression(firstExpression, secondExpression));
    }
}
