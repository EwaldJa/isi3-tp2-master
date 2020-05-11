package exerciceVisiteur2;


public class Multiplication extends OperateurBinaire{

	public Multiplication( Noeud ng, Noeud nd) {
		super("*", ng, nd);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public boolean isHighPriority() {
		return true;
	}
}
