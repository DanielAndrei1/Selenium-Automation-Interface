package main;

import controller.Selenium;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Selenium();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
