package com.chain.nov;

import java.util.Scanner;

public class RelationalOp {

	public static void main(String[] args) {
		System.out.println("enter your age:");
		Scanner sc=new Scanner(System.in);
		int age=sc.nextInt();
		if(age>18){
			System.out.println("you are eligible to vote");
			System.out.println("enter your nationality:");
			String nationality=sc.next();
			if(nationality.equals("Indian")) {
				System.out.println("you ");
			}
			
		}
		

	}

}
