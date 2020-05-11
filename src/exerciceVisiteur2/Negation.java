package exerciceVisiteur2;


public class Negation extends OperateurUnaire{

	public Negation(Noeud n) {
		super("-", n);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	@Override
	public boolean isHighPriority() {
		return false;
	}

}
