
import java.util.Scanner;
import java.util.ArrayList;

public class callCenter {
	static String[] products = {"chair", "table", "couch", "love seat", "night stand", "lamp", "wardrobe", "stool", "kitchen appliance"};
	static String[][] userReviews = new String[100][2];
  static ArrayList<String> userComplaints = new ArrayList<String>();
	static String str;
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
						complaintCheck();
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
  
	static void complaintCheck() {
		in.nextLine();
		System.out.println("I'm very sorry to hear you've had a bad experience.");
		System.out.println("Is there something we could do to fix the situation, yes or no?");
		String fixable = in.nextLine();
			if (fixable.contains("yes")) {
				productSatisfaction();
			} if (fixable.contains("no")) {
				complaints();
			} else {
				System.out.println("Invalid entry, please respond yes or no");
			}
  }
  
	static void complaints() {
		System.out.println("We will need some basic information from you to process your complaint");
		System.out.println("What is your name?");
		String name = in.nextLine();
		
		System.out.println("Ok "+ name +" what product would you like to leave a complaint for?");
		String product = in.nextLine();
		boolean found = false;
		boolean wrong = false;
		
		for(int i = 0; found == false && i < productList.length; i++) {
			if(product.contains(productList[i])) {
				found = true;
				product = productList[i];
				System.out.printf("I am very sorry to hear you have a complaint about one of our %ss.", product);
				System.out.println("\nPlease leave your complaint below:");
				String complaint = in.nextLine();
				userComplaints.add(product + ": " + complaint);
			}
			else if(i == productList.length-1 && !found) {
				System.out.println("I'm sorry, that doesn't sound like one of our products.");
				wrong = true;
			}
			
		}
		if(wrong == true) {chooseCategory();}
		
		System.out.println("Thank you very much for your feedback.");
		System.out.printf("We will work to ensure that the issues you've had with %s do not happen again.\n", product);
		
		System.out.println("Is there anything else I can do for you?");
		String reply = in.nextLine();
		if(reply.contains("no")) {
			System.out.println("Have a lovely day, and thank you for shopping with us!");
			System.exit(0);
		} else if(reply.contains("yes")) {
			chooseCategory();
		}
	}
	
	static void reviews() {
		loop: while(true) {
			System.out.println("You have reached the Reviews section. Please select one from the following menu: ");
			System.out.println("1. Leave a review");
			System.out.println("2. See the reviews of a product");
			System.out.println("3. Edit one of your existing reviews");
			System.out.println("4. Go back to the previous menu.");
			int category = in.nextInt();
			
			switch(category) {
			case 1:
				leaveReview();
				break;
			case 2:
				seeReviews();
				break;
			case 3:
				editReview();
				break;
			case 4:
				back();
				break loop;
			default:
				System.out.println("You have made an invalid selection. Please try again.");
			}
		}
	}
  
  public static void leaveReview() {
		in.nextLine(); //Clear input
		System.out.println("It seems that you want to leave a review. Can you tell me which product you would like to review?");
		String str = in.nextLine();
		boolean found = false;
		for(int i = 0; i < products.length && found == false; i++) { //Try and find product to review
			if(str.toLowerCase().contains(products[i])) {
				found = true;
				System.out.printf("Great, you would like to review %s! Please leave your review now and I will submit it.\n",products[i]);
				str = in.nextLine();
				boolean notfound = true;
				for(int j = 0; j < userReviews.length; j++) {
					if(userReviews[j][0] == null && notfound) {
						notfound = false;
						userReviews[j][0] = products[i];
						userReviews[j][1] = str;
					}
				}
				System.out.println("Thank you for your review. Can I help you with anything else?");
			} else if(i == products.length-1 && !found)
				System.out.println("Sorry, we can't seem to find a product that matches your query. Can I help you with anything else?");
		}
	}
	
	public static void seeReviews() {
		in.nextLine(); //Clear input
		System.out.println("It seems that you are searching for product reviews. Can you tell me which product you are looking for?");
		String str = in.nextLine();
		boolean found = false;
		for(int i = 0; i < products.length; i++) { //Try and find product to review
			if(str.toLowerCase().contains(products[i])) {
				found = true;
				System.out.printf("Here are the reviews for %s:\n",products[i]);
				System.out.printf("I think that %s was a great product! 5 stars.\n", products[i]);
				System.out.printf("Bought %s two days ago and already recieved it! Missing 1 screw but they offered to send me the missing part with no extra charge. 4 stars.\n", products[i]);
				System.out.printf("I think that %s was a great product! 5 stars.\n", products[i]);
				System.out.printf("That is the end of the reviews.\n\n");
			} else if(i == products.length-1 && !found)
				System.out.printf("Sorry, we can't seem to find a product that matches your query. Can I help you with anything else?\n\n");
		}
	}
	
	public static void editReview() {
		System.out.println("You would like to edit your review. Please select the review number you would like to edit.");
		if(userReviews[0][0] == null) {
			System.out.printf("Sorry, it seems that you haven't left any reviews.\n\n");
			return;
		}
		int i;
		for(i = 1; i < userReviews.length && userReviews[i-1][0] != null; i++) {
			System.out.printf("%d. %s: %s\n",i, userReviews[i-1][0], userReviews[i-1][1]);
		}
		System.out.printf("%d. Go back to the previous menu.\n",i);
		int productNum = in.nextInt();
		in.nextLine(); //Clear input
		
		if(productNum < i && productNum > 0) {
			System.out.println("Please leave your *NEW* review now:");
			String review = in.nextLine();
			userReviews[productNum-1][1] = review;
		} 
		else if (productNum == i) {
			System.out.printf("You have selected to go back to the previous menu.\n\n");
			return;
		}
		else
			System.out.println("You have made an invalid selection. Please try again.");
	}
		
	public static void back() {
		System.out.printf("You will now be taken back to the previous menu.\n\n");
	}
	
	public static void populateReviews() {
		userReviews[0][0] = products[0];
		userReviews[0][1] = "This chair is awesome!";
		userReviews[1][0] = products[1];
		userReviews[1][1] = "Table works exactly as expected";
		userReviews[2][0] = products[5];
		userReviews[2][1] = "I love lamp.";
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

