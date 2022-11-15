package com.chain.nov;

public class TestBook {

	public static void main(String[] args) {
		Book bo=new Book();
		bo.name="java";
		bo.genre="education";
		bo.price=230;
		bo.author="James";
		bo.volume=1;
		System.out.println(bo.name+"\n"+bo.price+"\n"+bo.genre+"\n"+bo.author+"\n"+bo.volume);

	}

}
