package com.chain.day7;

public class ExampleNull {
	public static void main(String[] args) throws Exception {
		String s = null;
		if (s != null)
			System.out.println(s);
		else
			throw new Exception("Null values are passed");
	}
}
