/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */

import java.util.Formatter;
import java.util.Scanner;

class Preserve extends FoodItem {
    protected int jarSize;
    
    
    /*
    * @param scanner   The scanner object for user input.
    * @param fromFile  Indicates whether the input is from a file.
    * @return True if the preserve is successfully added, false otherwise.
    */
    
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            System.out.print("Enter the size of the jar in millilitres: ");
            if (scanner.hasNextInt()) {
                jarSize = scanner.nextInt();
                scanner.nextLine(); 
                return true;
            } else {
                System.out.println("Invalid jar size...");
                return false;
            }
        } else {
            return false;
        }
    }

    /*
    * @return A string containing item code, name, quantity in stock, price, cost, and jar size.
    */
    public String toString() {
        return super.toString() + " size: " + jarSize + "mL";
    }
    
    /**
     * Outputs the preserve item details, including common attributes and the jar size.
     */
    
    public void outputItemDetails() {
        System.out.println(toString());
        
    }/**
     * Outputs the preserve item details, including common attributes and the jar size, to a Formatter object.
    *
    * @param writer The Formatter object for output.
    */

    
    public void outputItem(Formatter writer) {
        super.outputItem(writer);  
        writer.format("%d%n", jarSize);
    }

}