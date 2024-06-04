/* Name: Isha Gadani
 * Description: Lab 5
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

//package encryption;

//import encryption.Encryptable;

//public class VigenereCipher implements Encryptable {
//    private String key;
//    
//    /**
//     * Constructs a VigenereCipher object with the specified password/key.
//     * @param password: The password/key used for encryption and decryption.
//     */
//    public VigenereCipher(String password) {
//        key = password;
//    }
//    
//    /**
//     * Encrypts the input string using the Vigenere cipher algorithm.
//     * @param input: The string to be encrypted.
//     * @return The encrypted string.
//     */
//    @Override
//    public String encrypt(String input) {
//        StringBuilder encrypted = new StringBuilder();
//        int inputLength = input.length();
//        int keyLength = key.length();
//        for (int i = 0; i < inputLength; i++) {
//            char c = input.charAt(i);
//            char keyChar = key.charAt(i % keyLength);
//            if (Character.isLetter(c)) {
//                char base = Character.isUpperCase(c) ? 'A' : 'a';
//                char encryptedChar = (char) ((c - base + keyChar - base) % 26 + base);
//                encrypted.append(encryptedChar);
//            } else {
//                encrypted.append(c);
//            }
//        }
//        return encrypted.toString();
//    }
//    /**
//     * Decrypts the input string using the Vigenere cipher algorithm.
//     * @param input: The string to be decrypted
//     * @return the decrypted string
//     */
//    @Override
//    public String decrypt(String input) {
//        StringBuilder decrypted = new StringBuilder();
//        int inputLength = input.length();
//        int keyLength = key.length();
//        for (int i = 0; i < inputLength; i++) {
//            char c = input.charAt(i);
//            char keyChar = key.charAt(i % keyLength);
//            if (Character.isLetter(c)) {
//                char base = Character.isUpperCase(c) ? 'A' : 'a';
//                char decryptedChar = (char) ((c - base - keyChar + 26) % 26 + base);
//                decrypted.append(decryptedChar);
//            } else {
//                decrypted.append(c);
//            }
//        }
//        return decrypted.toString();
//    }
//}
package encryption;

public class VigenereCipher implements Encryptable{
	
	String key;
	
	public VigenereCipher(String password) {
		this.key = password;
	}
	
	public String encrypt(String input) {
		char message[] = input.toCharArray();
		char[] str_length = new char[message.length];
		char en_crypt[] = key.toCharArray();
		int[] val_message = new int[message.length];
		for(int i =0;i <message.length;i++) {
			str_length[i]= en_crypt[i%en_crypt.length];
		}
		
		for (int i=0; i<message.length;i++) { 
			val_message[i]= message[i]+str_length[i]-START_CHAR;
			while (END_CHAR <val_message[i] || val_message[i]<START_CHAR) {
				if (val_message[i]<START_CHAR) {
					val_message[i] = val_message[i]+RANGE; 
				}
				else if (val_message[i]>END_CHAR) {
					val_message[i]=val_message[i]-RANGE;
				}
					
			}
			str_length[i] = (char) val_message[i];
		
		}
		return new String(str_length);
		 
}
	public String decrypt(String input) {
		char message[] = input.toCharArray();
		char[] str_length = new char[message.length];
		char en_crypt[] = key.toCharArray();
		int[] val_message = new int[message.length];
		for(int i =0;i <message.length;i++) {
			str_length[i]= en_crypt[i%en_crypt.length];
		}
		
		for (int i=0; i<message.length;i++) { 
			val_message[i]= message[i]-str_length[i]+START_CHAR;
			while (END_CHAR <val_message[i] || val_message[i]<START_CHAR) {
				if (val_message[i]<START_CHAR) {
					val_message[i] = val_message[i]+RANGE; 
				}
				else if (val_message[i]>END_CHAR) {
					val_message[i]=val_message[i]-RANGE;
				}
					
			}
			str_length[i] = (char) val_message[i];
		
		}
		return new String(str_length);
	}
}

