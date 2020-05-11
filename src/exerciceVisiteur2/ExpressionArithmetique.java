package exerciceVisiteur2;


public class ExpressionArithmetique {
	private Noeud racine;
	
	public ExpressionArithmetique(Noeud racine){
		this.racine = racine;
	}

	public Noeud getRacine() {
		return racine;
	}

	public void afficherPostFixe() {
		PostFixeVisitor v = new PostFixeVisitor();
		racine.accept(v);
		System.out.println("\n postfixe: " + v);
	}

	public int calculerValeur() {
		CalculateVisitor visitor = new CalculateVisitor();
		racine.accept(visitor);
		return visitor.getResult();
	}

	
	public void afficherInFixe() {
		InFixeVisitor v = new InFixeVisitor();
		racine.accept(v);
		System.out.println("\n infixe: " + v);
	}
	
}
