package com.chain.myexception;

public class InvalidPasswordException extends Exception{
	{
		System.out.println("Use strong password!!"+"\n"+"Must contain one lowercase,digit and one special character");
	}
}