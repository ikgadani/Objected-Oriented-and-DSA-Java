/*
* Author: Isha Gadani
* Date: February 3, 2023
*/
public class Car {
		//Declaration of the variables
		private String VIN;
		private int vehicleYear;
		private float invoicePrice;
		private float mileage;
		
		
		// get and set methods for vin
		public String getVIN() {
			return VIN;
		}
		public void setVIN(String vIN) {
			VIN = vIN;
		}
		//get and set methods year
		public int getVehicleYear() {
			return vehicleYear;
		}
		public void setVehicleYear(int vehicleYear) {
			this.vehicleYear = vehicleYear;
		}
		//get and set methods invoice
		public float getInvoicePrice() {
			return invoicePrice;
		}
		public void setInvoicePrice(float invoicePrice) {
			this.invoicePrice = invoicePrice;
		}
		//get and set methods mileage
		public float getMileage() {
			return mileage;
		}
		public void setMileage(float mileage) {
			this.mileage = mileage;
		}
		//formatting 
		public String toString() {
			return String.format("%s , %d , $%.2f , %.1f",  VIN, vehicleYear, invoicePrice, mileage);
		}
		
}
