

import java.util.Scanner;

public class callCenter {

	static boolean callActive = true;
	static int category = 0;
	static int creditCardNumber = 0;
	static int pID = 0;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Welcome to ****** Call Center!");// not sure of the name

		while (callActive) {
			category = chooseCategory();
			if (category == 0) {
				callActive = false;// if zero exit
			} else {
				switch (category) {
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
					orderstatus();
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

	static int chooseCategory() {
		System.out.println("What can I help you with?");
		System.out.println("\t 1. Product Satisfaction");
		System.out.println("\t 2. Complaints");
		System.out.println("\t 3. Reviews");
		System.out.println("\t 4. Order Status");
		// We can add more
		System.out.println("\t 0. Exit");// If they enter zero the program will exit
		System.out.println("Please enter a number from the menu above: ");

		return (in.nextInt());
	}

	static void productSatisfaction() {
		int issue = 0;
		int partNumber = 0;
		boolean validEntry = false;
		int solution = 0;

		while (!validEntry) {
			System.out.println("\nProduct Satisfaction");
			System.out.println("What seems to be the issue?");
			System.out.println("\t 1. Product Defect");
			System.out.println("\t 2. Missing Parts");
			System.out.println("\t 31. Not what you expected");
			// We can add more
			System.out.println("\t 0. Exit");// If they enter zero the program will exit
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
			if (issue == 0) {
				break;
			} else {
				validEntry = false;
				while (!validEntry) {
					System.out.println("Okay so we can offer you two options");
					System.out.println("We can either:");
					System.out.println("\t 1. Send back your order and recive a new item");
					System.out.println("\t 2. Send you a refund");
					solution = in.nextInt();

					switch (solution) {
					case 1:
						validateOrder();
						System.out.println(
								"Please go to your local Post office and give them this shipping code and your order will be returned for free");
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
		// More stuff here
	}

	static void reviews() {
		// More stuff here
	}

	static void orderstatus() {
		boolean orderstat;
		int trackingNum;
		boolean shipCode = true;
		boolean payed = false;
		System.out.println("Would you like to check your order status? Type true or false to answer.");
		orderstat = in.nextBoolean();
		int response;
		if (orderstat) {
			while (!payed) {
				System.out.println("Has your order been payed for?\n Enter 1 for yes, 2 for no.");
				response = in.nextInt();
				switch (response) {
				case 1:
					System.out.println("Were you given a shipping code? Enter 1 for yes, 2 for no.");
					response = in.nextInt();
					while (shipCode) {
						if (response == 1) {
							System.out.println("Please enter your 7 digit shipping code");
							trackingNum = in.nextInt();
							System.out.println(
									"Your order has been processed and shipped! Has it been more than 5 business days since you placed your order? Enter 1 for yes, 2 for no.");
							response = in.nextInt();
							if (response == 2)
								System.out.println("You should recieve your order within 5 business days.");
							else if (response == 1)
								System.out.println(
										"Sorry for the delay, we are experiencing a high volume of orders at the moment. If your order is not recieved within two business days please check in again and we can further assist you.");
							shipCode = false;
						} else if (response == 2) {
							System.out.println("Your shipping code is " + generateShippingCode());
							response = 1;
						}
					}
					payed = true;
					break;

				case 2:
					validateOrder();
					break;

				}
			}
			callActive = false;
		}
		

	}

	static int generateShippingCode() {
		return (int) (Math.random() * 100000000);
	}

	static int generateOrderId() {
		return (int) (Math.random() * 1000000);
	}

	static void validateOrder() {
		System.out.println("To confirm your order, please enter your credit Card information and product ID");
		System.out.println("Credit Card Number: ");
		creditCardNumber = in.nextInt();
		System.out.println("Product ID: ");
		pID = in.nextInt();
	}

}
=======

import java.util.Scanner;

public class callCenter {
	static String[] products = {"chair", "table", "couch", "love seat", "night stand", "lamp", "wardrobe", "stool", "kitchen appliance"};
	static String[][] userReviews = new String[100][2];
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
	
	static void complaints() {
		//More stuff here
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
	

