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
		System.out.println("\n postfixe:");
		
	}

	public int calculerValeur() {
		return 0;
	}

	
	public void afficherInFixe() {
		System.out.println("\n infixe:");
		
	}
	
}
