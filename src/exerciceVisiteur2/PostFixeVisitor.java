package exerciceVisiteur2;


public class PostFixeVisitor extends Visitor {

	StringBuilder sb = new StringBuilder();

	public void visit(Constante element){
		sb.append(element.getValeur());
	}

	public void visit(Negation element){
		element.getOpG().accept(this);
		sb.append(element.getOp());
	}

	public void visit(Addition element){
		element.getOpG().accept(this);
		element.getOpD().accept(this);
		sb.append(element.getOp());
	}

	public void visit(Multiplication element){
		element.getOpG().accept(this);
		element.getOpD().accept(this);
		sb.append(element.getOp());
	}

	public String toString() {
		return sb.toString();
	}


}
