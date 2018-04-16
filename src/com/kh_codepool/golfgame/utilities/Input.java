package com.kh_codepool.golfgame.utilities;

import java.util.Scanner;

import com.kh_codepool.golfgame.entities.Course;
import com.kh_codepool.golfgame.entities.Swing;

public class Input {

	//Generic method to receive input from user based on two predefined range of numeric values.
	//input is validated for wrong entries by throwing the appropriate error message.
	public static double playerInput(double start, double end) {

		Scanner scan = new Scanner(System.in);
		double value = 100000;
		do {
			System.out.print("You should insert a number between " + "<" + start + "  ,  " + end + ">    ");
			try {
				value = scan.nextDouble();

				if (value <= start || value >= end)
					throw new RuntimeException();
			} catch (Exception e) {
				System.out.println("Invalid Input! try again");

			}
			scan.nextLine();

		} while (value <= start || value >= end);
		return value;

	}

}
