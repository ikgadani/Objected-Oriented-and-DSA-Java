/* Name: Isha Gadani
 * Description: Lab 2
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

import java.util.Scanner;

public class Lab3Test {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the store: ");
        String storeName = scanner.nextLine();

        System.out.print("How many employees do you have? ");
        int numEmployees = scanner.nextInt();

        Store store = new Store(numEmployees);
        store.employeeDetails_read(scanner);

        Store.printTitle(storeName);
        store.employeeDetails_print();

        scanner.close();
    }
}
