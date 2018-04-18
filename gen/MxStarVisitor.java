// Generated from /Users/liuyuxi/Desktop/MxCompiler/src/MxStar.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#declarationSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationSeq(MxStarParser.DeclarationSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(MxStarParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(MxStarParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(MxStarParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MxStarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(MxStarParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivModExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivModExpression(MxStarParser.MulDivModExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOrExpression(MxStarParser.BinaryOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryXorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryXorExpression(MxStarParser.BinaryXorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(MxStarParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(MxStarParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(MxStarParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpression(MxStarParser.AssignExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationExpression(MxStarParser.RelationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpression(MxStarParser.MemberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newTypeExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewTypeExpression(MxStarParser.NewTypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(MxStarParser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndExpression(MxStarParser.LogicAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(MxStarParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrExpression(MxStarParser.LogicOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(MxStarParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(MxStarParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAndExpression(MxStarParser.BinaryAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixExpression(MxStarParser.SuffixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(MxStarParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExpression(MxStarParser.NewArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subgroupExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubgroupExpression(MxStarParser.SubgroupExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullConstant(MxStarParser.NullConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolConstant(MxStarParser.BoolConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberConstant(MxStarParser.NumberConstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringConstant(MxStarParser.StringConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#thisToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisToken(MxStarParser.ThisTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(MxStarParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#brunchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBrunchStatement(MxStarParser.BrunchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(MxStarParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxStarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(MxStarParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(MxStarParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(MxStarParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassType(MxStarParser.ClassTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidType(MxStarParser.VoidTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MxStarParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MxStarParser.ClassDeclarationContext ctx);
}