package com.chain.day1;

import java.util.Scanner;

public class OddOrEvenLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a number to calculate odd or even:");
		int num = sc.nextInt();
		System.out.println("even numbers from 1 to " + num + " is:");
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				System.out.println(i + " ");
			}
		}
		System.out.println("odd numbers from 1 to " + num + " is:");
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 1) {
				System.out.println(i + " ");
			}
		}
	}

}
