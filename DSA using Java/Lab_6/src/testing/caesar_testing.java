/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package testing;

import encryption.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class caesar_testing {

	@Test
	void encryptTest1() {
		CaesarCipher CC = new CaesarCipher(5);
		assertEquals(CC.encrypt("Once upon a time..."),"Tshj%zuts%f%ynrj333");
		
	}
	
	@Test
	void encryptTest2() {
		CaesarCipher CC = new CaesarCipher(6);
		assertEquals(CC.encrypt("..."),"444");
		
	}
	
	@Test
	void encryptTest3() {
		CaesarCipher CC = new CaesarCipher(3);
		assertEquals(CC.encrypt("She buys seashells but the sea shore."),"Vkh#ex!v#vhdvkhoov#exw#wkh#vhd#vkruh1");
	}
	
	@Test
	void encryptTest4() {
		CaesarCipher CC = new CaesarCipher(4);
		assertEquals(CC.encrypt(" "),"$");
	}
	
	@Test
	void decryptTest1() {
		CaesarCipher CC = new CaesarCipher(5);
		assertEquals(CC.decrypt("Tshj%zuts%f%ynrj333"),"Once upon a time...");
	}
	
	@Test
	void decryptTest2() {
		CaesarCipher CC = new CaesarCipher(6);
		assertEquals(CC.decrypt("444"),"...");
		
	}
	
	@Test
	void decryptTest3() {
		CaesarCipher CC = new CaesarCipher(3);
		assertEquals(CC.decrypt("Vkh#ex!v#vhdvkhoov#exw#wkh#vhd#vkruh1"),"She buys seashells but the sea shore.");
	}
	
	@Test
	void decryptTest4() {
		CaesarCipher CC = new CaesarCipher(4);
		assertEquals(CC.decrypt("$")," ");
	
	}
}
