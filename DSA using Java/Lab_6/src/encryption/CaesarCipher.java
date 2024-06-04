/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

package encryption;

//import encryption.Encryptable;

public class CaesarCipher extends EncryptionType {
    private int key;

    /**
     * 
     * @param shift
     */
    public CaesarCipher(int shift) {
        key = shift;
    }

    /**
     * Encrypts the input string using the Caesar cipher algorithm.
     * @param input: The string to be encrypted.
     * @return The encrypted string.
     */
    @Override
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (int c=0; c<input.length();c++) {
        	char character = input.charAt(c);
        	int decimal = (int) character;
        		char encryptedChar = shiftChar(character, key);
        		encrypted.append(encryptedChar);
        	}
      
        	
        return encrypted.toString();	
        }
        
    
    
    /**
     * Decrypts the input string using the Caesar cipher algorithm.
     * @param input: The string to be decrypted.
     * @return  The decrypted string.
     */
    @Override
    public String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (int c=0; c<input.length();c++) {
        	char character = input.charAt(c);
        	int decimal = (int) character;
        	
        	char decryptedChar = shiftChar(character, -key);
        	decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }
}
