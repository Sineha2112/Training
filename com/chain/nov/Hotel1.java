package com.chain.nov;

import java.util.Scanner;

public class Hotel1 {

	public static void main(String[] args) {
		Hotel1 ho1=new Hotel1();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter hotel name:");
		String name=sc.next();
		System.out.println("enter hotel place:");
		String place=sc.next();
		System.out.println("is hotel veg?");
		Boolean isHotelVeg=sc.nextBoolean();
		System.out.println("enter food name:");
		String food=sc.next();
		System.out.println(name);
		System.out.println(place);
		System.out.println(isHotelVeg);
		System.out.println(food);
	}

}
