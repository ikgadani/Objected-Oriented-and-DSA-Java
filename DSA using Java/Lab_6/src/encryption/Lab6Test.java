
/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package encryption;

import java.util.ArrayList;
import java.util.Scanner;
import encryption.ScannerUtils;
import encryption.EncryptionType;
import encryption.CaesarCipher;
import encryption.VigenereCipher;

public class Lab6Test {
    private Scanner input;

    /**
     * Lab5Test object and initializes the Scanner object for user input.
     */
    public Lab6Test() {
        input = new Scanner(System.in);
    }
    
    /**
     * The main method that runs the encryption test program.
     * @param args: Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Encryption Test!");

        ArrayList<String> encryptedText = new ArrayList<>();
        Lab6Test tester = new Lab6Test();

        boolean exitLoop = false;
        while (!exitLoop) {
            int selection = ScannerUtils.getMenuItem("Encrypt text", "Decrypt text", "Display encrypted list", "Exit");

            switch (selection) {
                case 1:
                    String textToEncrypt = ScannerUtils.getString("Enter the text to encrypt");
                    EncryptionType encryptor = EncryptionType.getMethod();
                    String encrypted = encryptor.encrypt(textToEncrypt);
                    encryptedText.add(encrypted);
                    System.out.println("Encrypted text: " + encrypted);
                    break;
                case 2:
                    if (encryptedText.isEmpty()) {
                        System.out.println("No encrypted text available.");
                        break;
                    }
                    int textIndex = ScannerUtils.getInt("Select the index of the text to decrypt", 0, encryptedText.size() - 1);
                    String textToDecrypt = encryptedText.get(textIndex);
                    EncryptionType decryptor = EncryptionType.getMethod();
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
