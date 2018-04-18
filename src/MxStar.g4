grammar MxStar;

program
    :   declarationSeq* EOF
    ;

declarationSeq
    :   (functionDeclaration | classDeclaration | variableDeclaration)+
    ;

functionDeclaration
    :   type Identifier '(' (type Identifier (',' type Identifier)*)? ')'
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
    :   expression ';'
    ;

expression
    :   constant
    |   Identifier
    |   thisToken
    |   <assoc=right> New newObject
    |   '(' expression ')'
    |   '[' expression ']'
    |   expression '.' Identifier
    |   expression op = ('++' | '--')
    |   <assoc=right> op = ('++' | '--' | '+' | '-' | '~' | '!') expression
    |   expression op = ('+' | '-') expression
    |   expression op = ('<<' | '>>') expression
    |   expression op = ('*' | '/' | '%') expression
    |   expression op = ('==' | '!=') expression
    |   expression op = ('<' | '<=' | '>' | '>=') expression
    |   expression op = '&' expression
    |   expression op = '^' expression
    |   expression op = '|' expression
    |   expression op = '&&' expression
    |   expression op = '||' expression
    |   <assoc=right> expression op = '=' expression
    ;

newObject
    :   nonArrayType '(' expression (',' expression)* ')'
    |   nonArrayType ('[' expression ']')+ ('['']')?
    ;

constant
    :   Null
    |   BoolConst
    |   Number
    |   StringConst
    ;

thisToken
    :   This
    ;

ifStatement
    :   If '(' expression ')' statement ('else' statement)?
    ;

loopStatement
    :   For '(' expression ';' expression? ';' expression ')' statement
    |   While '(' expression ')' statement
    ;

brunchStatement
    :   Return expression ';'
    |   Break ';'
    |   Continue ';'
    ;

variableDeclaration
    :   type Identifier ('=' expression)? ';'
    ;

type
    : arrayType
    | nonArrayType
    ;

nonArrayType
    :   Int
    |   String
    |   Bool
    |   Identifier
    |   Void
    ;

arrayType
    :   nonArrayType ('['']')+
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










