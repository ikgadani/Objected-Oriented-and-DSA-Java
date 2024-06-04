/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package encryption;

import java.util.Scanner;

public class ScannerUtils {
	
	private static Scanner input = new Scanner(System.in);
    /**
     * Displays a menu of options and prompts the user to select an option.
     * @param options:  Variable number of strings representing the menu options.
     * @return The user's selected menu item as an integer.
     */
    public static int getMenuItem(String... options) {
        int selection = -1;
        boolean validSelection = false;

        while (!validSelection) {
            System.out.println("Select an option:");
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + " - " + options[i]);
            }

            String inputLine = input.nextLine();
            try {
                selection = Integer.parseInt(inputLine);
                if (selection >= 1 && selection <= options.length) {
                    validSelection = true;
                } else {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return selection;
    }
    
    /**
     * Prompts the user to enter a string.
     * @param prompt: The prompt message for the user.
     * @return The user's entered string.
     */
    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        return input.nextLine();
    }
    
    /**
     * 
     * @param prompt: The prompt message for the user.
     * @parammin: The minimum allowed value for the integer.
     * @param max: The maximum allowed value for the integer.
     * @return The user's entered integer within the specified range.
     */
    public static int getInt(String prompt, int min, int max) {
        int number = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt + " (" + min + " - " + max + "): ");
            String inputLine = input.nextLine();
            try {
                number = Integer.parseInt(inputLine);
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number within the specified range.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return number;
    }
}
