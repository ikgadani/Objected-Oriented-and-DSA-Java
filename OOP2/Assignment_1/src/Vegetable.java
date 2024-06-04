import java.util.Formatter;
import java.util.Scanner;

class Vegetable extends FoodItem {
    protected String farmName;

    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            System.out.print("Enter the name of the farm supplier: ");
            farmName = scanner.nextLine();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " farm supplier: " + farmName;
    }

    @Override
    public void outputItemDetails() {
        System.out.println(toString());
    }
    
    public void outputItem(Formatter writer) {
        super.outputItem(writer);  // Call the parent class's method
        writer.format("%s%n", farmName);
    }

}