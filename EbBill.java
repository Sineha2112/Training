package com.chain.day7;

import java.util.Scanner;

public class EbBill {

	public static void main(String[] args) {
		double total = 0;
		String e;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the type of consumer:");
			String type = sc.next();
			System.out.println("Enter the username:");
			String name = sc.next();
			if (name.length() >= 3) {
				System.out.println("Your name is valid");
			} else {
				System.out.println("Invalid username");
				break;
			}
			System.out.println("Enter the consumer number:");
			int num = sc.nextInt();
			if (num == 1256) {
				System.out.println("Valid consumer number");
			} else {
				System.out.println("Invalid consumer number");
				break;
			}
			System.out.println("Enter the consumed units:");
			int units = sc.nextInt();
			if (type.equals("domestic")) {
				if (units <= 100) {
					total = 1 * units;
				} else if (units > 100 && units <= 200) {
					total = 2.50 * units;
				} else if (units > 200 && units <= 500) {
					total = 4 * units;
				} else if (units > 500) {
					total = 6 * units;
				} else {
					System.out.println("Invalid data");
					break;
				}
				int billNo = (int) ((float) Math.random() * 10000);
				System.out.println("Bill Number is:" + billNo);
				System.out.println("your total cost is:" + total);
				System.out.println("Your bill is due in few days.please pay the bill.");

			}
			if (type.equals("commercial")) {
				if (units <= 100) {
					total = 2 * units;
				} else if (units > 100 && units <= 200) {
					total = 4.50 * units;
				} else if (units > 200 && units <= 500) {
					total = 6 * units;
				} else if (units > 500) {
					total = 7 * units;
				} else {
					System.out.println("Invalid data");
					break;
				}
				int billNo = (int) ((float) Math.random() * 10000);
				System.out.println("Bill Number is:" + billNo);
				System.out.println("your total cost is:" + total);
				System.out.println("Your bill is due in few days.please pay the bill.");
			}
			System.out.println("Exit? y/n");
			e = sc.next();
		} while (e.equals("n"));

	}
}
