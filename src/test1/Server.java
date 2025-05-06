/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

/**
 *
 * @author USER
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        // Create a server socket to listen on port 6669
        ServerSocket server = new ServerSocket(6668);
        
        // Wait for a client to connect
        Socket socket = server.accept();
        
        // Create scanners to read from the console and from the client
        Scanner fromConsole = new Scanner(System.in);
        Scanner fromClient = new Scanner(socket.getInputStream());
        PrintWriter fromServer = new PrintWriter(socket.getOutputStream(), true);
        
        String inputServer, inputConsole;
        
        // Loop to handle communication between server and client
        while (true) {
            // Check if there's data from the client
            if (fromClient.hasNextLine()) {
                inputServer = fromClient.nextLine();
                System.out.println("Client: " + inputServer);
                
                // If the client sends "*Exit*", break the loop
                if (inputServer.equals("*Exit*")) {
                    System.out.println("Client has exited.");
                    break;
                }
            } else {
                // If no data is available from the client, the client might have disconnected
                System.out.println("Client has disconnected.");
                break;
            }
            
            // Get input from the server's console
            System.out.print("You: ");
            inputConsole = fromConsole.nextLine();
            
            // Send the input from the server to the client
            fromServer.println(inputConsole);
            
            // If the server sends "*Exit*", break the loop
            if (inputConsole.equals("*Exit*")) {
                System.out.println("Server is exiting.");
                break;
            }
        }
        
        // Close the socket and clean up
        socket.close();
        System.out.println("Connection closed.");
    }
}
