/* Name: Isha Gadani
 * Professor: Mel Sanschargin
 * Lab Exam Date: 14th April 2023
 * Lab: 312
 */


//scanner for user input
import java.util.Scanner;

// class for snowfall

public class Snowfalls {
	
		private double[] data_for_snowfall;
	
	// method to enter data for the snowfall
	public void enter_data() {
	
		Scanner scanner1 = new Scanner(System.in);
		//an array is created for the values for the snowfall measurements
		data_for_snowfall = new double[7];
		int x;
		//for loop to take in the data for snowfall measurements
		for (x = 0; x < 7; x++) {
			
			int snow_day = x+1;
			System.out.println("What is the snowfall measurement today?");
			System.out.println("Day: " + snow_day);
			
			//asks the program to take in the next entry
			data_for_snowfall[x] = scanner1.nextDouble();
		}		
	}
	// method to calculate average
	public double average_calc() {
		double total = 0;
		int x;
		
		// for loop to take in data and add it to the total
		for (x=0; x<7; x++) {
			total = data_for_snowfall[x]+1;
		}
		//returns the average of the snowfall
		return total/7.00;
	}
	
	// method to display the record of all the measurements taken during all 7 days
	public String daily_snowfall() {
		
		// StringBuilder method to build a sting to append all snowfall values
		StringBuilder snow_string = new StringBuilder();
		snow_string.append("DAILY SNOWFALL: ");
		int x;
		
		// for loop to append the values entered
		for (x = 0; x<7; x++) {
			snow_string.append(String.format("%.2f", data_for_snowfall[x]));
			if (x<=5) {
				snow_string.append(" , "); 
			}
		}
		return snow_string.toString();
	}
	
	//method created to display the average of the snowfall measurements
	public String result_average_snowfall() {
		double avg = average_calc();
		return String.format("AVERAGE %.2f", avg);
	}
	
}


