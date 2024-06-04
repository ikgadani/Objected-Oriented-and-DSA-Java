//ToDo: Supervisor wants programmer comments (use /* */ comment)

//ToDo: Supervisor wants programmer comments (use /* */ comment)
public class LumberChecker {
	// ToDo: Create a public static final EPSILON with value 0.03125 
	//       i.e.1/32 one-thirty-second inch
	
	//ToDo: Supervisor wants programmer comments (use /* */ comment)
	public String validate(DimensionalLumber lumber) {
		double thickness = 1.5;
		double width = 5.5;
		double length = 192;
		final double EPSILON = 0.03125;
		
		/* Checking for the negative value */
		if (lumber.getThickness() < 0 || lumber.getWidth() < 0 || lumber.getLength() < 0){
			return "Not verified. Negative Dimensions entered.";
		}

		/* Thickness dimensions */
		if (Math.abs(thickness - lumber.getThickness()) >= EPSILON){
			return "Incorrect thickness, does not match with the specification.";
		}

		/* Width dimensions */
		else if (Math.abs(width - lumber.getWidth()) >= EPSILON){
			return "Incorrect width, does not match with the specification.";
		}

		/* Length dimensions */
		else if (Math.abs(length - lumber.getLength()) >= EPSILON){
			return "Incorrect length, does not match with the specification.";
		}

	
		/* When it meets the requirements */
		else {
			return "Requirements met for the Lumber.";
		}
		
		

	}
}
