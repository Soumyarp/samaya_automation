package com.samaya.qa.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		 
	//	System.out.println(System.currentTimeMillis()); // 1511154248013
		
		long curentDateTime= System.currentTimeMillis();
		Date currentdate = new Date(curentDateTime);
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		System.out.println(dateformat.format(currentdate));
		

	}

}
