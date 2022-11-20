package com.chain.day1;

public class FindString {

	public static void main(String[] args) {
			String s="Hello, World";
			int a=s.indexOf('o');
			System.out.println("The first occurence of the letter of 'o' is in "+a+" position");
			int b=s.indexOf(',');
			System.out.println("The first occurence of the letter of ',' is in "+b+" position");
			int a1=s.lastIndexOf('o');
			System.out.println("The last occurence of the letter of 'o' is in "+a1+" position");
			int b1=s.lastIndexOf(',');
			System.out.println("The last occurence of the letter of ',' is in "+b1+" position");
	}

}
