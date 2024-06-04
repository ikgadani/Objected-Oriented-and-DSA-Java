/*
 * Student Name: Isha Gadani
 * Student Number: 041085940
 */

import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            // Connect to the server running on localhost at port 1254
            Socket client = new Socket("localhost", 1254);
            System.out.println("Connected to server");

            // Prepare to read user input
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Prepare to send messages to the server
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

            String message;
            do {
                // Prompt user for a message
                System.out.print("Enter a message (type 'finish' to exit): ");
                message = reader.readLine();

                // Send the message to the server
                writer.println(message);

                // Prepare to receive messages from the server
                BufferedReader serverReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                // Read the server's response (not used here)
                String serverMessage = serverReader.readLine();

            } while (!message.equalsIgnoreCase("finish"));

            // Close resources
            reader.close();
            writer.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
