import java.util.Formatter;
import java.util.Scanner;

public class Fruit extends FoodItem {
    protected String orchardName;

    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            System.out.print("Enter the orchard name: ");
            orchardName = scanner.nextLine();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " orchard supplier: " + orchardName;
    }

    @Override
    public void outputItemDetails() {
        System.out.println(toString());
    }
    public void outputItem(Formatter writer) {
        super.outputItem(writer);  // Call the parent class's method
        writer.format("%s%n", orchardName);
    }
}
