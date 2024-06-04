/**

 * A brief description of the role of this class

 * Student Name: Isha Gadani

 * Student Number: 041085940

 * Course: CST8132 Object Oriented Programming

 * Program: CET-CS-Level 2

 * Lab Professor: Daniel Cormier

 *

  */


public class Lab1 {
	 
	public int value;
	
	public int computeNextValue(int value) {
		int nextValue;
		
			if (value % 2 == 0) {
				
				nextValue = value/2;
			}
			
			else {
				
				nextValue = (value*3) + 1;			
			
		}
			return nextValue;
	}
	
	public void generateAllValues (int nextValue) {
		
		int count = 1;
		
		while(nextValue != 1) {
			
			nextValue = computeNextValue(nextValue);
			System.out.println(nextValue);
			count = count+1;
		}  
		
		System.out.println("Sequence is " + count + " long");
	}
	
}
