package carlot.test;

import carlot.Car;
import carlot.CarLot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to test the functionality of the CarLot and Car classes.
 */
public class CarLotTest {
    
    private static final String CAR_INVENTORY_FILE = "car_inventory.csv";
    private static final String CAR_SEARCH_FILE = "car_search.txt";

    /**
     * The main method that initiates the car lot testing.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        CarLot carLot = new CarLot();

        // Dynamically obtain the current date
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        // Print the header for the inventory report
        System.out.println("Honest AC's Used Car Lot Inventory for " + formattedDate);

        // Read car inventory from CSV file
        readCarInventory(carLot, CAR_INVENTORY_FILE);

        // Search for cars based on license plates in the text file
        searchAndPrintReports(carLot, CAR_SEARCH_FILE);
    }

    /**
     * Reads the car inventory data from a CSV file and adds cars to the CarLot.
     *
     * @param carLot   The CarLot to which cars will be added.
     * @param filename The name of the CSV file containing car inventory data.
     */
    private static void readCarInventory(CarLot carLot, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] carData = line.split(",");
                int year = Integer.parseInt(carData[0]);
                String make = carData[1];
                String licensePlate = carData[2].trim();
                Car car = new Car(year, make, licensePlate);
                carLot.addCar(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for cars in the CarLot based on license plates and prints a report.
     *
     * @param carLot   The CarLot to search for cars.
     * @param filename The name of the text file containing license plates to search for.
     */
    private static void searchAndPrintReports(CarLot carLot, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String licensePlate = line.trim();
                Car car = carLot.getCarByLicensePlate(licensePlate);
                if (car != null) {
                    // Car found, print details
                    System.out.printf("%-15s%s%n", licensePlate, car.toString());
                } else {
                    // Car not found, print "Not found"
                    System.out.printf("%-15s%s%n", licensePlate, "Not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
