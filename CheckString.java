package com.chain.day1;

public class CheckString {

	public static void main(String[] args) {
		String s="umbrella";
		boolean b=true;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='e') {
				System.out.println("Is the letter 'e' present in the string :"+b);
				break;
			}
		}
	}
}