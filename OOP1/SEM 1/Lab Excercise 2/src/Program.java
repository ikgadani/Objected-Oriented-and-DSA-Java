/*
 *Author: Isha Gadani
 *Date: February 3, 2023  
 */



//User-input for each of the variables
import java.util.Scanner;


public class Program {

	public static void main (String[] args) {
	
	//type object = scanner variable initiation 
	Scanner scan = new Scanner(System.in);
	Car car1 = new Car();
	
	//user input for vin  
	System.out.print("please enter vehicle identification number:");
	car1.setVIN(scan.nextLine()); 	
	
	//user input for mileage
	System.out.print("please enter vehicle mileage (KM):");
	car1.setMileage(scan.nextFloat());
	
	//user input for year
	System.out.print("please enter vehicle year:");
	car1.setVehicleYear(scan.nextInt());
	
	//user input for invoice
	System.out.print("please enter vehicle price:");
	car1.setInvoicePrice(scan.nextFloat());
	
	//toString method
	System.out.println(car1.toString());
	
	System.out.println("Created by Isha Gadani");
	
	scan.close();	
	}
}
