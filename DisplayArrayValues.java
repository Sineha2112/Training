package com.chain.day1;

import java.util.Scanner;

public class DisplayArrayValues {

	public static void main(String[] args) {
		int i;
	    Scanner sc = new Scanner(System.in);
	    System.out.print(" Enter Number of elements in an array : ");
	    int size = sc.nextInt();  
	    int [] a = new int[size];
	    System.out.print("Enter " + size + " elements of an Array  : ");
	    for (i = 0; i < size; i++)
	    {
	      a[i] = sc.nextInt();
	    }   
	    for(i = 0; i < size; i++)
	    {
	      if(a[i] >= 0)
	      {
	        System.out.println("Positive Number:"+a[i]);
	      }
	      else 
	      {
	        System.out.println("Negative Number:"+a[i]);
	      }
	            
	    } 
	}

}
