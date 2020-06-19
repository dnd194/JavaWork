package ex2_1;

public class MinusOp implements OperatorBean{
	int operand1;
	int operand2;
	
	@Override
	public int doOperate() {
		return operand1 - operand2;
	}
	public MinusOp() {
		super();
	}
	public MinusOp(int operand1, int operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	public int getOperand1() {
		return operand1;
	}
	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}
	public int getOperand2() {
		return operand2;
	}
	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
	@Override
	public String toString() {
		return "MinusOp [operand1=" + operand1 + ", operand2=" + operand2 + "]";
	}
	
	
}
