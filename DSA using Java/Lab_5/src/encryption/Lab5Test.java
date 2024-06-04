
/* Name: Isha Gadani
 * Description: Lab 5
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package encryption;

import java.util.ArrayList;
import java.util.Scanner;
import encryption.Encryptable;
import encryption.CaesarCipher;
import encryption.VigenereCipher;

public class Lab5Test {
    private Scanner input;

    /**
     * Lab5Test object and initializes the Scanner object for user input.
     */
    public Lab5Test() {
        input = new Scanner(System.in);
    }

    /**
     * Displays a menu of options and prompts the user to select an option.
     * @param options:  Variable number of strings representing the menu options.
     * @return The user's selected menu item as an integer.
     */
    private int getMenuItem(String... options) {
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
    private String getString(String prompt) {
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
    private int getInt(String prompt, int min, int max) {
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

    /**
     * Prompts the user to select an encryption method and returns the corresponding Encryptable object.
     * @return An Encryptable object representing the selected encryption method (either CaesarCipher or VigenereCipher).
     */
    private Encryptable getMethod() {
        Encryptable encryptor = null;
        boolean validMethod = false;

        while (!validMethod) {
            int selection = getMenuItem("Caesar Cipher", "Vigenere Cipher");
            if (selection == 1) {
                int shift = getInt("Enter the shift value", 1, 255);
                encryptor = new CaesarCipher(shift);
                validMethod = true;
            } else if (selection == 2) {
                String password = getString("Enter the password");
                encryptor = new VigenereCipher(password);
                validMethod = true;
            }
        }

        return encryptor;
    }
    
    /**
     * The main method that runs the encryption test program.
     * @param args: Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Encryption Test!");

        ArrayList<String> encryptedText = new ArrayList<>();
        Lab5Test tester = new Lab5Test();

        boolean exitLoop = false;
        while (!exitLoop) {
            int selection = tester.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

            switch (selection) {
                case 1:
                    String textToEncrypt = tester.getString("Enter the text to encrypt");
                    Encryptable encryptor = tester.getMethod();
                    String encrypted = encryptor.encrypt(textToEncrypt);
                    encryptedText.add(encrypted);
                    System.out.println("Encrypted text: " + encrypted);
                    break;
                case 2:
                    if (encryptedText.isEmpty()) {
                        System.out.println("No encrypted text available.");
                        break;
                    }
                    int textIndex = tester.getInt("Select the index of the text to decrypt", 0, encryptedText.size() - 1);
                    String textToDecrypt = encryptedText.get(textIndex);
                    Encryptable decryptor = tester.getMethod();
                    String decrypted = decryptor.decrypt(textToDecrypt);
                    System.out.println("Decrypted text: " + decrypted);
                    break;
                case 3:
                    if (encryptedText.isEmpty()) {
                        System.out.println("No encrypted text available.");
                        break;
                    }
                    System.out.println("Encrypted List:");
                    for (int i = 0; i < encryptedText.size(); i++) {
                        System.out.println(i + " - " + encryptedText.get(i));
                    }
                    break;
                case 4:
                    exitLoop = true;
                    break;
            }
        }

        System.out.println("Goodbye!");
    }
}
