package com.chain.day7;

import java.util.Scanner;

public class CabBooking {

	public static void main(String[] args) {
		int total;
		Scanner sc = new Scanner(System.in);
		String an;
		do {
			System.out.println("Choose your cab type:");
			System.out.println("1.Mini car ");
			System.out.println("2.Micro car");
			System.out.println("3.Prime car");
			System.out.println("Enter your type of cab:");
			int cab = sc.nextInt();
			switch (cab) {
			case 1: {
				System.out.println("you have selected mini car.It cost Rs.6/km");
				System.out.println("Do you want to continue with mini? yes/no");
				String op = sc.next();
				if (op.equals("yes")) {
					System.out.println("Enter how many Km you have to travel:");
					int a = sc.nextInt();
					if(a<=2) {
						System.out.println("please give above 2km");
						break;
					}
					total = a * 6;
					System.out.println("your payable amount is:" + total);
					System.out.println("Do you want to confirm your cab booking? ");
					char choice = sc.next().charAt(0);
					int bookingNumber = (int) ((float) Math.random()*10000);
					System.out.println("Booking Reference : "+bookingNumber);
					if (choice == 'y') {
						System.out.println("your cab is booked");
					} else {
						System.out.println("you cancelled your cab");
					}
				}
				break;
			}
			case 2: {
				System.out.println("you have selected micro car.It cost Rs.10/km");
				System.out.println("Do you want to continue with micro? yes/no");
				String op = sc.next();
				if (op.equals("yes")) {
					System.out.println("Enter how many Km you have to travel:");
					int a = sc.nextInt();
					if(a<=2) {
						System.out.println("please give above 2km");
						break;
					}
					total = a * 10;
					System.out.println("your payable amount is:" + total);
					System.out.println("Do you want to confirm your cab booking? ");
					char choice = sc.next().charAt(0);
					int bookingNumber = (int) ((float) Math.random()*10000);
					System.out.println("Booking Reference : "+bookingNumber);
					if (choice == 'y') {
						System.out.println("your cab is booked");
					} else {
						System.out.println("you cancelled your cab");
					}
				}
				break;
			}
			case 3: {
				System.out.println("you have selected prime car.It cost Rs.12/km");
				System.out.println("Do you want to continue with prime? yes/no");
				String op = sc.next();
				if (op.equals("yes")) {
					System.out.println("Enter how many Km you have to travel:");
					int a = sc.nextInt();
					if(a<=2) {
						System.out.println("please give above 2km");
						break;
					}
					total = a * 12;
					System.out.println("your payable amount is:" + total);
					System.out.println("Do you want to confirm your cab booking? ");
					char choice = sc.next().charAt(0);
					int bookingNumber = (int) ((float) Math.random()*10000);
					System.out.println("Booking Reference : "+bookingNumber);
					if (choice == 'y') {
						System.out.println("your cab is booked");
					} else {
						System.out.println("you cancelled your cab");
					}
				}
				break;
			}

			default: {
				System.out.println("Invalid choice");
			}
			}
			System.out.println("Do you want to book another cab?");
			an = sc.next();
		} while (an.equals("y"));
	}
}
