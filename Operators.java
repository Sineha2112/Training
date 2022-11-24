package com.chain.day7;

import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
		// to print values from the user
		String s;
		Scanner sc= new Scanner(System.in);
		do {
			System.out.println("Enter any two numbers:");
			int n1=sc.nextInt();
			int n2=sc.nextInt();
			System.out.println("Choose the operator: +,-,*,/,%");
			char op=sc.next().charAt(0);
		switch(op) {
		case'+': {
			System.out.println("Addition:"+(n1+n2));
			break;
		}
		case'-': {
			System.out.println("Substraction:"+(n1-n2));
			break;
		}
		   case'*': {
			System.out.println("Multiplication:"+n1*n2);
			break;
		}
		case'/':{
			System.out.println("Division:"+n1/n2);
			break;
		}
		case'%':{
			System.out.println("Modulus:"+n1%n2);
			break;
		}
		default: {
			System.out.println("Invalid operator");
		}
		}
		System.out.println("Do you want to continue the operation? Y/N");
		s=sc.next();
		}while(s.equals("Y"));
		
		
	}	
}
