package com.chain.nov;

import java.util.Scanner;

public class Hospital1 {
	public static void main(String[] args) {
		Hospital1 hos=new Hospital1();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter hospital name:");
		String name=sc.next();
		System.out.println("enter hospital place:");
		String place=sc.next();
		System.out.println("enter the hospital specialized in:");
		String specializedIn=sc.next();
		System.out.println("enter the total number of vechicles:");
		int numOfVechicles=sc.nextInt();
		System.out.println(name);
		System.out.println(place);
		System.out.println(specializedIn);
		System.out.println(numOfVechicles);
	}

}
