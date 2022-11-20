package com.chain.day1;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumNo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of an array:");
		int n = sc.nextInt();
		int a[] = new int[n];
		System.out.println("enter a number:");
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
		for (int i = n - 1; i > 1; i--) {
			if (a[i] != a[i - 1]) {
				System.out.println(a[i] + " and " + a[i - 1] + " is two maximum elements in array");
				break;
			}
		}
	}
}
