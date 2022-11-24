package com.chain.day7;

import java.util.Scanner;

public class TestAreaOfTheTriangle {

	public static void main(String[] args) {
		AreaOfTheTriangle a=new AreaOfTheTriangle();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the base of the triangle:");
		int b=sc.nextInt();
		System.out.println("Enter the height of the triangle:");
		int h=sc.nextInt();
		a.area( b, h);
				
	}

}
