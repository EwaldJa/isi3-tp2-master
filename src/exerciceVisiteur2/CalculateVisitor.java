package exerciceVisiteur2;


public class CalculateVisitor extends Visitor {

	private int result = 0;

	public void visit(Constante element){
		result = element.getValeur();
	}

	public void visit(Negation element){
		element.getOpG().accept(this);
		this.result = - this.result;
	}

	public void visit(Addition element){
		element.getOpG().accept(this);
		int opG_value = this.result;
		element.getOpD().accept(this);
		this.result += opG_value;
	}

	public void visit(Multiplication element){
		element.getOpG().accept(this);
		int opG_value = this.result;
		element.getOpD().accept(this);
		this.result *= opG_value;
	}

	public int getResult() {
		return result;
	}


}
