package primary;

public class Numbers {
    private Float[] values;
    private int size;
    private int count;

    // Default constructor
    public Numbers() {
        this.size = 5;
        this.values = new Float[size];
        this.count = 0;
    }

    // Initialize constructor using an int parameter to set the size of the array
    public Numbers(int size) {
        this.size = size;
        this.values = new Float[size];
        this.count = 0;
    }

    // Add a value to the array
    public void addValue(Float value) {
        if (count < size) {
            values[count++] = value;
        } else {
            System.out.println("Array is full. Cannot add more values.");
        }
    }

    // Calculate the average of the values in the array
    public float calcAverage() {
        if (count == 0) {
            System.out.println("No values in the array.");
            return 0.0f;
        }
        float sum = 0.0f;
        for (int i = 0; i < count; i++) {
            sum += values[i];
        }
        return Math.round((sum / count) * 100.0) / 100.0f; // Round to 2 decimal places
    }

    // Find the minimum and maximum values in the array, and calculate MaxValue modulo MinValue
    public String findMinMax() {
        if (count == 0) {
            return "No values in the array.";
        }

        float min = values[0];
        float max = values[0];

        for (int i = 1; i < count; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            if (values[i] > max) {
                max = values[i];
            }
        }

        if (min == 0) {
            return String.format("Minimum Value: %.2f\nMaximum Value: %.2f\nMaxValue modulo MinValue: Undefined (division by zero)", min, max);
        } else {
            float maxModMin = max % min;
            return String.format("Minimum Value: %.2f\nMaximum Value: %.2f\nMaxValue modulo MinValue: %.2f", min, max, maxModMin);
        }
    }
    
    public float findModulusOfMinMax() {
        if (count == 0) {
            System.out.println("No values in the array.");
            return Float.NaN; // Return NaN (Not-a-Number) for undefined result
        }

        float min = values[0];
        float max = values[0];

        for (int i = 1; i < count; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            if (values[i] > max) {
                max = values[i];
            }
        }

        if (min == 0) {
            System.out.println("Division by zero. Modulus result is undefined.");
            return Float.NaN;
        } else {
            float maxModMin = max % min;
            return maxModMin;
        }
    }


    // Find the factorial of MaxValue after dropping the decimal part
    public long getFactorialMax() {
        if (count == 0) {
            System.out.println("No values in the array.");
            return 0;
        }
        float max = values[0];
        for (int i = 1; i < count; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        int maxInt = (int) max; // Drop decimal part
        long factorial = 1;
        for (int i = 1; i <= maxInt; i++) {
            factorial *= i;
        }
        return factorial;
    }

    // Convert the array values to a string
    public String toString() {
        if (count == 0) {
            return "No values in the array.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(values[i]).append(" \n");
        }
        return sb.toString();
    }

    // Get the count of values in the array
    public int getCount() {
        return count;
    }

    // Get the value at a specific index in the array
    public float getValue(int index) {
        if (index >= 0 && index < count) {
            return values[index];
        }
        return -1; // Return -1 for invalid index
    }
}
