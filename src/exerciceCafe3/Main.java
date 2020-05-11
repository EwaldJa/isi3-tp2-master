package exerciceCafe3;


import exerciceCafe3.utils.InvalidDrinkException;
import exerciceCafe3.utils.InvalidExtraException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println(VendingMachine.getAvailableVendingItems(true));
		System.out.println("Please write your order, separating extras and drink with a space. Capital letters are not mandatory.");
		System.out.println("For example you can write : Colombia Milk Sugar. Please write the drink in first and then the optional extra(s).");

		Scanner sc = new Scanner(System.in);
		String order = sc.nextLine();

		try {
			System.out.println("Your have successfully ordered : " + VendingMachine.processOrder(order).toString()); }
		catch (InvalidDrinkException | InvalidExtraException e) {
			e.printStackTrace(); }
		
	}
}
