/*
 * Name: Isha Gadani
 * Professor: George Kriger & Paulo Sousa
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




/**
 * @author ISHA
 *  The main method is the entry point of the program. It reads the file "words.txt",
 *  processes through each word to find the common characters, and handles any file not found exceptions.
 *  
 *  @param args which is not used
 *  @throws FileNotFoundException if the words.txt is not found 
 */
public class main {

    public static void main(String[] args) {
        try {
        	//opening the text file
            File file = new File("words.txt"); 
            
            //scanner is used to create an object to read the file
            Scanner scanner = new Scanner(file);
            
            //set to store common characters and is initialized as null
            Set<Character> commChar = null;
            
            
            //looping through each line
            while (scanner.hasNextLine()) {
            	//reading the next line and converting them into lowercase
                String word = scanner.nextLine().toLowerCase();
                
                //here we are creating a set to store unique characters of the word
                Set<Character> charWord = new HashSet<>();

                
                //this loop adds each character of the word to the set
                for (char c : word.toCharArray()) {
                    charWord.add(c);
                }
                 
                 
                if (commChar == null) {
                	//if the commChar is null, it's the first word of the set so initialize the commChar to the characters of this word
                    commChar = new HashSet<>(charWord);
                    
                } else { 
                	//only keeping the characters that are common between charWord and commChar
                    commChar.retainAll(charWord);
                }
            }
            
            
            if (commChar != null && !commChar.isEmpty()) {
            	//if commChar is not empty, print the common characters
                System.out.println("Common characters in all words: " + commChar);
            } else {
            	//if it empty say that there aren't any common characters 
                System.out.println("No common characters found in all words.");
            }

            scanner.close();
        } 
        catch (FileNotFoundException e) {
        	//file not found exception if words.txt does not exist
            System.err.println("File not found.");
        }
    }
}
