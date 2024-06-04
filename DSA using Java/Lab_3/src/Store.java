/* Name: Isha Gadani
 * Description: Lab 2
 * Program/Course/CET-CS CST8132_OOP
 * Professor: James Mwangi PhD.
 */

import java.util.Scanner;

//store class is created to get the data about the employees and the store details

public class Store {

    private Employee[] employees;

    public Store(int size) {
        employees = new Employee[size];
    }

    //reading the employee details of given number of employees using a for loop
    public void employeeDetails_read(Scanner scanner) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println("Enter details for employee " + (i + 1));
            Employee employee = new Employee(i, null, i, i);
            employee.read_employee(scanner);
            employees[i] = employee;
        }
    }
    
    //printing out the store name as Title 
    public static void printTitle(String storeName) {
        print_line();
        System.out.printf("%25s Store Management System\n",storeName);
        print_line();
    }
    
    //displaying employee details
    public void employeeDetails_print() {
        System.out.printf("%5s| %15s| %20s| %15s| %12s|%n", "Emp#", "Name", "Email", "Phone", "Salary");
        System.out.println("============================================================================");
        for (Employee employee : employees) {
            employee.print_employee();
        }
    }

    public static void print_line() {
    	 System.out.println("============================================================================");
    }
    
    
}
