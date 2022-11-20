package com.chain.day1;

import java.util.Scanner;

public class ArrayNumbers {

	public static void main(String[] args) {
		int count=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of an array:");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("enter the numbers as 1's and 0's:");
		for(int i=0;i<n;i++) {
		  a[i]=sc.nextInt(); 
		}
		for(int i=0;i<n;i++) {
			if(a[i]==0) {
				count=count+1;
			}
		}
		System.out.println("Number of 0's are:"+count);
	}

}
