// Generated from /Users/liuyuxi/Desktop/MxCompiler/src/MxStar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#declarationSeq}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSeq(MxStarParser.DeclarationSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#declarationSeq}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSeq(MxStarParser.DeclarationSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(MxStarParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(MxStarParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(MxStarParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(MxStarParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(MxStarParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(MxStarParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MxStarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MxStarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MxStarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#newObject}.
	 * @param ctx the parse tree
	 */
	void enterNewObject(MxStarParser.NewObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#newObject}.
	 * @param ctx the parse tree
	 */
	void exitNewObject(MxStarParser.NewObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MxStarParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MxStarParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#thisToken}.
	 * @param ctx the parse tree
	 */
	void enterThisToken(MxStarParser.ThisTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#thisToken}.
	 * @param ctx the parse tree
	 */
	void exitThisToken(MxStarParser.ThisTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterLoopStatement(MxStarParser.LoopStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitLoopStatement(MxStarParser.LoopStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#brunchStatement}.
	 * @param ctx the parse tree
	 */
	void enterBrunchStatement(MxStarParser.BrunchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#brunchStatement}.
	 * @param ctx the parse tree
	 */
	void exitBrunchStatement(MxStarParser.BrunchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(MxStarParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(MxStarParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxStarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxStarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void enterNonArrayType(MxStarParser.NonArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void exitNonArrayType(MxStarParser.NonArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MxStarParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MxStarParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MxStarParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MxStarParser.ClassDeclarationContext ctx);
}