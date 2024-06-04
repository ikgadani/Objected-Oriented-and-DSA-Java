package carlot;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a car lot that manages a collection of cars based on their license plates.
 */
public class CarLot {
    private Map<String, Car> inventory;

    /**
     * Constructs a new CarLot with an empty inventory.
     */
    public CarLot() {
        this.inventory = new HashMap<>();
    }

    /**
     * Adds a car to the car lot's inventory.
     *
     * @param car The car to be added.
     */
    public void addCar(Car car) {
        inventory.put(car.getLicensePlate(), car);
    }

    /**
     * Retrieves a car from the car lot's inventory based on its license plate.
     *
     * @param licensePlate The license plate of the car to retrieve.
     * @return The car with the specified license plate, or null if not found.
     */
    public Car getCarByLicensePlate(String licensePlate) {
        return inventory.get(licensePlate);
    }
}
