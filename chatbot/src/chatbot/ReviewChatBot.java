package chatbot;

import java.util.Scanner;

public class ReviewChatBot {

	public static void main(String[] args) {
		System.out.println("Hi! My name is Chadbot. What can I help you with today?");
		Scanner in = new Scanner(System.in);
		String str;
		String[] products = {"milk", "eggs", "bread", "tofu"};
		
		while (true) {
			str = in.nextLine();
			
			//Review section
			if(str.contains("review")) {
				System.out.println("It seems like you want to leave a review. Can you tell me which product you would like to review?");
				str = in.nextLine();
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
			
			//Exit condition
			else if(str.equalsIgnoreCase("q"))
				break;
			
			//No understanding
			else
				System.out.println("Sorry, I can't understand your request. Please try again.");
		}
		in.close();
	}

}
