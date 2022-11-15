package com.chain.nov;
import java.util.Scanner;
public class ArithmeticOp {

	public static void main(String[] args) {
		ArithmeticOp op=new ArithmeticOp();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number:");
		int a=sc.nextInt();
		System.out.println("enter another number:");
		int b=sc.nextInt();
		System.out.println("addition:"+(a+b));
		System.out.println("multiplication:"+(a*b));
		System.out.println("substraction:"+(a-b));
		System.out.println("division:"+(a/b));
		System.out.println("modulus:"+(a%b));
	}

}
