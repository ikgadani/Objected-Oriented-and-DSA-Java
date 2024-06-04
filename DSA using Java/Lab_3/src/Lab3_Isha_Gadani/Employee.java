/* Name: Isha Gadani
 * Description: Lab 2
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

import java.util.Scanner;

public class Employee {
	private int employee_number;
    private Person employee;
    private double number_of_hours;
    private double hourly_pay;

    public Employee(int employee_number, Person employee, double number_of_hours, double hourly_pay) {
        this.employee_number = employee_number;
        this.employee = employee;
        this.number_of_hours = number_of_hours;
        this.hourly_pay = hourly_pay;
    }
    
    //asking for details of the employees 
    public void read_employee(Scanner scanner) {
        System.out.print("Enter employee number: ");
        employee_number = scanner.nextInt();
        
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        
        System.out.print("Enter email: ");
        String email = scanner.next();
        
        System.out.print("Enter phone number: ");
        long phoneNumber = scanner.nextLong();
        
        employee = new Person(firstName, lastName, email, phoneNumber);
        
        System.out.print("Enter number of hours worked: ");
        number_of_hours = scanner.nextDouble();
        
        System.out.print("Enter hourly pay: ");
        hourly_pay = scanner.nextDouble();
    }

    //calculating the salary of the employees and printing the details
    public void print_employee() {
        double salary = number_of_hours * hourly_pay;
        System.out.printf("%5d| %15s| %20s| %15s| %12.2f|%n", employee_number, employee.getName(),
                employee.getEmail(), employee.getPhoneNumber(), salary);
    }
}
