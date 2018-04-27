package Statement;

import Expression.BaseExpression;

public class IfStatement extends BaseStatement {
        private BaseExpression condition;
        private BaseStatement trueStatement, falseStatement;

        public IfStatement(BaseExpression _condition, BaseStatement _trueStatemnt) {
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
