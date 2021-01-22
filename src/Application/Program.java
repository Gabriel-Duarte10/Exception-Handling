package Application;

import java.util.Locale;
import java.util.Scanner;

import modal.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");

		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.next();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawlimit = sc.nextDouble();

		Account account = new Account(number, holder, balance, withdrawlimit);

		try {
			System.out.print("Enter amount for withdraw: ");
			double withdraw = sc.nextDouble();

			account.withDraw(withdraw);

			System.out.println("New balance: " + account.getBalance());
		} 
		catch (DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}

		sc.close();
	}

}
