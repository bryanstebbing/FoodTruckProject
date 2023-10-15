package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	// description of a food truck
	private static int nextTruckId = 1;
	private int truckId;
	private String name;
	private String type;
	private int rating;

	public FoodTruck() {
	}

	public FoodTruck(String name, String foodType, int rating) {
		this.name = name;
		this.type = foodType;
		this.rating = rating;
		this.truckId = makeNewTruckId();
	}

	public int makeNewTruckId() {
		return nextTruckId++;
	}
	
	public int getTruckId() {
		return truckId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "This Trucks ID is: " + truckId + "\nThis Truck is Named: " + name + " \nThis Truck Serves: " + type + "\nThis Truck was Rated: " + rating
				+ "\n";
	}
}
