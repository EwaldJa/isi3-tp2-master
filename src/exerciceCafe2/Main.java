package exerciceCafe2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println(VendingMachine.showAllExtras());
		System.out.println(VendingMachine.showAllCoffees());
		System.out.println("Choose a coffee number : ");
		int choice = sc.nextInt();
		ArrayList<Extra> extras_chosen = new ArrayList<>();
		List<Extra> extras_list = VendingMachine.getAvailable_extras();
		for(Extra extra:extras_list) {
			System.out.println("Do you want this extra (1 yes / 0 no) : " + extra + " ?");
			int extraChoice = sc.nextInt();
			if (1 == extraChoice) {
				extras_chosen.add(extra);
			}
		}
		System.out.println("\nYour choice : ");
		System.out.println(VendingMachine.getCoffeeChoice(choice, extras_chosen));
		
	}
}
