/*
 * Name: Isha Gadani
 * 041085940
 */

import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            // Create a server socket on port 1254
            ServerSocket serverSocket = new ServerSocket(1254);
            System.out.println("Server is listening on port 1254");

            // Start an infinite loop to accept incoming client connections
            while (true) {
                // Accept a client connection
                Socket client = serverSocket.accept();
                System.out.println("Connection established with " + client.getInetAddress().getHostAddress());

                // Set up input and output streams for the client socket
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                String message;
                do {
                    // Read a message from the client
                    message = reader.readLine();
                    System.out.println("Received: " + message);

                    // Prepare to send the same message back to the client
                    String send_message = message;

                    // Send the message back to the client
                    writer.println(send_message);

                } while (!message.equalsIgnoreCase("finish")); // Continue until the client sends "finish"

                // Close the input and output streams, and the client socket
                reader.close();
                writer.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
