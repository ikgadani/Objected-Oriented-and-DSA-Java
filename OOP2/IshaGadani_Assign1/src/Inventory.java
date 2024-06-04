/*
 * Name: Isha Gadani
 * Student Number: 041085940
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

class Inventory {
    protected int numItems;
    private ArrayList<FoodItem> inventory;

    public Inventory() {
        this.numItems = 0;
        this.inventory = new ArrayList<>();
    }
    
    /*
    * @param scanner   The scanner object for user input.
    * @param fromFile  Indicates whether the input is from a file.
    * @return True if the item is successfully added, false otherwise.
    */
    public boolean addItem(Scanner scanner, boolean fromFile) {
        FoodItem newItem;

        if (fromFile) {
            if (scanner.hasNextLine()) {
                String type = scanner.nextLine().toLowerCase();

                if (type.equals("f")) {
                    newItem = new Fruit();
                } else if (type.equals("v")) {
                    newItem = new Vegetable();
                } else if (type.equals("p")) {
                    newItem = new Preserve();
                } else {
                    System.out.println("Invalid entry in file.");
                    return false;
                }
            } else {
                System.out.println("Invalid entry in file.");
                return false;
            }
        } else {
            System.out.print("Do you wish to add a fruit(f), vegetable(v), or preserve(p)? ");
            String type = scanner.nextLine().toLowerCase();

            if (type.equals("f")) {
                newItem = new Fruit();
            } else if (type.equals("v")) {
                newItem = new Vegetable();
            } else if (type.equals("p")) {
                newItem = new Preserve();
            } else {
                System.out.println("Invalid entry");
                return false;
            }
        }

        if (newItem.addItem(scanner, fromFile)) {
            int code = newItem.getItemCode();
            int index = -1;

            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getItemCode() > code) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                
                inventory.add(index, newItem);
            } else {
                
                inventory.add(newItem);
            }

            System.out.println("Item added to inventory.");
            return true;
        } else {
            System.out.println("Error adding item.");
            return false;
        }
    }
    

    /**
     * Updates the quantity of an item in the inventory.
     *
     * @param scanner    The scanner object for user input.
     * @param buyOrSell  Indicates whether to buy or sell the item.
     * @return True if the update is successful, false otherwise.
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int itemCode = scanner.nextInt();
            scanner.nextLine(); 

            int index = searchItem(scanner); 

            if (index != -1) {
                System.out.print("Enter valid quantity to " + (buyOrSell ? "buy" : "sell") + ": ");
                if (scanner.hasNextInt()) {
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); 

                    if (buyOrSell) {
                        inventory.get(index).setItemQuantityInStock(inventory.get(index).getItemQuantityInStock() + quantity);
                        System.out.println("Quantity updated successfully.");
                    } else {
                        if (inventory.get(index).getItemQuantityInStock() >= quantity) {
                            inventory.get(index).setItemQuantityInStock(inventory.get(index).getItemQuantityInStock() - quantity);
                            System.out.println("Quantity updated successfully.");
                        } else {
                            System.out.println("Insufficient stock in inventory...");
                            return false;
                        }
                    }
                    return true;
                } else {
                    System.out.println("Invalid quantity...");
                    return false;
                }
            } else {
                System.out.println("Code not found in inventory...");
                return false;
            }
        } else {
            System.out.println("Invalid code...");
            return false;
        }
    }
    
    /**
     * Generates a string representation of the inventory, including all items.
     *
     * @return A string containing information about all items in the inventory.
     */

    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (FoodItem item : inventory) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
    
    /**
     * Searches for an item in the inventory by item code.
     *
     * @param scanner The scanner object for user input.
     * @return The index of the item in the inventory if found, or -1 if not found.
     */
    public int searchItem(Scanner scanner) {
        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int itemCode = scanner.nextInt();
            scanner.nextLine(); 

            int left = 0;
            int right = inventory.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int currentCode = inventory.get(mid).getItemCode();

                if (currentCode == itemCode) {
                    return mid; 
                } else if (currentCode < itemCode) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; 
    }

    
    public void saveToFile(Scanner scanner) {
        System.out.print("Enter the filename to save to: ");
        String filename = scanner.nextLine();

        try (Formatter writer = new Formatter(new File(filename))) {
            for (FoodItem item : inventory) {
                writer.format("%s%n", item.getClass().getSimpleName().substring(0, 1).toLowerCase()); 
                item.outputItem(writer);
            }
            System.out.println("Inventory saved to file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to save to the file.");
        }
    }

    public void readFromFile(Scanner scanner) {
        System.out.print("Enter the filename to read from: ");
        String filename = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String type = fileScanner.nextLine().toLowerCase();

                FoodItem newItem;

                if (type.equals("f")) {
                    newItem = new Fruit();
                } else if (type.equals("v")) {
                    newItem = new Vegetable();
                } else if (type.equals("p")) {
                    newItem = new Preserve();
                } else {
                    System.out.println("Invalid entry in the file.");
                    return;
                }

                if (newItem.addItem(fileScanner, false)) {
                    inventory.add(newItem);
                } else {
                    System.out.println("Error reading item from file. Aborting file reading.");
                    return;
                }
            }
            System.out.println("Inventory read from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

}
