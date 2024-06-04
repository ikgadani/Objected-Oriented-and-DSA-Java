/*
 * Assessment: Exercise 01
 * Student Name: Example_Of_File_Header_Comment
 * Due Date:
 * Description: A simple program to output a name and the date and time.
 * Professor Name:
 */
import java.util.Date;
import java.text.DateFormat;

/* A simple class that outputs a greeting to the console. Class_Header_Comment */
public class Greeting{

    /* Entry point for the application. Method-header_comment _for_method_main */
    public static void main(String[] args){
	Date todayDateTime = new Date();
	DateFormat dateFormat = DateFormat.getDateTimeInstance();
        System.out.println("Hello, my author's name is " + "Isha Gadani");
        System.out.println("Today is: " + dateFormat.format(todayDateTime));
    }
}
