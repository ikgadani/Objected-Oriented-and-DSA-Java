package numtesting;

import primary.Numbers;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestNumbers {

    @Test
    public void testAddValue() {
        // Create a Numbers object with a maximum size of 3
        Numbers numbers = new Numbers(3);

        // Adding values to the Numbers object
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);

        // Check if the values were added correctly to the Numbers object
        assertEquals("1.0, 2.0, 3.0", numbers.toString());
    }

    @Test
    public void testCalcAverage() {
        // Create a Numbers object
        Numbers numbers = new Numbers();

        // Adding values to the Numbers object
        numbers.addValue(1.0f);
        numbers.addValue(2.0f);
        numbers.addValue(3.0f);

        // Calculate the average and check if it matches the expected value
        assertEquals(2.0f, numbers.calcAverage(), 0.01); // The average of 1.0, 2.0, and 3.0 is 2.0
    }

    
    @Test
    public void testFindMinMax() {
    	// Create a Numbers object
    	Numbers numbers = new Numbers();
    	
        // Adding values to the Numbers object
        numbers.addValue(2.0f);
        numbers.addValue(4.0f);
        numbers.addValue(6.0f);

        // Calculate the minimum, maximum, and max mod min values
        float[] result = numbers.findMinMax();

        // Check if the result matches the expected values
        assertEquals(2.0f, result[0]);
        assertEquals(6.0f, result[1]);
        assertEquals(0.0f, result[2]);
    }

    

    @Test
    public void testGetFactorialMax() {
        // Create a Numbers object
        Numbers numbers = new Numbers();

        // Adding values to the Numbers object
        numbers.addValue(5.5f);
        numbers.addValue(4.0f);
        numbers.addValue(7.0f);

        // Check if the getFactorialMax method returns the expected result
        assertEquals(5040, numbers.getFactorialMax()); // The factorial of 7 (the maximum value) is 5040
    }
    @Test
    public void testLoadAndSaveToFile() {
        String testFileName = "testFile.txt";
        Numbers originalNumbers = new Numbers();

        // Adding values to the original Numbers object
        originalNumbers.addValue(1.0f);
        originalNumbers.addValue(2.0f);
        originalNumbers.addValue(3.0f);

        try {
            // Save the original Numbers object to a file
            Numbers.saveToFile(originalNumbers, testFileName);

            // Load the Numbers object from the file
            Numbers loadedNumbers = Numbers.loadFromFile(testFileName);

            // Check if the loaded Numbers object matches the original
            assertEquals(originalNumbers.getNumItems(), loadedNumbers.getNumItems());
            assertEquals(originalNumbers.toString(), loadedNumbers.toString());
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        } finally {
            // Clean up: delete the test file
            File file = new File(testFileName);
            if (file.exists()) {
                file.delete();
            }
        }
        }
}
