/* Name: Isha Gadani
 * Description: Lab 5
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

package encryption;

import encryption.Encryptable;

public class CaesarCipher implements Encryptable {
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
        	int encryptedDecimal = decimal+key;
        	while (encryptedDecimal>END_CHAR || encryptedDecimal<START_CHAR) {
        		if (encryptedDecimal<START_CHAR) {
        			encryptedDecimal = encryptedDecimal+RANGE; 
				}
				else if (encryptedDecimal>END_CHAR) {
					encryptedDecimal=encryptedDecimal-RANGE;
				}
        	}
        	char encryptedChar = (char) encryptedDecimal;
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
        	int decryptedDecimal = decimal-key;
        	while (decryptedDecimal>END_CHAR || decryptedDecimal<START_CHAR) {
        		if (decryptedDecimal<START_CHAR) {
        			decryptedDecimal = decryptedDecimal+RANGE; 
				}
				else if (decryptedDecimal>END_CHAR) {
					decryptedDecimal=decryptedDecimal-RANGE;
				}
        	}
        	char decryptedChar = (char) decryptedDecimal;
        	decrypted.append(decryptedChar);
        }
        return decrypted.toString();
    }
}
