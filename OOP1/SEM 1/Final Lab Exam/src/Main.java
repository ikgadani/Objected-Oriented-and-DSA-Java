/* Name: Isha Gadani
 * Professor: Mel Sanschargin
 * Lab Exam Date: 14th April 2023
 * Lab: 312
 */

public class Main {
	
	public static void main(String[] args) {
		
		Snowfalls snowfall = new Snowfalls();
		
		//enter snowfall data
		snowfall.enter_data();
		
		String daily_snow_data = snowfall.daily_snowfall();
		String display_average = snowfall.result_average_snowfall();
		
		//display snowfall data
		System.out.println(daily_snow_data);
		
		//display the average of the snowfall measurements
		System.out.println(display_average);
		
		
		System.out.println("Program by Isha Gadani and Student Number: 41085940");
	}

}
