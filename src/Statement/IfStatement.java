package Statement;

import Expression.BaseExpression;
import Type.BoolType;
import Error.CompilationError;

public class IfStatement extends BaseStatement {
        private BaseExpression condition;
        private BaseStatement trueStatement, falseStatement;

        public IfStatement(BaseExpression _condition, BaseStatement _trueStatemnt) {
            if (_condition.getType() != BoolType.getInstance()) {
                throw new CompilationError("The condition expression for if statement is not a bool type");
            }
            this.condition = _condition;
            this.trueStatement = _trueStatemnt;
            this.falseStatement = null;
        }

        public void addFalseStatement(BaseStatement _falseStatement) {
            this.falseStatement = _falseStatement;
        }

        public BaseExpression getConditionn() {
            return this.condition;
        }

        public BaseStatement getTrueStatemnt() {
            return this.trueStatement;
        }
        public BaseStatement getFalseStatement() {
            return this.falseStatement;
        }

}
