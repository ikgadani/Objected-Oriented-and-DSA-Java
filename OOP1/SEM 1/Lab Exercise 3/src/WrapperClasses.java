public class WrapperClasses {
    public static void main(String[] args) {
        System.out.println("Java Primitive Data Types Information:");
        
        // Character wrapper class
        int charMin = (int) Character.MIN_VALUE;
        int charMax = (int) Character.MAX_VALUE;
        System.out.printf("char, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n",
                Character.SIZE, Character.BYTES, charMin, charMax);
        
        // Wrapper class for Double
        System.out.printf("double, SIZE: %d, BYTES: %d, MIN_VALUE: %e, MAX_VALUE: %e%n",
                Double.SIZE, Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE);
        
        // Wrapper class for Byte
        System.out.printf("byte, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n",
                Byte.SIZE, Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE);
        
        // Wrapper class for Short
        System.out.printf("short, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n",
                Short.SIZE, Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE);
        
        // Wrapper class Integer
        System.out.printf("int, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n",
                Integer.SIZE, Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        // Wrapper class for Long
        System.out.printf("long, SIZE: %d, BYTES: %d, MIN_VALUE: %d, MAX_VALUE: %d%n",
                Long.SIZE, Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE);
        
        // Wrapper class for Float
        System.out.printf("float, SIZE: %d, BYTES: %d, MIN_VALUE: %e, MAX_VALUE: %e%n",
                Float.SIZE, Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE);
        
        System.out.println("Program by Isha Gadani");
    }
}
