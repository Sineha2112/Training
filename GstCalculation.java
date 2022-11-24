package com.chain.day7;

import java.util.Scanner;

public class GstCalculation {

	public static void main(String[] args) {
		int total = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Customer name:");
		String name = sc.next();
		boolean str=name.matches("[a-zA-Z]+");
		if (str==true) {
			System.out.println("User name is valid");
			System.out.println("Enter the category: ");
			System.out.println("1.Food products");
			System.out.println("2.Electronics products");// 12
			System.out.println("3.Gold Jewellery products");// 18
			System.out.println("4.Motorcycles");// 28
			int category = sc.nextInt();
			switch (category) {
			case 1:
				System.out.println("You have selected food product category." + "\n" + "The GST of this product is 2%");
				System.out.println("Enter your product name:");
				String fName = sc.next();
				System.out.println("Enter your products quantity:");
				int quantity = sc.nextInt();
				System.out.println("Enter cost of the products: ");
				int cost = sc.nextInt();
				System.out.println("\t***************WELCOME**************");
				System.out.println("\t----------JANU Food Court----------");
				System.out.println("Bill No:1" + "\t\t\tDate:23/11/2022");
				System.out.println("\t\t\t\tTime:11:45:26");
				System.out.println("Product name:\t " + fName + "\n" + "Product quantity: " + quantity + "\n"
						+ "Product cost: \t " + cost);
				if (cost > 0) {
					total = cost * quantity;
					total = total*2*100 / 100;
					System.out.println("The total cost with GST is:" + total);
					if (total >= 1000) {
						int couponCode = (int) ((float) Math.random() * 1000);
						System.out.println("Your coupon code for your purchase is:" + couponCode);
					}
					System.out.println("\t***Thank you.Visit Again!!!***");
				} else {
					System.out.println("please enter Valid rupees");
				}

				break;
			case 2:
				System.out.println(
						"You have selected electronics product category." + "\n" + "The GST of this product is 12%");
				System.out.println("Enter your product name:");
				String name1 = sc.next();
				System.out.println("Enter your products quantity:");
				int quantity1 = sc.nextInt();
				System.out.println("Enter cost of the products: ");
				int price = sc.nextInt();
				System.out.println("\t***************WELCOME**************");
				System.out.println("\t----------JANU ELECTRONICS----------");
				System.out.println("Bill No:1" + "\t\t\tDate:23/11/2022");
				System.out.println("\t\t\t\tTime:11:45:26");
				System.out.println("Product name: " + name1 + "\n" + "Product quantity: " + quantity1 + "\n"
						+ "Product cost: " + price);
				if (price > 0) {
					total = price * quantity1;
					total = total * 12 * 100 / 100;
					System.out.println("The total cost with GST is:" + total);
					if (total >= 100000) {
						int couponCode = (int) ((float) Math.random() * 1000);
						System.out.println("Your coupon code for your purchase is:" + couponCode);
					}
					System.out.println("\t***Thank you.Visit Again!!!***");
				} else {
					System.out.println("please enter Valid rupees");
				}

				break;
			case 3:
				System.out
						.println("You have selected food product category." + "\n" + "The GST of this product is 18%");
				System.out.println("Enter your product name:");
				String name2 = sc.next();
				System.out.println("Enter your products quantity:");
				int quantity2 = sc.nextInt();
				System.out.println("Enter cost of the products: ");
				int price2 = sc.nextInt();
				System.out.println("\t***************WELCOME***********");
				System.out.println("\t----------JANU GOLDS----------");
				System.out.println("Bill No:1" + "\t\t\tDate:23/11/2022");
				System.out.println("\t\t\t\tTime:11:45:26");
				System.out.println("Product name: " + name2 + "\n" + "Product quantity: " + quantity2 + "\n"
						+ "Product cost: " + price2);
				if (price2 > 0) {
					total = price2 * quantity2;
					total = total * 18 * 100 / 100;
					System.out.println("The total cost with GST is:" + total);
					if (total >= 1000000) {
						int couponCode = (int) ((float) Math.random() * 1000);
						System.out.println("Your coupon code for your purchase is:" + couponCode);
					}
					System.out.println("\t***Thank you.Visit Again!!!***");

				} else {
					System.out.println("please enter Valid rupees");
				}

				break;
			case 4:
				System.out
						.println("You have selected food product category." + "\n" + "The GST of this product is 28%");
				System.out.println("Enter your product name:");
				String name3 = sc.next();
				System.out.println("Enter your products quantity:");
				int quantity3 = sc.nextInt();
				System.out.println("Enter cost of the products: ");
				int price3 = sc.nextInt();
				System.out.println("\t***************WELCOME*****************");
				System.out.println("\t----------JANU MOTORVECHICLES----------");
				System.out.println("Bill No:1" + "\t\t\tDate:23/11/2022");
				System.out.println("\t\t\t\tTime:11:45:26");
				System.out.println("Product name: " + name3 + "\n" + "Product quantity: " + quantity3 + "\n"
						+ "Product cost: " + price3);
				if (price3 > 0) {
					total = price3 * quantity3;
					total = total * 28 * 100 / 100;
					System.out.println("The total cost with GST is:" + total);
					if (total >= 10000000) {
						int couponCode = (int) ((float) Math.random() * 1000);
						System.out.println("Your coupon code for your purchase is:" + couponCode);
					}
					System.out.println("\t***Thank you.Visit Again!!!***");

				} else {
					System.out.println("please enter Valid rupees");
				}

				break;
			default:
				System.out.println("Invalid choice");
			}
		} else {
			System.out.println("Invalid user name");
		}

	}

}
