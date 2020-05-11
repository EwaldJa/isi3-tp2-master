package exerciceVisiteur2;


public class InFixeVisitor extends Visitor {

	private boolean parentisHighPriority;

	private StringBuilder sb = new StringBuilder();

	public void visit(Constante element){
		sb.append(element.getValeur());
	}

	public void visit(Negation element){
		sb.append("(-");
		this.parentisHighPriority = element.isHighPriority();
		element.getOpG().accept(this);
		sb.append(")");
	}

	public void visit(Addition element){
		boolean needsParenthesis = (parentisHighPriority && !element.isHighPriority());
		if (needsParenthesis) {
			sb.append("("); }
		this.parentisHighPriority = element.isHighPriority();
		element.getOpG().accept(this);
		sb.append(element.getOp());
		this.parentisHighPriority = element.isHighPriority();
		element.getOpD().accept(this);
		if (needsParenthesis) {
			sb.append(")"); }
	}

	public void visit(Multiplication element){
		boolean needsParenthesis = (parentisHighPriority && !element.isHighPriority());
		if (needsParenthesis) {
			sb.append("("); }
		this.parentisHighPriority = element.isHighPriority();
		element.getOpG().accept(this);
		sb.append(element.getOp());
		this.parentisHighPriority = element.isHighPriority();
		element.getOpD().accept(this);
		if (needsParenthesis) {
			sb.append(")"); }
	}

	public String toString() {
		return sb.toString();
	}


}
