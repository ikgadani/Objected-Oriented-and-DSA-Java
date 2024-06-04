/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */

import java.util.Formatter;
import java.util.Scanner;

class Vegetable extends FoodItem {
    protected String farmName;

   /* 
    * @param scanner   The scanner object for user input.
    * @param fromFile  Indicates whether the input is from a file.
    * @return True if the vegetable is successfully added, false otherwise.
    */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            System.out.print("Enter the name of the farm supplier: ");
            farmName = scanner.nextLine();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Generates a string representation of the Vegetable object.
     * Includes common attributes and the farm supplier name.
     *
     * @return A string containing item code, name, quantity in stock, price, cost, and farm supplier name.
     */
    public String toString() {
        return super.toString() + " farm supplier: " + farmName;
    }
    
    /**
     * Gets the farm supplier name for the vegetable.
     *
     * @return The name of the farm supplier.
     */
    public String getFarmName() {
		return farmName;
	}
    
    /**
     * Sets the farm supplier name for the vegetable.
     *
     * @param farmName The name of the farm supplier.
     */
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	
	/**
     * Outputs the vegetable item details, including common attributes and the farm supplier name.
     */	
    public void outputItemDetails() {
        System.out.println(toString());
    }
    
    /**
     * Outputs the vegetable item details, including common attributes and the farm supplier name, to a Formatter object.
     *
     * @param writer The Formatter object for output.
     */
    public void outputItem(Formatter writer) {
        super.outputItem(writer);  
        writer.format("%s%n", farmName);
    }

}