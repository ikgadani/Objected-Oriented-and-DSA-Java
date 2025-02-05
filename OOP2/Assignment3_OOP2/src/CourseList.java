

//23F Assignment 3 Solution: CourseList.java 
 
// Insert your solution code into this file as instructed in the information document. Hints have been provided.
// Insert your javadoc style comments to clearly and thoroughly explain your work.
// Ensure that you use the appropriate methods for the operations specifically mentioned in the instructions.
// Note that there are code inbetween the print statements (see assignment information).


//This assignment explores the use of Lists, LinkedLists, ListIterators and several more concepts learned in this course.
//The program creates two LinkedLists of Strings. 
//In order to make the code more concise, this program uses the appropriate methods and the LinkedList constructor that takes a Collection argument. 
//The elements in one list are added to the other list through a method (ensure that you use the method taught in class for this). Then the resource is released.
//Thereafter, all the Strings are converted to uppercase. 
//Subsequently, several of the courses were found unsuitable and needed to be deleted from the list. Finally, duplicates were also removed. 

//Make sure that you have detailed JAVADOC in your code using the appropriate JAVADOC style used in this course.



import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet; 

public class CourseList {
																																																																																																																				

    /**
     * Prints the elements of a list.
     * @param list The list to be printed.
     */
    private static void printList(List<String> list) {
        for (String course : list) {
            System.out.print(course + ", ");
        }
        System.out.println("\n");
    }

    /**
     * Converts all elements in the list to uppercase.
     * @param list The list to be modified.
     */
    private static void convertToUpperCase(List<String> list) {
    	System.out.println("The List is:");
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String course = iterator.next();
            iterator.set(course.toUpperCase());
        }
    }

    /**
     * Deletes a sublist of elements from the list based on the specified start and end indices.
     * @param list The list to be modified.
     * @param start The starting index of the sublist.
     * @param end The ending index of the sublist.
     */
    private static void deleteSublist(List<String> list, int start, int end) {
    	System.out.println("The List is:");
        List<String> sublist = list.subList(start, end);
        sublist.clear();
    }

    /**
     * Prints the list in reverse order.
     * @param list The list to be printed in reverse order.
     */
    private static void printListInReverse(List<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        System.out.println("Reversed List:");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + ", ");
        }
        System.out.println("\n");
    }
    
    /**
     * Sorts the elements of the list in alphabetical order.
     * @param list The list to be sorted.
     */
    private static void sortList(List<String> list) {
    	System.out.println("The List is:");
        Collections.sort(list);
    }
    
    
    /**
     * Eliminates duplicate elements from the list.
     * @param list The list to be modified.
     */ 
    private static void eliminateDuplicates(List<String> list) {
        System.out.println("Non-duplicates are:");

        List<String> uniqueList = new LinkedList<>();
      
        for (String course : list) {
            
            if (!uniqueList.contains(course)) {
                uniqueList.add(course);
            }
        }
        
        list.clear();
        list.addAll(uniqueList);
    }

    
    /**
     * The main method that initializes two LinkedLists, performs various operations, and prints the results.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
    	
    	System.out.println("Welcome Everyone to My Assignment 3. My name is Vanshaj Chuttani\n");
    	
    	System.out.println("The List is:");        
        String[] courses = {"math", "english", "chemistry", "physics", "history", "geography"};
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList(courses));

        
        String[] courses2 = {"religion", "arts", "accounting", "math", "programming", "biology"};
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList(courses2));

        
        list1.addAll(list2);

        
        printList(list1);
        
        System.out.println("Displaying names of courses in uppercase letters...\n");
        
        convertToUpperCase(list1);
        printList(list1);

        System.out.println("Deleting courses 4 to 6...\n");
        
        deleteSublist(list1, 4, 6);
        printList(list1);

        System.out.println("Here is the current list of courses...\n");
        System.out.println("The List is:");
        printList(list1);
        
        printListInReverse(list1);
        
        System.out.println("Sorted courses in alphabetical order...\n");
        sortList(list1);
        printList(list1);

        System.out.println("Removing duplicate courses...\n");
        eliminateDuplicates(list1);
        printList(list1);
    }

}


