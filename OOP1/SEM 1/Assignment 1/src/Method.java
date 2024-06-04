/*Author: Isha Gadani
 *Date: February 9, 2023
 *Description: This is the main class
 *where all the variables and objects 
 *are called. The volume is calculated and is printed.
 */

// importing the scanner method for user input
import java.util.Scanner;


public class Method {

	public static void main (String[] args) {
		
		//type object = scanner variable initiation
		Scanner scan = new Scanner(System.in);
		Cone cone1 = new Cone();
		
		//user input for height
		System.out.println("Please enter the height of the cone");
		cone1.setheightCone(scan.nextDouble());
		
		//user input for radius
		System.out.println("Please enter the radius of the cone");
		cone1.setradiusCone(scan.nextDouble());
		
		//printing the calculated value of the volume of cone
		System.out.println("The volume of the cone is \n"+ cone1.toString());
		
		System.out.println("Program by Isha Gadani");

		//scan object closed
		scan.close();
	}
		
}

