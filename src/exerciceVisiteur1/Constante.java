package exerciceVisiteur1;

public class Constante implements Noeud{
	private int valeur;
	public Constante(int v){
		valeur = v;
	}
	public int getValeur(){return valeur;}
	
	public void affichagePostfixe() {
		System.out.print(getValeur());
	}
	
	public int calculer() {
		return getValeur();
	}


}
