package com.chain.nov;

public class TestHotel {

	public static void main(String[] args) {
		Hotel hot=new Hotel();
		hot.name="Arabian nights";
		hot.menu="shawarma";
		hot.price=120;
		hot.isHotelVeg=false;
		hot.place="Tambaram";
		System.out.println(hot.name+"\n"+hot.menu+"\n"+hot.price+"\n"+hot.isHotelVeg+"\n"+hot.place);

	}

}
