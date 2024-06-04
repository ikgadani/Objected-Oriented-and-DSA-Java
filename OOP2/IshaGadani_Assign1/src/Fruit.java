/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */

import java.util.Formatter;
import java.util.Scanner;

public class Fruit extends FoodItem {
    protected String orchardName;

    /**
    * @param scanner   The scanner object for user input.
    * @param fromFile  Indicates whether the input is from a file.
    * @return True if the fruit is successfully added, false otherwise.
    */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            System.out.print("Enter the orchard name: ");
            orchardName = scanner.nextLine();
            return true;
        } else {
            return false;
        }
    }

    /**
    * @return A string containing item code, name, quantity in stock, price, cost, and orchard supplier name.
    */
    public String toString() {
        return super.toString() + " orchard supplier: " + orchardName;
    }

    /**
     * Outputs the fruit item details, including common attributes and the orchard supplier name.
     */
    public void outputItemDetails() {
        System.out.println(toString());
    }
    
    /**
     * Outputs the fruit item details, including common attributes and the orchard supplier name, to a Formatter object.
     *
     * @param writer The Formatter object for output.
     */
    public void outputItem(Formatter writer) {
        super.outputItem(writer);  
        writer.format("%s%n", orchardName);
    }
}
