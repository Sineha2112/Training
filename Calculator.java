package com.chain.day1;

public class Calculator {
	public static void main(String[] args) {
		add();
		sub();
		div();
		mod();
	}

	public static void add() {
		int i = 10, j = 2;
		int add = i + j;
		System.out.println("Addition:" + add);
	}

	public static void sub() {
		int i = 10, j = 2;
		int sub = i - j;
		System.out.println("Substraction:" + sub);
	}

	public static void div() {
		int i = 10, j = 2;
		int div = i / j;
		System.out.println("Division:" + div);
	}

	public static void mod() {
		int i = 10, j = 2;
		int mod = i % j;
		System.out.println("Modulus:" + mod);
	}
}
