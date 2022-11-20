package com.chain.day1;

import java.util.Scanner;

public class Season {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a month number:");
		int month = sc.nextInt();
		switch (month) {
		case 1:
		case 2:
		case 3:
			System.out.println("Spring season");
			break;
		case 4:
		case 5:
		case 6:
			System.out.println("Summer season");
			break;
		case 7:
		case 8:
		case 9:
			System.out.println("Autumn season");
			break;
		case 10:
		case 11:
		case 12:
			System.out.println("Winter season");
			break;
		default:
			System.out.println("Invalid number");
		}
	}

}
