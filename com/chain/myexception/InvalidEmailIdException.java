package com.chain.myexception;

public class InvalidEmailIdException extends Exception {
	{
		System.out.println("Invalid email id!!"+"\n"+"Mail id should be in characters with one @symbol");
	}
}
