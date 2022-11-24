package com.chain.day7;

public class Exp {

	public static void main(String[] args) {
		int result,n1=10,n2=0;
		String s=null;
		int a[]= {1,2,4,5,6,3};
		try {              
			 result=n1/n2;
			 System.out.println(result);
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			for(int i=0;i<=6;i++) {
				System.out.println(a[i]);
			}
		}
		catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		catch(ArrayIndexOutOfBoundsException arr){
		System.out.println(arr.getMessage());
		}
		catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			if(s.length()>5) {
				System.out.println("valid");
			}
			else {
				System.out.println("invalid");
			}
		}
		catch(NullPointerException ne) {
			System.out.println(ne.getMessage());
		}
	}

}
