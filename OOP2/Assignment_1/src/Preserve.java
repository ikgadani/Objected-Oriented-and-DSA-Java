import java.util.Formatter;
import java.util.Scanner;

class Preserve extends FoodItem {
    protected int jarSize;

    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (super.addItem(scanner, fromFile)) {
            System.out.print("Enter the size of the jar in millilitres: ");
            if (scanner.hasNextInt()) {
                jarSize = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                return true;
            } else {
                System.out.println("Invalid jar size...");
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " size: " + jarSize + "mL";
    }

    @Override
    public void outputItemDetails() {
        System.out.println(toString());
    }
    
    public void outputItem(Formatter writer) {
        super.outputItem(writer);  // Call the parent class's method
        writer.format("%d%n", jarSize);
    }

}