package carlot;

/**
 * Represents a car with its year, make, and license plate information.
 */
public class Car {
    private int year;
    private String make;
    private String licensePlate;

    /**
     * Constructs a new Car with the specified year, make, and license plate.
     *
     * @param year         The year of the car.
     * @param make         The make or manufacturer of the car.
     * @param licensePlate The license plate of the car.
     */
    public Car(int year, String make, String licensePlate) {
        this.year = year;
        this.make = make;
        this.licensePlate = licensePlate;
    }

    /**
     * Gets the license plate of the car.
     *
     * @return The license plate.
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Returns a string representation of the car, including its year and make.
     *
     * @return A string representation of the car.
     */
    @Override
    public String toString() {
        return year + " " + make;
    }
}
