package exerciceVisiteur2;


public class CalculateVisitor extends Visitor {

	private int result = 0;

	public void visit(Constante element){
		result = element.getValeur();
	}

	public void visit(Negation element){
		CalculateVisitor tempVisitor = new CalculateVisitor();
		element.getOpG().accept(tempVisitor);
		int opG_value = tempVisitor.result;
		this.result = - opG_value;
	}

	public void visit(Addition element){
		CalculateVisitor tempVisitor = new CalculateVisitor();
		element.getOpG().accept(tempVisitor);
		int opG_value = tempVisitor.result;
		tempVisitor.result = 0;
		element.getOpD().accept(tempVisitor);
		int opD_value = tempVisitor.result;
		this.result = opG_value + opD_value;
	}

	public void visit(Multiplication element){
		CalculateVisitor tempVisitor = new CalculateVisitor();
		element.getOpG().accept(tempVisitor);
		int opG_value = tempVisitor.result;
		tempVisitor.result = 0;
		element.getOpD().accept(tempVisitor);
		int opD_value = tempVisitor.result;
		this.result = opG_value * opD_value;
	}

	public int getResult() {
		return result;
	}


}
