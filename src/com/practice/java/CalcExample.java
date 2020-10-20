package com.practice.java;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CalcExample {

	public static double takeUserInput(Scanner sc, String count) {
		double f = 0;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter " +count+ " number");
			String num = sc.next();
			try {
				sc.nextLine();
				f = Double.parseDouble(num);
				if (!verifyCorrectRange(f) && (i<2)) {
					System.out.println("Number should be greater then 1 or less then 999.99");
					continue;
				} else if (!verifyCorrectRange(f) && (i==2)){
					System.out.println("No attempt left");
					System.exit(0);
				}
				break;
			} catch (ClassCastException | NumberFormatException e) {
				if (i < 2) {
					System.out.println("Not a number please try again");
					continue;
				} else {
					System.out.println("No attempt left");
					System.exit(0);
				}
			}
		}
		return f;
	}
	
	public static boolean verifyCorrectRange(double a) {
		boolean b = false;
		if (a<1 || a>999.99) {
			b = true;
		}
		return b;
	}

	public static BigDecimal stripZeroes(double num) {
		BigDecimal bigdecimal = new BigDecimal(num).setScale(2, RoundingMode.HALF_EVEN);
		bigdecimal = bigdecimal.stripTrailingZeros();
		return bigdecimal;
	}
	
	public static double add(double a, double b) {
		return a+b;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double a = takeUserInput(sc, "First");
		double b = takeUserInput(sc, "Second");
		double c = add(a, b);
		System.out.println(stripZeroes(c));
		sc.close();
	}
}
