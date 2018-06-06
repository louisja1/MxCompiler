package AST.Statement;

import AST.SymbolTable.Scope;
import IR.Instruction.LabelInstruction;

public abstract class LoopStatement extends BaseStatement implements Scope {
    public LabelInstruction loopConditionLabel, loopBodyLabel, loopNextLabel, loopExitLabel, loopEntryLabel;
}

/*
FOR :
    %loop_entry :
        (initiate)
        jump loop_condition
    %loop_condition :
        (condition)
        cmp condition true
        cjump EQ loop_body
        jump loop_exit
    %loop_body :
        (statement)
        jump loop_next
    %loop_next :
        (cur -> next)
        jump loop_condition
    %loop_exit :
        ...

WHILE :
    %... :
        jump loop_condition
    %loop_condition :
        (condition)
        cmp condition true
        cjump EQ loop_body
        jump loop_exit
     %loop_body :
        (statement)
        jump loop_condition
     %loop_exit

 */
