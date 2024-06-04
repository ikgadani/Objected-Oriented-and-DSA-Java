/* Name: Isha Gadani
 * Description: Lab 2
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

//creating a class to get the name and other details about the employees

public class Person {
	private String first_name;
    private String last_name;
    private String email;
    private long phone_number;
   
    public Person(String first_name, String last_name, String email, long phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
    }
    
//getters 
    
    public String getName() {
        return first_name + " " + last_name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhoneNumber() {
        return phone_number;
    }
}
