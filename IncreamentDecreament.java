package com.chain.day1;

public class IncreamentDecreament {

	public static void main(String[] args) {
		int a = 4;
		a++;
		a += a;
		--a;
		a = 7 + a;
		a *= a;
		a -= 3;

		System.out.println(" a = " + a);
	}
}
//The output of a is 253