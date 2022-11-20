package com.chain.day1;

public class Fibonacci {

	public static void main(String[] args) {
		int count = 5, i;
		int n1 = 0, n2 = 1, n3;
		System.out.println(n1);
		System.out.println(n2);
		for (i = 2; i < count; ++i) {
			n3 = n1 + n2;
			System.out.println(n3 + "");
			n1 = n2;
			n2 = n3;
		}
	}

}
