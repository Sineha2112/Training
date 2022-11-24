package com.chain.day7;

public class ExampleArrayEx {

	public static void main(String[] args) {
		int a[]= {1,2,6,9,3,10};
		try {
			for(int i=0;i<=6;i++) {
				System.out.println(a[i]);
			}
		}
		catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println(ae.getMessage());
		}
		}

	}


