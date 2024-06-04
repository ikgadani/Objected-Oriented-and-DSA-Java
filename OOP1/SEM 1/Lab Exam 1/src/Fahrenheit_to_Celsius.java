/*Author: Isha Gadani
 * Date: February 17, 2023
 * Description: Converting temperature 
 * in Fahrenheit to temperature in Celsius
*/
public class Fahrenheit_to_Celsius {
		
		//declaring the variable fahrenheit
		private double fahrenheit;
		
		//get method for fahrenheit
		public double getfahrenheit() {
			return fahrenheit;
		}
		
		//set method for fahrenheit
		public void setfahrenheit(double fahrenheit) {
			this.fahrenheit = fahrenheit;
		}
		
		//making celsius as the object and working on the formula
		public double celsius() {
			return ((fahrenheit-32)*0.5556);
		}
		
		//formatting celsius to 2 decimal places
		public String toString() {
			return String.format("%.1f", celsius());
		}
		
}
