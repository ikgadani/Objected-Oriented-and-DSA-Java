/*Author: Isha Gadani
 *Date: February 17, 2023
 *Description: To find the surface area for the bread 
 * 
 * */
public class Hardbread {
		private double bread_length;
		private double bread_width;
		private double bread_height;
		private boolean isOlivebread;
		
		private static final double length_default = 21.5;
		private static final double width_default = 5.3;
		private static final double height_default = 5.5;
		
		
		
		public Hardbread() {
			this.bread_length = length_default;
			this.bread_width = width_default;
			this.bread_height = height_default;
						
		}
		public Hardbread(double bread_length, double bread_width, double bread_height, boolean isOlivebread) {
			this.bread_length = bread_length;
			this.bread_width = bread_width;
			this.bread_height = bread_height;
			this.setisOlivebread(isOlivebread);
		}
	
		
		public double getbread_length() {
			return bread_length;
		}
		
		public void setbread_length(double bread_length) {
			this.bread_length = bread_length;
			
		}

		public double getbread_width() {
			return bread_width;
		}
		
		public void setbread_width(double bread_width) {
			this.bread_width = bread_width;
			
		}
		

		public double getbread_height() {
			return bread_height;
		}
		
		public void setbread_height(double bread_height) {
			this.bread_height = bread_height;
			
		}
		
		
		public double calculateTSA() {
			return 2*((bread_length*bread_width)+(bread_width*bread_height)+(bread_height*bread_length));
			
		}
		public boolean isOlivebread() {
			return isOlivebread;
		}
		
		public void setisOlivebread(boolean isOlivebread) {
			this.isOlivebread = isOlivebread;
		}
		
		public String toString() {
			return String.format("%.2f. %.2f, %.2f", bread_length, bread_width, bread_height);
		}
		
}
