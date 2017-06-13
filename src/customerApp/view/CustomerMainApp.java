package customerApp.view;

import java.util.Scanner;

import customerApp.controller.ConnectionManager;
import customerApp.model.Customer;

public class CustomerMainApp {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ConnectionManager cm = new ConnectionManager();
		Customer customer = new Customer();
		DisplayCustomerData dcd = new DisplayCustomerData();
		String newaddress, zipCode;
		//cm.getConnection();
		
		System.out.println("Enter Customer's Last Name: ");
		String lastName = scan.next();
		dcd.display(lastName);
		
		System.out.println("Press (1) to search for another customer or press (2) to Edit the customer's address");
		int choice = scan.nextInt();
		switch(choice){
		
		case 1:
			System.out.println("Enter another customer's Last Name: ");
			lastName = scan.next();
			dcd.display(lastName);
			break;
		case 2:
			System.out.println("Enter the Customer ID you want to update: ");
			int customerid = scan.nextInt();
			//Sscan.next();
			System.out.println("Enter ZipCode: ");
			zipCode = scan.next();
			System.out.println("Enter the new Adress you would like to edit: ");
			newaddress = scan.nextLine();
			scan.next();
			dcd.update(customerid,newaddress,zipCode);
			break;
		default:
				System.out.println("Wrong choice! please enter the right number");
		}

	}

}
