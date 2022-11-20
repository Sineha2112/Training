package com.chain.day1;

import java.util.Scanner;

public class AgeCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your gender:");
		String gen = sc.next();
		System.out.println("enter your age:");
		int age = sc.nextInt();
		if (age > 25 && gen.equals("M")) {
			System.out.println("He is a Man");
		} 
		else if (age < 25 && gen.equals("M")) {
			System.out.println("He is a Boy");
		} 
		else if (age > 25 && gen.equals("F")) {
			System.out.println("She is a Women");
		} 
		else if (age < 20 && gen.equals("F")) {
			System.out.println("She is a Girl");
		} 
		else {
			System.out.println("Invalid data");
		}

	}

}
