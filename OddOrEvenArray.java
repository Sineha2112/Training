package com.chain.day1;

public class OddOrEvenArray {

	public static void main(String[] args) {
		int a[]={1,2,5,6,3,2,8,20};  
		System.out.println("Odd Numbers are:");  
		for(int i=0;i<a.length;i++){  
		if(a[i]%2!=0){  
		System.out.println(a[i]);  
		}  
		}  
		System.out.println("Even Numbers are:");  
		for(int i=0;i<a.length;i++){  
		if(a[i]%2==0){  
		System.out.println(a[i]);  
		}  
		}  
	}

}
