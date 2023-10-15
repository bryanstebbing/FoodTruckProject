package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;

import java.util.Scanner;

public class FoodTruckApp {

	private int numberOfTrucks = 5;
	private FoodTruck[] fleet = new FoodTruck[numberOfTrucks];
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	public void run() {
		addTruck();
		secondMenu();
		scanner.close();

	}

	public void addTruck() {
		for (int i = 0; i < fleet.length; i++) {

			System.out.println("Please enter the NAME of a Food Truck! Or type QUIT to exit.");
			String name = scanner.nextLine();
			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("Please enter the TYPE of Food Truck this will be!");
			String type = scanner.nextLine();

			System.out.println(
					"Please rate this truck between 1 (horrible) and 5 (amazing!) Please be kind, these people work very hard.\n");
			int rating = scanner.nextInt();
			scanner.nextLine();

			FoodTruck truck = new FoodTruck(name, type, rating);
			fleet[i] = truck;
		}
		// call another method here for the next display
		// prompt user for name, food type, and rating
		// write out a menu for user input
		// use if else statement to recognize when the user
		// says quit and that 5 spots have been filled
	}

	public void secondMenu() {
		while (true) {
			System.out.println("1. List all existing food trucks and associated info.\n");
			System.out.println("2. See the average rating of Food Trucks entered.\n");
			System.out.println("3. Display the highest-rated Food Truck.\n");
			System.out.println("4. Leave and never return.....unless you want to.\n");

			System.out.println("Please type 1, 2, 3, or 4 to make a choice.");
			int option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {
			case 1:
				listAllFoodTrucks();
				break;
			case 2:
				calcAvgRatings();
				break;
			case 3:
				bestestTruck();
				break;
			case 4:
				System.out.println("Thanks for making trucks and judging them! Have a nice day!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println(
						"Sorry, you must have fat-fingered the keyboard. Please try again when you have more patience.");
			}

		}
	}

	public void listAllFoodTrucks() {
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				System.out.println(fleet[i]);
			}
		}
	}

	public void calcAvgRatings() {
		int truckRatings = 0;
		int numberOfTrucks = 0;
		
		
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null) {
				truckRatings += fleet[i].getRating();
				numberOfTrucks++;
			} 
			
		}
				
		if (numberOfTrucks > 0 ) {
			double averageTruckRating = (double) truckRatings / numberOfTrucks;
			System.out.println("Average truck rating: " + averageTruckRating);
		} else {
			System.out.println("There are no trucks in the system!");
		}
	}

	public void bestestTruck() {
		if (fleet[0] == null) {
			System.out.println("There are no trucks in the system!");
		}
		
		FoodTruck bestestTruck = fleet[0];
		
		for (int i = 0; i < fleet.length; i++) {
			if (fleet[i] != null && fleet[i].getRating() > bestestTruck.getRating()) {
				bestestTruck = fleet[i];
			}
		}
		
		System.out.println("The Highest Rated Food Truck you entered was......" + bestestTruck);
	}

}
