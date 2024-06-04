/*
 * Author: Isha Gadani
 * Date: Jan 22, 2023 
 * Description: A simple program to demonstrate that floating-point
 * types can have arithmetic problems with certain fractional values.
 */
public class Hybrid2 {

	public static void main(String[] args) {
		double sum = 0.1; // assigned 0.1
		sum = sum + 0.1; // expect that 0.2 is assigned
		sum = sum + 0.1; // expect that 0.3 is assigned
		sum = sum + 0.1; // expect that 0.4 is assigned
		sum = sum + 0.1; /// expect that 0.5 is assigned
		sum = sum + 0.1; // expect that 0.6 is assigned
		sum = sum + 0.1; // expect that 0.7 is assigned
		sum = sum + 0.1; // expect that 0.8 is assigned
		sum = sum + 0.1; // expect that 0.9 is assigned
		sum = sum + 0.1; // expect that 1.0 is assigned
		System.out.println("Sum is: " + sum);
	}
}
