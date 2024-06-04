/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package testing;

import encryption.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class vigenere_testing {
	
	@Test
	void encryptTest1() {
		VigenereCipher CC = new VigenereCipher("test");
		assertEquals(CC.encrypt("in a land far far away"),"bXsZtVYg]e^Zke^ZkeYpZc");
	}
	
	@Test
	void encryptTest2() {
		VigenereCipher CC = new VigenereCipher("pass");
		assertEquals(CC.encrypt("this is a test"),"iNakpOksVal]hZ");
	}
	
	@Test
	void encryptTest3() {
		VigenereCipher CC = new VigenereCipher("pix");
		assertEquals(CC.encrypt("???"),"4-<");
	}
	
	@Test
	void encryptTest4() {
		VigenereCipher CC = new VigenereCipher("p");
		assertEquals(CC.encrypt(" "),"p");
	}
	
	@Test
	void decryptTest1() {
		VigenereCipher CC = new VigenereCipher("test");
		assertEquals(CC.decrypt("bXsZtVYg]e^Zke^ZkeYpZc"),"in a land far far away");
	}
	
	@Test
	void decryptTest2() {
		VigenereCipher CC = new VigenereCipher("pass");
		assertEquals(CC.decrypt("iNakpOksVal]hZ"),"this is a test");
	}
	
	@Test
	void decryptTest3() {
		VigenereCipher CC = new VigenereCipher("pix");
		assertEquals(CC.decrypt("4-<"),"???");
	}
	
	@Test
	void decryptTest4() {
		VigenereCipher CC = new VigenereCipher("p");
		assertEquals(CC.decrypt("p")," ");
	}
}
