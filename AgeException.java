package com.chain.day7;

public class AgeException {

	public static void main(String[] args) throws InvalidAgeException {
		int age=4;
		if(age>18) {
			System.out.println("Eligible");
		}
		else
			throw new InvalidAgeException();

	}

}
