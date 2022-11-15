package com.chain.nov;
import java.util.Scanner;
public class Book1 {

	public static void main(String[] args) {
		Book1 book=new Book1();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter book name:");
        String name=sc.next();
        System.out.println("enter author name:");
        String author=sc.next();
        System.out.println("enter book price:");
        int price=sc.nextInt();
        System.out.println("enter which type of genre:");
        String genre=sc.next();
        System.out.println(name);
        System.out.println(author);
        System.out.println(price);
        System.out.println(genre);
	}
	
}
