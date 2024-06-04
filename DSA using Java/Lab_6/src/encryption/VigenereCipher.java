/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

package encryption;

public class VigenereCipher extends EncryptionType{
	
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
			message[i] = shiftChar(message[i], str_length[i]-START_CHAR);
		}
		return new String(message);
		 
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
			message[i] = shiftChar(message[i], START_CHAR-str_length[i]);
		}
		return new String(message);
	}
}

