/*
 * Program Header Comments, including your Student Name are needed
 */

/*
 * Comment needed
 */
public class Customer {
	private int age;
	
	/*
	 * Comment needed
	 */
	public Customer() {
		this(0);
	}
	
	/*
	 * Comment needed
	 */
	public Customer(int age) {
		this.age = age;
	}

	/*
	 * Comment needed
	 */
	public int getAge() {
		return age;
	}

	/*
	 * Comment needed
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/*
	 * Comment needed, document here what a return value of -1 indicates
	 * so that other programmers will know.
	 */
	public double calculateTicketPrice() {
		double price = -1.0; // set to -1 in case the age is invalid.
		
		// if the age is less than zero, or greater than or equal 
		// to 110 return -1.0
		// use if statements with ranges to determine the price.
		// return the determined price
		
		return price; 
	}
	
}
