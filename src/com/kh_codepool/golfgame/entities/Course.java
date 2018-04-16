package com.kh_codepool.golfgame.entities;

import java.util.ArrayList;

public class Course {

	private static final double initialDistance = 1000;
	private final double courseSize = 2500;
	
	//An array list of type Swing 
	ArrayList<Swing> sw = new ArrayList<Swing>();

	public static double getInitialdistance() {
		return initialDistance;
	}

	//Adds the swings to the created array list
	public void addSwing(Swing swing) {

		sw.add(swing);

	}

	//Clears the the array list
	public void removeSwings() {
		sw.clear();

	}

	//Traverses the array list printing out the left distance for each attempted swing
	public void PrintSwingDetails() {
		System.out.println("\n/////The end/////");
		System.out.println("\n******Game Log******");
		System.out.println("No. of attempted swings: " + sw.size());

		for (int i = 0; i < sw.size(); i++) {

			System.out.println("the " + (i + 1) + " swing is  " + sw.get(i).getLeftDistance() + " m");

		}
		System.out.println("\n-----Good bye-----");

	}

}
