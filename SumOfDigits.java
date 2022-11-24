package com.chain.day7;

public class SumOfDigits {
	public void sum(int num) {
		int n=0,sum = 0;
		while(num>0) {
			n=num%10;
			sum = sum + n;
			num=num/10;
		}
		System.out.println("the sum of digits is:" + sum);
	}

}
