//Main Class for Hardbread
public class Main {
	public static void main (String[] args) {
		Hardbread hb1 = new Hardbread();
		Hardbread hb2 = new Hardbread(18.7, 4.7, 6.4 , true);
		double TSA;
		String report;
		
		TSA = hb1.calculateTSA();
		report = hb1.toString();
		System.out.println("Hardbread 1:");
		System.out.printf("Total Surface Area: %.4f\n", TSA);
		System.out.println(report);
		
		TSA = hb2.calculateTSA();
		report = hb2.toString();
		System.out.println("Hardbread 2:");
		System.out.printf("Total Surface Area: %.2f\n", TSA);
		System.out.println(report);
		
		System.out.println("Program by Isha Gadani");
	}
}
