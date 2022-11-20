package com.chain.day1;

public class LargestSmallestArray {

	public static void main(String[] args) {
		int a[]= new int[] {15,2,6,3,8,10};
		int j;
		int large=0;
		int small=0;
		for(int i=0;i<a.length;i++) {
			System.out.println("the arrays are:"+a[i]);
		}
		for( j=0;j<a.length;j++) {
			if(a[j]>large) 
				large=a[j];
		   if(a[j]<small) 
				small=a[j];
		}
		System.out.println("the largest number is:"+a[j]);
		System.out.println("the smallest number is:"+a[j]);
	}

}
