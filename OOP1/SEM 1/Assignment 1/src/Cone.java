
/*Author: Isha Gadani
 *Date: February 9, 2023
 *Description: Cone class where variables 
 *are defined and declared, volumeObject 
 *is created and set and get methods are used.  
 */

public class Cone {
	
	    //declaring the variables 	
		private double heightCone;
		private double radiusCone;
		
		//get method for heightCone
		public double getheightCone() {
			return heightCone;
		}
		//set method for heightCone
		public void setheightCone(double heightCone) {
			this.heightCone = heightCone;
		}
		
		//get method for radiusCone
		public double getradiusCone() {
			return radiusCone;		
		}
		
		//set method for radiusCone
		public void setradiusCone(double radiusCone) {
			this.radiusCone = radiusCone;
		}
		
		// making volumeCone object
		/* [1] 	"Volume of a Cone," Varsity Tutors, [Online]. 
		 * Available: https://www.varsitytutors.com/hotmath/hotmath_help/topics/volume-of-a-cone. 
		 * [Accessed 5 February 2023].*/
		public double volumeCone() {
			return ((1.0/3)*(Math.pow(radiusCone, 2)*heightCone*Math.PI));
		}
		
		// formatting the volumeCone object to 2 decimal places
		public String toString() {
			return String.format("%.2f", volumeCone());
		}

		
		
		
}
		
