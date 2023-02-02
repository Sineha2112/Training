package com.chain.myexception;

public class InvalidMobileNoException extends Exception {
	{
		System.out.println("Invalid phone number!"+"\n"+"Must contain 10 numbers");
	}
}
