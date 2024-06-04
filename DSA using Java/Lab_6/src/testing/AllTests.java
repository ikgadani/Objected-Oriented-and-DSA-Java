/* Name: Isha Gadani
 * Description: Lab 6
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */
package testing;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ caesar_testing.class, vigenere_testing.class })
public class AllTests {

}
