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

    private int binarySearch(int code) {
        int left = 0;
        int right = inventory.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentCode = inventory.get(mid).getItemCode();

            if (currentCode == code) {
                return mid; // Item found
            } else if (currentCode < code) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Item not found
    }

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
            int index = binarySearch(code);

            if (index != -1) {
                System.out.println("Item code already exists");
                return false;
            }

            // Insert the new item in sorted order
            inventory.add(-index - 1, newItem);

            System.out.println("Item added to inventory.");
            return true;
        } else {
            System.out.println("Error adding item.");
            return false;
        }
    }

    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int itemCode = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            int index = binarySearch(itemCode);

            if (index != -1) {
                System.out.print("Enter valid quantity to " + (buyOrSell ? "buy" : "sell") + ": ");
                if (scanner.hasNextInt()) {
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (buyOrSell) {
                        inventory.get(index).itemQuantityInStock += quantity;
                        System.out.println("Quantity updated successfully.");
                    } else {
                        if (inventory.get(index).itemQuantityInStock >= quantity) {
                            inventory.get(index).itemQuantityInStock -= quantity;
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

    public String toString() {
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (FoodItem item : inventory) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }

    public void searchForItem(Scanner scanner) {
        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int itemCode = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            int index = binarySearch(itemCode);

            if (index != -1) {
                inventory.get(index).outputItemDetails();
            } else {
                System.out.println("Code not found in inventory...");
            }
        } else {
            System.out.println("Invalid code...");
        }
    }

    public void saveToFile(Scanner scanner) {
        System.out.print("Enter the filename to save to: ");
        String filename = scanner.nextLine();

        try (Formatter writer = new Formatter(new File(filename))) {
            for (FoodItem item : inventory) {
                writer.format("%s%n", item.getClass().getSimpleName().substring(0, 1).toLowerCase()); // Type (f, v, or p)
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
                    int code = newItem.getItemCode();
                    int index = binarySearch(code);

                    if (index != -1) {
                        System.out.println("Item code already exists. Aborting file reading.");
                        return;
                    }

                    inventory.add(-index - 1, newItem);
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
