package chatbot;

import java.util.Scanner;

public class ReviewChatBot {
	static String[] products = {"chair", "table", "couch", "love seat", "night stand", "lamp", "wardrobe", "stool", "kitchen appliance"};
	static String[][] userReviews = {
			{products[0], "This chair is awesome!"},
			{products[1], "Table works exactly as expected"},
			{products[5], "I love lamp."}
			};
	static Scanner in = new Scanner(System.in);
	static String str;
	
	public static void main(String[] args) {
		System.out.println("Hi! My name is Chadbot. What can I help you with today?");
		
		while (true) {
			str = in.nextLine();
			
			//Review section
			if(str.toLowerCase().contains("review")) {
				System.out.println("You have reached the Reviews section. Please select one from the following menu: ");
				System.out.println("1. Leave a review");
				System.out.println("2. See the reviews of a product");
				System.out.println("3. Edit one of your existing reviews");
				System.out.println("4. Go back to the previous menu.");
				String categoryString = in.nextLine();
				char category = categoryString.toCharArray()[0];
				
				switch(category) {
				case '1':
					leaveReview();
					break;
				case '2':
					seeReviews();
					break;
				case '3':
					editReview();
					break;
				case '4':
					back();
					break;
				default:
					System.out.println("You have made an invalid selection. Please try again.");
				}
			}
			
			else if(str.equalsIgnoreCase("hello"))
				System.out.println("Hi! What can I help you with?");
			
			//Exit condition
			else if(str.equalsIgnoreCase("q"))
				break;
			
			//No understanding
			else
				System.out.println("Sorry, I can't understand your request. Please try again.");
		}
		in.close();
		System.out.println("Thank you, and have a wonderful day!");
	}
	
	public static void leaveReview() {
		System.out.println("It seems that you want to leave a review. Can you tell me which product you would like to review?");
		String str = in.nextLine();
		boolean found = false;
		for(int i = 0; i < products.length; i++) { //Try and find product to review
			if(str.toLowerCase().contains(products[i])) {
				found = true;
				System.out.printf("Great, you would like to review %s! Please leave your review now and I will submit it.\n",products[i]);
				str = in.nextLine();
				System.out.println("Thank you for your review. Can I help you with anything else?");
			} else if(i == products.length-1 && !found)
				System.out.println("Sorry, we can't seem to find a product that matches your query. Can I help you with anything else?");
		}
	}
	
	public static void seeReviews() {
		System.out.println("It seems that you are search for product reviews. Can you tell me which product you are looking for?");
		String str = in.nextLine();
		boolean found = false;
		for(int i = 0; i < products.length; i++) { //Try and find product to review
			if(str.toLowerCase().contains(products[i])) {
				found = true;
				System.out.printf("Here are the reviews for %s!\n",products[i]);
				System.out.printf("I think that %s was a great product! 5 stars.\n", products[i]);
				System.out.printf("Bought %s two days ago and already recieved it! Missing 1 screw but they offered to send me the missing part with no extra charge. 4 stars.\n", products[i]);
				System.out.printf("I think that %s was a great product! 5 stars.\n", products[i]);
				System.out.println("That is the end of the reviews.");
			} else if(i == products.length-1 && !found)
				System.out.println("Sorry, we can't seem to find a product that matches your query. Can I help you with anything else?");
		}
	}
	
	public static void editReview() {
		System.out.println("You would like to edit your review. Please select the review number you would like to edit.");
		for(int i = 0; i < userReviews.length; i++) {
			System.out.printf("%d. %s: %s\n",i, userReviews[i][0], userReviews[i][1]);
		}
		
	}
		
	public static void back() {
		System.out.println("This should take the user back to the initial category selection.");
	}
}