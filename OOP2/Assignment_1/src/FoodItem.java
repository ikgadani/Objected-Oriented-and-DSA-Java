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

    public FoodItem() {
        this.itemCode = 0;
        this.itemName = "";
        this.itemPrice = 0.0f;
        this.itemQuantityInStock = 0;
        this.itemCost = 0.0f;
    }

    public boolean inputCode(Scanner scanner, boolean fromFile) {
        System.out.print("Enter the item code: ");
        if (scanner.hasNextInt()) {
            itemCode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            return true;
        } else {
            System.out.println("Invalid item code. Please enter a valid integer.");
            scanner.nextLine(); // Consume invalid input
            return false;
        }
    }

    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (inputCode(scanner, fromFile)) {
            System.out.print("Enter the name for the item: ");
            itemName = scanner.nextLine();

            System.out.print("Enter the quantity for the item: ");
            if (scanner.hasNextInt()) {
                itemQuantityInStock = scanner.nextInt();
                scanner.nextLine(); // Consume newline
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
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid sales price...");
                return false;
            }

            return true; // Successfully added item
        } else {
            System.out.println("Invalid code...");
            return false;
        }
    }

    public boolean updateItem(int amount) {
        if (itemQuantityInStock + amount >= 0) {
            itemQuantityInStock += amount;
            return true;
        }
        return false;
    }

    public boolean isEqual(FoodItem item) {
        return this.itemCode == item.itemCode;
    }

    @Override
    public String toString() {
        return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $" + itemPrice + " cost: $" + itemCost;
    }

    public void outputItem(Formatter writer) {
        writer.format("%d%n", itemCode);       // Output the item code
        writer.format("%s%n", itemName);       // Output the item name
        writer.format("%d%n", itemQuantityInStock); // Output the quantity
        writer.format("%.2f%n", itemCost);      // Output the cost
        writer.format("%.2f%n", itemPrice);     // Output the price
    }

    public void outputItemDetails() {
        // You can override this method in subclasses to provide specific details
    }

    public int getItemCode() {
        return itemCode;
    }
}