/* Name: Isha Gadani
 * Description: Lab 5
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package encryption;

public interface Encryptable {
	
	int START_CHAR = 32;  // ASCII code for the space character
    int END_CHAR = 122;   // ASCII code for the tilde (~) character
    int RANGE = END_CHAR - START_CHAR + 1;

    /**
     * 
     * @param input
     * @return
     */
    String encrypt(String input);
    
    /**
     * 
     * @param input
     * @return
     */
    String decrypt(String input);
}
