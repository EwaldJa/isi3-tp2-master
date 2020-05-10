package exerciceCafe1;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(VendingMachine.showAllCoffees());
		System.out.println("\nChoisissez un café : ");
		int choice = sc.nextInt();
		System.out.println("Votre choix : ");
		System.out.println(VendingMachine.getChoice(choice));
		
	}
}
