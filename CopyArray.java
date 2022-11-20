package com.chain.day1;

import java.util.Arrays;
import java.util.Scanner;

public class CopyArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[10];
		System.out.println("enter any 10 numbers:");
		for (int i = 0; i < 10; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < 10; i++) {
			System.out.println("the Arrays are:" + a[i]);
		}
		for (int i = a.length - 1; i >= 0; i--) {
			String b = String.valueOf(a[i]);
			System.out.println("the reverse array is:" + b);
		}
	}
}
