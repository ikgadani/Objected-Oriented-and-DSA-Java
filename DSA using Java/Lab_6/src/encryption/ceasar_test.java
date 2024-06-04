package encryption;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class caesar_test {

	@Test
	void test() {
		CaesarCipher CC = new CaesarCipher(5);
		assertEquals(CC.encrypt("Once upon a time..."), "Tshj%zuts%f%ynrj333");
		
		
		
		//fail("Not yet implemented");
	}

}
