package com.chain.day1;

import java.util.Scanner;

public class LeapYearOrNot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a year:");
		int num = sc.nextInt();
		while (num<=2100) { 
			if(num%4==0) {
			    System.out.println(num+" is a leap year");
			    num++;
			}
			else {
				System.out.println(num+" not a leap year");
				num++;
			}
		}
		
	}
}
