package com.chain.day7;

import java.util.Scanner;

public class HotelMethod {

	public static void main(String[] args) {
		customerName();
		displayMenu();
		bill();
	}
	public static void customerName(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		String name=sc.next();
		System.out.println("Welcome,"+name);
	}
	public static void displayMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("***MENU***"+"\n"+"Dosa"+"\n"+"Idly"+"\n"+"Briyani"+"\n"+"Fried rice");
		System.out.println("Enter your menu:");
		String menu=sc.next();
	}
	public static void bill() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your food quantity:");
		int quantity=sc.nextInt();
		System.out.println("Enter the cost of your food:");
		int cost=sc.nextInt();
		int bill=cost*quantity;
		System.out.println("The total bill is:"+bill);
		System.out.println("**Thank you.Visit again!!**");
	}
	

}
