
import java.util.Scanner;

public class callCenter {
	
	static boolean callActive = true;
	static int category = 0;
	
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
		System.out.println("1. Product Satisfaction");
		System.out.println("2. Complaints");
		System.out.println("3. Reviews");
		//We can add more
		System.out.println("0. Exit");//If they enter zero the program will exit
		System.out.println("Please enter a number from the menu above: ");
		
		return(in.nextInt());
	}

	static void productSatisfaction() {

		
		int issue = in.nextInt();
		int partNumber = 0;
		boolean validEntry = false;
		
		while(validEntry) {
			System.out.println("\nProduct Satisfaction");
			System.out.println("What seems to be the issue?");
			System.out.println("1. Product Defect");
			System.out.println("2. Missing Parts");
			System.out.println("2. Not what you expected");
			//We can add more
			System.out.println("0. Exit");//If they enter zero the program will exit
			System.out.println("Please enter a number from the menu above: ");
			
			switch (issue) {
				case 1:
					System.out.println("We are sorry to hear that you had a defect");
					break;
				case 2:
					System.out.println("We are sorry to hear that you are missing a part");
					break;
				case 3:
					System.out.println("We are sorry to hear that you recieved a part that is not what you expexted");
					break;
				default:
					System.out.println("Please enter a valid command");
					break;
			}
		}
		
		
	}
	
	static void complaints() {
		//More stuff here
	}
	
	static void reviews() {
		//More stuff here
	}
	int generateShippingCode() {
		return 0;
		
	}
}
