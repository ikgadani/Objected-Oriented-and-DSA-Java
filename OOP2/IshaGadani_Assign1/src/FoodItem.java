/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class FoodItem {
    protected int itemCode;
    protected String itemName;
    protected float itemPrice;
    protected int itemQuantityInStock;
    protected float itemCost;

    /**
     * Default constructor for FoodItem class.
     * Initializes all attributes to their default values.
     */
    public FoodItem() {
        this.itemCode = 0;
        this.itemName = "";
        this.itemPrice = 0.0f;
        this.itemQuantityInStock = 0;
        this.itemCost = 0.0f;
    }
    /**
     * Prompts the user to input the item code.
     *
     * @param scanner   The scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item code is successfully input, false otherwise.
     */
    public boolean inputCode(Scanner scanner, boolean fromFile) {
        System.out.print("Enter the item code: ");
        if (scanner.hasNextInt()) {
            itemCode = scanner.nextInt();
            scanner.nextLine(); 
            return true;
        } else {
            System.out.println("Invalid item code. Please enter a valid integer.");
            scanner.nextLine(); 
            return false;
        }
    }
    /**
     * Prompts the user to input information for a new food item.
     *
     * @param scanner   The scanner object for user input.
     * @param fromFile  Indicates whether the input is from a file.
     * @return True if the item is successfully added, false otherwise.
     */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (inputCode(scanner, fromFile)) {
            System.out.print("Enter the name for the item: ");
            itemName = scanner.nextLine();

            System.out.print("Enter the quantity for the item: ");
            if (scanner.hasNextInt()) {
                itemQuantityInStock = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid quantity...");
                return false;
            }

            System.out.print("Enter the cost of the item: ");
            if (scanner.hasNextFloat()) {
                itemCost = scanner.nextFloat();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid cost...");
                return false;
            }

            System.out.print("Enter the sales price of the item: ");
            if (scanner.hasNextFloat()) {
                itemPrice = scanner.nextFloat();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid sales price...");
                return false;
            }

            return true; 
        } else {
            System.out.println("Invalid code...");
            return false;
        }
    }
    /**
     * Updates the quantity of the food item in stock.
     *
     * @param amount The amount by which to update the quantity.
     * @return True if the update is successful, false if it would result in a negative quantity.
     */
    public boolean updateItem(int amount) {
        if (itemQuantityInStock + amount >= 0) {
            itemQuantityInStock += amount;
            return true;
        }
        return false;
    }
    
    /**
     * Checks if two FoodItem objects have the same item code.
     *
     * @param item The FoodItem to compare to.
     * @return True if the item codes are equal, false otherwise.
     */
    public boolean isEqual(FoodItem item) {
        return this.itemCode == item.itemCode;
    }
    
    /**
     * Generates a string representation of the FoodItem object.
     *
     * @return A string containing item code, name, quantity in stock, price, and cost.
     */
   
    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $" + itemCost;
    }
    
    /**
     * Outputs the food item details to a Formatter object.
     *
     * @param writer The Formatter object for output.
     */
    public void outputItem(Formatter writer) {
        writer.format("%d%n", itemCode);       
        writer.format("%s%n", itemName);       
        writer.format("%d%n", itemQuantityInStock); 
        writer.format("%.2f%n", itemCost);      
        writer.format("%.2f%n", itemPrice);     
    }

    public void outputItemDetails() {
        // You can override this method in subclasses to provide specific details
    }

    public int getItemCode() {
        return itemCode;
    }

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	public void setItemQuantityInStock(int itemQuantityInStock) {
		this.itemQuantityInStock = itemQuantityInStock;
	}

	public float getItemCost() {
		return itemCost;
	}

	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
}