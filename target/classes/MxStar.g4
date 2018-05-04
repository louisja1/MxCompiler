grammar MxStar;

program
    :   (functionDeclaration | classDeclaration | variableDeclaration)* EOF
    ;

functionDeclaration
    :   type Identifier? '(' (type Identifier (',' type Identifier)*)? ')'
        functionBody
    ;

functionBody
    :   blockStatement
    ;

blockStatement
    :   '{' statement* '}'
    ;

statement
    :   blockStatement
    |   variableDeclaration
    |   expressionStatement
    |   ifStatement
    |   loopStatement
    |   brunchStatement
    ;

expressionStatement
    :   expression? ';'
    ;

expression
    :   constant                                                                    #constantExpression
    |   Identifier                                                                  #identifierExpression
    |   thisToken                                                                   #thisExpression
    |   New type ('[' expression? ']')+                                             #newArrayExpression
    |   New type ('('')')?                                                          #newTypeExpression
    |   '(' expression ')'                                                          #subgroupExpression
    |   expression '(' (expression (',' expression)*)? ')'                          #functionExpression
    |   expression '[' expression ']'                                               #arrayExpression
    |   expression '.' Identifier                                                   #memberExpression
    |   expression op = ('++' | '--')                                               #suffixExpression
    |   <assoc=right> op = ('++' | '--' | '+' | '-' | '~' | '!') expression         #prefixExpression
    |   expression op = ('+' | '-') expression                                      #addSubExpression
    |   expression op = ('<<' | '>>') expression                                    #shiftExpression
    |   expression op = ('*' | '/' | '%') expression                                #mulDivModExpression
    |   expression op = ('==' | '!=') expression                                    #equalityExpression
    |   expression op = ('<' | '<=' | '>' | '>=') expression                        #relationExpression
    |   expression op = '&' expression                                              #binaryAndExpression
    |   expression op = '^' expression                                              #binaryXorExpression
    |   expression op = '|' expression                                              #binaryOrExpression
    |   expression op = '&&' expression                                             #logicAndExpression
    |   expression op = '||' expression                                             #logicOrExpression
    |   <assoc=right> expression op = '=' expression                                #assignExpression
    ;

constant
    :   Null                                                                        #nullConstant
    |   BoolConst                                                                   #boolConstant
    |   Number                                                                      #numberConstant
    |   StringConst                                                                 #stringConstant
    ;

thisToken
    :   This
    ;

ifStatement
    :   If '(' expression ')' statement ('else' statement)?
    ;

loopStatement
    :   For '(' expression? ';' expression? ';' expression? ')' statement             #forStatement
    |   While '(' expression? ')' statement                                          #whileStatement
    ;

brunchStatement
    :   Return expression? ';'                                                       #returnStatement
    |   Break ';'                                                                   #breakStatement
    |   Continue ';'                                                                #continueStatement
    ;

variableDeclaration
    :   type Identifier ('=' expression)? ';'
    ;

type
    :   Int                                                                         #intType
    |   String                                                                      #stringType
    |   Bool                                                                        #boolType
    |   Identifier                                                                  #classType
    |   Void                                                                        #voidType
    |   type '[' ']'                                                                #arrayType
    ;

classDeclaration
    :   Class Identifier '{' (variableDeclaration | functionDeclaration)* '}'
    ;

//      constants
Null : 'null';
BoolConst : 'true' | 'false';
StringConst : '"' ('\\' [btnr"\\] | .)*? '"';
Number : [0-9]+;

//      reversed keywords
Bool : 'bool';
Int : 'int';
String : 'string';
//null
Void : 'void';
//true
//false
If : 'if';
For : 'for';
While : 'while';
Break : 'break';
Continue : 'continue';
Return : 'return';
New : 'new';
Class : 'class';
This : 'this';

//      identifier
Identifier : [_a-zA-Z][_a-zA-Z0-9]*;

//      whitespace
WhiteSpace : [ \t\n\r]+ -> channel(HIDDEN);

//      comments
BlockComment : '/*' .*? '*/' -> channel(HIDDEN);
LineComment : '//' ~[\n\r]* -> channel(HIDDEN);

//      symbols

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
Equal : '==';
NotEqual : '!=';

Add : '+';
Sub : '-';
Mul : '*';
Div : '/';
Mod : '%';

AddAdd : '++';
SubSub : '--';

Assign : '=';

LogicAnd : '&&';
LogicOr : '||';
Not : '!';

BinaryAnd : '&';
BinaryOr : '|';
BinaryXor : '^';
BinaryNot : '~';
LeftShift : '<<';
RightShift : '>>';

Semi : ';';
Comma : ',';
Dot : '.';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';







