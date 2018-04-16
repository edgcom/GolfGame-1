package com.kh_codepool.golfgame.entities;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh_codepool.golfgame.utilities.Input;

public class Swing {

	// creating necessary class fields;
	private double angleInRadians;
	private double traversedDistance;

	// It is a field that will never change so it is set to final
	private final double gravity = 9.8;
	private double leftDistance;

	private double angle;
	private double velocity;

	//Constructor that receives one parameter
	public Swing(double leftDistance) {
		this.leftDistance = leftDistance;

	}

	// prints the current distance after each swing
	public void currentDistance() {
		System.out.println("Your starting point has changed. The ball is this distance away from the cup: "
				+ this.getLeftDistance() + " m");

	}

	public double getGravity() {
		return gravity;

	}

	public double getAngle() {
		return angle;
	}

	public void setAngle() {

		this.angle = Input.playerInput(0, 90);

	}

	public double getVelocity() {
		return velocity;
	}

	// Sets the velocity with a specific range
	public void setVelocity() {
		this.velocity = Input.playerInput(0, 150);
	}

	public double getAngleInRadians() {
		return angleInRadians;
	}

	// Calculates angle in radians using an equation where the angle is manually
	// input by player
	public void setAngleInRadians() {
		this.angleInRadians = (Math.PI / 180) * this.getAngle();

	}

	// Calculates angle in radians using an equation where the velocity is manually
	// input by player
	public void setTraversedDistance() {
		this.traversedDistance = Math.pow(this.getVelocity(), 2) / this.getGravity()
				* Math.sin(2 * this.getAngleInRadians());
	}

	public double gettraversedDistance() {
		return traversedDistance;
	}

	public void setLeftDistance() {
		this.leftDistance = this.getLeftDistance() - this.gettraversedDistance();
	}

	/*Depending on the ball's left distance from cup it is considered in rough or out of bound.
	In both cases the left distance value will be made positive. If it is a negative valueThe value of 1 is returned 
	when the ball is out of range. */
	public int isInRange() {
		int range = 0;

		if (this.getLeftDistance() < -10 && this.getLeftDistance() > -50) {
			this.rough();
			this.makePositive();
		}

		else if (this.getLeftDistance() < -50 && this.getLeftDistance() > -2000) {
			this.outOfBound();
			this.makePositive();
			range = 1;
		}

		return range;

	}

	public void outOfBound() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("WARNING : The ball is out of bound!!");
		System.out.println("Your stating point has been reset to default (re-initialized");
		this.leftDistance = Course.getInitialdistance();

	}

	public void rough() {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("Please note: The ball have entered the rough!!");

	}

	//Turns a negative value into a positive one
	public void makePositive() {

		this.leftDistance = Math.abs(this.getLeftDistance());

	}

	public double getLeftDistance() {
		return leftDistance;
	}

	public void hit() {
		this.setAngleInRadians();
		this.setTraversedDistance();
		this.setLeftDistance();

	}

	/*Returns true if the ball is in cup. The requirement requires a tolerance of 0.1m but 
	 a tolerance of +/-10m has been used to make it easier to get the ball in the cup 
	 although it does not resemble reality*/
	public boolean isInCup() {
		if (this.getLeftDistance() < 10 && this.getLeftDistance() > -10) {
			System.out.println("-----------------------------------------");
			System.out.println("\nWell done!! you got the ball in the cup.\n");
			System.out.println("-----------------------------------------");
			return true;

		}
		return false;
	}

}
