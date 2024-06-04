//ToDo: Supervisor wants programmer comments (use /* */ comment)
import java.util.Scanner;
//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class Assignment02 {

	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public static void main(String[] args) {
		LumberChecker lumberChecker = new LumberChecker();
		DimensionalLumber dimensionalLumber = new DimensionalLumber();
		User user = new User();
		final double EXPECTED_THICKNESS = 1.50;
		final double EXPECTED_WIDTH = 5.50;
		final double EXPECTED_LENGTH = 192.00;
		
		/*Scanner method for user input*/
		Scanner input = new Scanner(System.in);
		String more_data = "YES";
		
		/*while loop for */
		while(more_data.toUpperCase().startsWith("Y")) {

			System.out.println("Enter the dimensions for lumber");
			System.out.println("Values that are expected are Thickness: " + EXPECTED_THICKNESS + " Width: " + EXPECTED_WIDTH + " Length " + EXPECTED_LENGTH);

			
			double thickness = user.inputDouble("Enter the measured thickness in inches");
			dimensionalLumber.setThickness(thickness);
			
			
			double width = user.inputDouble("Enter the measured width in inches");
			dimensionalLumber.setWidth(width);

			
			double length = user.inputDouble("Enter the measured length in inches");
			dimensionalLumber.setLength(length);

			System.out.println(dimensionalLumber.toString());
			String report = lumberChecker.validate(dimensionalLumber);
            System.out.println(report);
            
			System.out.println("Program by Isha Gadani");
			
			
			System.out.println("Would you like to enter more data? YES or NO: ");
			
			if (more_data.toUpperCase().startsWith("Y")){
				more_data = input.next();
			}

			else if (more_data.toUpperCase().startsWith("N")){
				System.out.println("Program will now shut down");
			}	
		}
		
	input.close();
	}
}