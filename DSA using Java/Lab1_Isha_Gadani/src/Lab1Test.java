/**

 * A brief description of the role of this class

 * Student Name: Isha Gadani

 * Student Number: 041085940

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Professor: Daniel Cormeir

 **/

import java.util.Scanner;

public class Lab1Test {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
		Lab1 lab_1 = new Lab1();
		
		
		
		System.out.println("Enter Start Value: ");
		int value = scan.nextInt();
		
		lab_1.generateAllValues(value);
		
	
	}
	
}
