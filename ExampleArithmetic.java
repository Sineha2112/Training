package com.chain.day7;

public class ExampleArithmetic {

	public static void main(String[] args) {
		int n1=15,n2=0;
		try {
		int result=n1/n2;
		System.out.println(result);
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
	}
		
	}
}
