package com.chain.day1;

import java.util.Arrays;

public class SumProductOfArray {

	public static void main(String[] args) {
		int sum = 0, product = 1;
		int a[] = { 1, 2, 3, 4, 5, 6 };
		for (int i : a) {
			sum = sum + i;
			product = product * i;
		}
		System.out.println("Given Array:"+Arrays.toString(a));
		System.out.println("the sum of an array is:" + sum);
		System.out.println("the product of an array is:" + product);
	}
}
