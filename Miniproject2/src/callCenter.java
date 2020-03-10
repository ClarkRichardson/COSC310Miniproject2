
import java.util.Scanner;

public class callCenter {
	
	static boolean callActive = true;
	static int category = 0;
	static int creditCardNumber = 0;
	static int pID = 0;	
	static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[]args) {
		
		System.out.println("Welcome to ****** Call Center!");
		
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
					case 4:
						help();
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
		System.out.println("\t 4. help");
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
			System.out.println("\t 3. Not what you expected");
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
					validEntry = true;
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
					System.out.println("\t 0. Return to main menu");
					solution = in.nextInt();
					
					switch(solution) {
						case 1:
							validateOrder();
							System.out.println("Please go to your local post office and give them this shipping code and your order will be returned for free");
							System.out.println("Your shipping number is " + generateShippingCode());
							validEntry = true;
							break;
						case 2:
							validateOrder();
							System.out.println("A refund will be sent to you credit card within the next 5 business days");
							validEntry = true;
							break;
						case 0:
							validEntry = true;
							break;
						default:
							System.out.println("Please enter a valid number:");
							break;
					}
				}
			}
			if(solution == 0) {
				break;
			}
			callActive = false;
		}
		
		
	}
	static void help() {
		System.out.println("enter 0 at any time to exit.");
		String[] products = {"coffee table", "dresser", "night stand", "dining table", "chair", "two seat sofa", "three seat sofa", "bed frame"};
		System.out.println("What product do you need help with?");
		for(int i = 0; i < products.length; i++) {
			System.out.print(products[i] + ", ");
		}
		int product = -1;
		boolean badinput = true;
		in.nextLine();
		while(badinput) {
		String userInput = in.nextLine();
		userInput = userInput.toLowerCase();
		for(int i = 0; i < products.length; i++) {
			if(products[i].contentEquals(userInput)) {
				product = i;
				badinput = false;
			}
		}
		if(userInput == "0") {
			System.exit(0);
		}
		else if(product == -1) {
			System.out.println("sorry there may be a typo in your entry, please try again");
		}
		}
		int userint = -1;
		while(userint < 0) {
		System.out.println("What do you need help with?");
		System.out.println("1. Assembly");
		System.out.println("2. Something Broke");
		System.out.println("3. I want to return it");
		System.out.println("9. return to main");
		System.out.println("0. I cant exit this program");
		userint = in.nextInt();
		
		switch(userint) {
		case 0:
			System.exit(0);
			break;
		case 1:
			System.out.println("Here are the assembly instructions");
			assembly(product);
			break;
		case 2:
			System.out.println("Bring the purchase along with receipt to your nearest ****** store and we will attempt to fix or replace the piece");
			break;
		case 3:
			System.out.println("Bring the purchase along with receipt to your nearest ****** store and if the furniture is in good condition we will refund you");
			break;
		case 9:
			break;
		default:
			System.out.println("Please use valid input");
			userint = -1;
			break;
		}
		
	}
	}
	
	static void assembly(int product) {
		String[] instructions = {"Take each of the legs and screw them into the holes in the bottom",
				"Screw the sides of the dresser to the back part, then do the top, then screw the rails inside and insert the drawers",
				"Screw the legs into the bottom of the object, then insert the drawer",
				"screw each of the legs into the bottom of the top table part",
				"take each leg and screw them into the flat sitting part, then screw the back into the holes on the top side",
				"take each of the two cushions and place one on the left half of the sofa and one on the right half",
				"For each of the three cushions that come with your sofa place one on the right side, one on the left side, and one in between the other two",
				"Attach to the bottom each of the four side parts, then attach the top part, then screw the four legs into the bottom part"};
		System.out.println(instructions[product]);
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
