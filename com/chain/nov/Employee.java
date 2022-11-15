package com.chain.nov;
import java.util.Scanner;
public class Employee {

	public static void main(String[] args) {
		Employee emp=new Employee();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter employee name:");
		String name=sc.next();
		System.out.println("enter employee ID:");
		int id=sc.nextInt();
		System.out.println(name);
		System.out.println(id);
	}

}
