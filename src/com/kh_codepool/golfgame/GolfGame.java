package com.kh_codepool.golfgame;

import com.kh_codepool.golfgame.entities.Course;
import com.kh_codepool.golfgame.entities.Swing;

public class GolfGame {

	public static void main(String[] args) {

		// Create an object of Swing class
		Swing s = new Swing(Course.getInitialdistance());
		// Create an instance of Course class
		Course course = new Course();

		int allowedAttempts = 0;
		boolean keepRunning;

		System.out.println("\n*******Welocme to this Golf Game***********\n");
		System.out.println("Game Information: The game requires two input values namely angle and velocity");
		System.out.println("You have a total of 7 swings before the game quits\n");

		do {

			System.out.println("Insert angle: ");
			// Sets the angle with the user inserted value
			s.setAngle();

			System.out.println("-------------------------------------------");

			System.out.println("Insert velocity: ");
			// Sets the velocity with the user inserted value
			s.setVelocity();

			System.out.println("-------------------------------------------");
			System.out.println("angle: " + s.getAngle() + "      " + "velocity: " + s.getVelocity());
			System.out.println("-------------------------------------------");
			System.out.println("-------------------------------------------");
			
			/* Here three values are calculated and set in this respective order: angle in
			 radians, traversed distance and finally left distance*/
			s.hit();

			//Informs the player of current distance after the attempted swing (Hit of the ball)
			s.currentDistance();

			keepRunning = s.isInCup();

			//If allowed attempts are 7 then the game terminates displaying a failure message
			if (allowedAttempts == 6) {
				keepRunning = true;
				System.out.println(
						"\nThe number of allowed swing attempts have been exceeded.\nTherefore the game ended");
			}

			//If the ball is out of range such that it is in rough then add a new swing to the array list
			else if (s.isInRange() == 0)
				course.addSwing(new Swing(s.getLeftDistance()));
			
			//if the ball is out of range such that it is out of bound then clear the array list
			else if (s.isInRange() == 1)
				course.removeSwings();

			allowedAttempts++;
		} while (keepRunning == false);
		
		//Prints the number of swings attempted and the left distance at each swing
		course.PrintSwingDetails();
	}

}
