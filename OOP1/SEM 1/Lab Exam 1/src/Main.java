//Author: Isha Gadani

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		// type object = scanner varaible initiation
		Scanner scan = new Scanner(System.in);
		Conversion FtoC = new Conversion();
		
		//user input for fahrenheit
		System.out.println("Enter Fahrenheit temperature \n Fahrenheit Temperature ");
		FtoC.setfahrenheit(scan.nextDouble());
		
		//printing the calculated value for celsius
		System.out.println("Celsius Temperature "+ FtoC.toString());
		
		System.out.println("Programmed by Isha Gadani");
		
		//closing the scanner object
		scan.close();
	}
	

}
