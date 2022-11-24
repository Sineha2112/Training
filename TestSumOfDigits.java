package com.chain.day7;

import java.util.Scanner;

public class TestSumOfDigits {

	public static void main(String[] args) {
		SumOfDigits s=new SumOfDigits();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the numbers:");
		int num=sc.nextInt();
		s.sum( num);

	}

}
