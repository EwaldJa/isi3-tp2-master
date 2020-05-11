package exerciceVisiteur2;


public abstract class Visitor {

	public abstract void visit(Constante element);
	public abstract void visit(Negation element);
	public abstract void visit(Addition element);
	public abstract void visit(Multiplication element);

}
