/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package encryption;

public abstract class EncryptionType {
	
	int START_CHAR = 32;  // ASCII code for the space character
    int END_CHAR = 122;   // ASCII code for the tilde (~) character
    int RANGE = END_CHAR - START_CHAR + 1;

    /**
     * 
     * @param input
     * @return
     */
    public abstract String encrypt(String input);
    
    /**
     * 
     * @param input
     * @return
     */
    public abstract String decrypt(String input);
    
    
    	
    public char shiftChar(char letter, int shift) {
    	
    	int value_shifted = letter + shift;
    	if (value_shifted < START_CHAR || value_shifted > END_CHAR) {
    		if(value_shifted > END_CHAR) {
    			value_shifted = value_shifted - RANGE;
    					
    		}
    		else if (value_shifted < START_CHAR){
    			value_shifted = value_shifted + RANGE;
    					
    		}
    		
    	}
    		return (char) value_shifted;
    	} 
//    	return letter;
//	}
    
    /**
     * Prompts the user to select an encryption method and returns the corresponding Encryptable object.
     * @return An Encryptable object representing the selected encryption method (either CaesarCipher or VigenereCipher).
     */
    public static EncryptionType getMethod() {
        EncryptionType encryptor = null;
        boolean validMethod = false;

        while (!validMethod) {
            int selection = ScannerUtils.getMenuItem("Caesar Cipher", "Vigenere Cipher");
            if (selection == 1) {
                int shift = ScannerUtils.getInt("Enter the shift value", 1, 255);
                encryptor = new CaesarCipher(shift);
                validMethod = true;
            } else if (selection == 2) {
                String password = ScannerUtils.getString("Enter the password");
                encryptor = new VigenereCipher(password);
                validMethod = true;
            }
        }

        return encryptor;
    }
}
