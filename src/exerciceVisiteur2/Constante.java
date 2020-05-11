package exerciceVisiteur2;

public class Constante implements Noeud{

	private int valeur;

	public Constante(int v){
		valeur = v;
	}

	public int getValeur() { return valeur; }

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
