package Factory;

import java.util.Scanner;
import PossibleObjects.Cylinder;
import PossibleObjects.Cuboid;


public class ShapeFactory{
	
	public Scanner input;
	
	public ShapeFactory() {
		input = new Scanner(System.in);
	}
	
	public int createShape() {
	
		int choice;
		boolean exitLoop = false;
		while (!exitLoop) {
        

			switch (choice) {
            	case 1:
            		System.out.println("Create Cylinder");
            		System.out.println("Enter Radius");
            		double radius = input.nextDouble();
            		System.out.println("Enter Height");
            		double height = input.nextDouble();
            		return new Cylinder(radius,height);
            		break;
            		
            	case 2:
            		System.out.println("Create Cuboid");
            		System.out.println("Enter Length");
            		double length = input.nextDouble();
            		System.out.println("Enter Height");
            		double height = input.nextDouble();
            		System.out.println("Enter Width");
            		double width = input.nextDouble();
            		return new Cuboid(length,width,height);
            		break;
            		
            	case 3:
            		exitLoop = true;
            		break;
                
        }
    }
		System.out.println("...exiting bye...");}



