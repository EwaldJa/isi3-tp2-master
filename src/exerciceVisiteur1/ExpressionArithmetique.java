package exerciceVisiteur1;

public class ExpressionArithmetique {
	private Noeud racine;
	
	public ExpressionArithmetique(Noeud racine){
		this.racine = racine;
	}

	public Noeud getRacine() {
		return racine;
	}

	public void affichagePostfixe() {
		System.out.println("\n postfixe:");
		racine.affichagePostfixe();

		
	}

	public int calculerValeur() {
		return racine.calculer();
	}



	
}
