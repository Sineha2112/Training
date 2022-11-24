package com.chain.day7;

import java.util.Arrays;

public class ArraysNum {

	public static void main(String[] args) {
		int mobileNumber[] = { 125, 52, 984, 728, 38 };
		String name[]= {"ria","zoy","ram","siva","tom"};
		System.out.println("Before sorting:");
		for (int i = 0; i < mobileNumber.length; i++) {
			System.out.println(  mobileNumber[i]);
		}
		System.out.println("After sorting:");
		for (int i = 0; i < mobileNumber.length; i++) {
			System.out.println( mobileNumber[i]);
		}
		System.out.println("The Number is in position:"+Arrays.binarySearch(mobileNumber, 3));

	}

}
