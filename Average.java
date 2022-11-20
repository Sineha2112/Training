package com.chain.day1;

import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		int num, total = 0, count = 1;
		float average = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number :");
		int n = sc.nextInt();
		while (count <= n) {
			System.out.println("enter the " + count + " number:");
			num = sc.nextInt();
			total += num;
			++count;
		}
		average = total / n;
		System.out.println("the average value is:" + average);
	}

}
