
import java.util.Scanner;

public class callCenter {
	
	static boolean callActive = true;
	static int category = 0;
	static int creditCardNumber = 0;
	static int pID = 0;	
	static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[]args) {
		
		System.out.println("Welcome to ****** Call Center!");//not sure of the name
		
		while(callActive) {
			category = chooseCategory();
			if(category==0) {
				callActive = false;//if zero exit
			}else {
				switch(category) {
					case 1:
						productSatisfaction();
						break;
					case 2:
						complaints();
						break;
					case 3:
						reviews();
						break;
					default:
						System.out.println("Invalid entry. Please Select another category");
						chooseCategory();
				}
			}
		}
		
		System.out.println("I hope we were able to help.");
		System.out.println("Have a nice day!");
			
	}

	static int chooseCategory(){
		System.out.println("What can I help you with?");
		System.out.println("\t 1. Product Satisfaction");
		System.out.println("\t 2. Complaints");
		System.out.println("\t 3. Reviews");
		//We can add more
		System.out.println("\t 0. Exit");//If they enter zero the program will exit
		System.out.println("Please enter a number from the menu above: ");
		
		return(in.nextInt());
	}

	static void productSatisfaction() {
		int issue = 0;
		int partNumber = 0;
		boolean validEntry = false;
		int solution = 0;
		
		while(!validEntry) {
			System.out.println("\nProduct Satisfaction");
			System.out.println("What seems to be the issue?");
			System.out.println("\t 1. Product Defect");
			System.out.println("\t 2. Missing Parts");
			System.out.println("\t 31. Not what you expected");
			//We can add more
			System.out.println("\t 0. Exit");//If they enter zero the program will exit
			System.out.println("Please enter a number from the menu above: ");
			issue = in.nextInt();
			
			switch (issue) {
				case 1:
					System.out.println("We are sorry to hear that you had a defect");
					validEntry = true;
					break;
				case 2:
					System.out.println("We are sorry to hear that you are missing a part");
					validEntry = true;
					break;
				case 3:
					System.out.println("We are sorry to hear that you recieved a part that is not what you expexted");
					validEntry = true;
					break;
				case 0:
					break;
				default:
					System.out.println("Please enter a valid command");
					break;
			}
			if(issue == 0) {
				break;
			}else {
				validEntry = false;
				while(!validEntry) {
					System.out.println("Okay so we can offer you two options");
					System.out.println("We can either:");
					System.out.println("\t 1. Send back your order and recive a new item");
					System.out.println("\t 2. Send you a refund");
					solution = in.nextInt();
					
					switch(solution) {
						case 1:
							validateOrder();
							System.out.println("Please go to your local Post office and give them this shipping code and your order will be returned for free");
							System.out.println("Your shipping number is " + generateShippingCode());
							validEntry = true;
							break;
						case 2:
							validateOrder();
							System.out.println("A refund will be sent to you credit card within the next 5 business days");
							validEntry = true;
							break;
						default:
							System.out.println("Please enter a valid number:");
							break;
					}
				}
			}
			callActive = false;
		}
		
		
	}
	
	static void complaints() {
		//More stuff here
	}
	
	static void reviews() {
		//More stuff here
	}
	
	
	static int generateShippingCode() {
		return (int)(Math.random()*100000000);	
	}
	static void validateOrder() {
		System.out.println("To confirm your order, please enter your product ID and credit card information");
		System.out.println("Credit Card Number: ");
		creditCardNumber = in.nextInt();
		System.out.println("Product ID: ");
		pID = in.nextInt();
	}
	
}
