package com.chain.day1;

import java.util.Scanner;

public class NameDisplay {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your full name:");
		String st=sc.nextLine();
		System.out.println("The full name is:"+st);
		String  sr = "";
		sr = sr+st.charAt(0);
	    sr = sr+". ";
	    for (int i = 0; i<st.length();i++){
	      if(st.charAt(i) == ' '&& st.charAt(i+1)!=' ' && i+1<st.length()){
	        sr = (sr+st.charAt(i+1)).toUpperCase();
	        sr = sr+".";
	      }
	    }
		String lastWrd = "";
		for(int i = st.length()-1;i>=0;i--){
			if(st.charAt(i) == ' '){
				lastWrd =st.substring(i+2);
				break;
			}
		}
		sr = sr.substring(0,sr.length()-1);
		sr = sr+lastWrd;
		System.out.println(sr);
	}
}
