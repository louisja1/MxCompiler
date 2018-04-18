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
	 * Enter a parse tree produced by the {@code mulDivModExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulDivModExpression(MxStarParser.MulDivModExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivModExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulDivModExpression(MxStarParser.MulDivModExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOrExpression(MxStarParser.BinaryOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOrExpression(MxStarParser.BinaryOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryXorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryXorExpression(MxStarParser.BinaryXorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryXorExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryXorExpression(MxStarParser.BinaryXorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(MxStarParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(MxStarParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(MxStarParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(MxStarParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(MxStarParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(MxStarParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpression(MxStarParser.AssignExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpression(MxStarParser.AssignExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(MxStarParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelationExpression(MxStarParser.RelationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelationExpression(MxStarParser.RelationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpression(MxStarParser.MemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpression(MxStarParser.MemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newTypeExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewTypeExpression(MxStarParser.NewTypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newTypeExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewTypeExpression(MxStarParser.NewTypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(MxStarParser.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(MxStarParser.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExpression(MxStarParser.LogicAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExpression(MxStarParser.LogicAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(MxStarParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(MxStarParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExpression(MxStarParser.LogicOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicOrExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExpression(MxStarParser.LogicOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(MxStarParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(MxStarParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(MxStarParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(MxStarParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryAndExpression(MxStarParser.BinaryAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryAndExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryAndExpression(MxStarParser.BinaryAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpression(MxStarParser.SuffixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpression(MxStarParser.SuffixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MxStarParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MxStarParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpression(MxStarParser.NewArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newArrayExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpression(MxStarParser.NewArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subgroupExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubgroupExpression(MxStarParser.SubgroupExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subgroupExpression}
	 * labeled alternative in {@link MxStarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubgroupExpression(MxStarParser.SubgroupExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullConstant(MxStarParser.NullConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullConstant(MxStarParser.NullConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBoolConstant(MxStarParser.BoolConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBoolConstant(MxStarParser.BoolConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNumberConstant(MxStarParser.NumberConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNumberConstant(MxStarParser.NumberConstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringConstant(MxStarParser.StringConstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConstant}
	 * labeled alternative in {@link MxStarParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringConstant(MxStarParser.StringConstantContext ctx);
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
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(MxStarParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(MxStarParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(MxStarParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(MxStarParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(MxStarParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(MxStarParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(MxStarParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(MxStarParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(MxStarParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidType}
	 * labeled alternative in {@link MxStarParser#nonArrayType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(MxStarParser.VoidTypeContext ctx);
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