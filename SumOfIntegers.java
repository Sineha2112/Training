package com.chain.day1;

import java.util.Scanner;

public class SumOfIntegers {
	public static void main(String[] args) {
		int sum = 0,x;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the numbers of integer to be calculated:");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("enter the number:");
			x = sc.nextInt();
			sum = sum + x;
		}
		System.out.println("the sum of all the integers:"+sum);
	}
}
