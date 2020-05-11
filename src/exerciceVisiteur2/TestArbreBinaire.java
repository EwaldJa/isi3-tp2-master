package exerciceVisiteur2;




public class TestArbreBinaire {

	public static void main(String[] args) {
		//faire 1+2*3+-4=3
		Addition racine = new Addition(new Addition(new Constante(1),
					new Multiplication(new Constante(2),new Constante(3))),
					new Negation(new Constante(4)));
		ExpressionArithmetique exp = new ExpressionArithmetique(racine);

		exp.afficherInFixe();
		System.out.println("Attendu : 1+2×3+(−4)");
		System.out.println("\n calcul valeur: " + exp.calculerValeur());
		System.out.println("Attendu : 3");
		exp.afficherPostFixe();
		System.out.println("Attendu : 123*+4-+");
		
		
		//faire 7*(2+3)
		System.out.println("\n----");
		Multiplication racine2 = new Multiplication(new Constante(7),new Addition(new Constante(2),
					new Constante(3)));
		ExpressionArithmetique exp2 = new ExpressionArithmetique(racine2);

		exp2.afficherInFixe();
		System.out.println("Attendu : 7*(2+3)");
		System.out.println("\n calcul valeur: " + exp2.calculerValeur());
		System.out.println("Attendu : 35");
		exp2.afficherPostFixe();
		System.out.println("Attendu : 723+*");
		
		
		//faire 7*2+3
		System.out.println("\n----");
		Addition racine3 = new Addition(new Constante(3),new Multiplication(new Constante(2),
							new Constante(7)));
		ExpressionArithmetique exp3 = new ExpressionArithmetique(racine3);

		exp3.afficherInFixe();
		System.out.println("Attendu : 3+2*7");
		System.out.println("\n calcul valeur: " + exp3.calculerValeur());
		System.out.println("Attendu : 17");
		exp3.afficherPostFixe();
		System.out.println("Attendu : 327*+");
				
				
	}

	

}
