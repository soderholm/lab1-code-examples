

public class Minus extends CompoundExpression {
	public Minus(AbstractExpression op1, AbstractExpression op2) {
		this.leftOperand = op1;
		this.rightOperand = op2;
	}

	@Override
	protected String operator() {
		return "-";
	}

	@Override
	public void accept(Visitor v) {
		leftOperand.accept(v);
		v.visit(this);
		rightOperand.accept(v);
	}
}