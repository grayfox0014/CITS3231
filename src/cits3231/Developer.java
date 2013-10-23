/*
 * This project will attempt to set up an encrypted connection that will be used
 * to merge software components from a distinct source with other libaries,
 * but will do so in a way that does not expose either sides code.
 */
package cits3231;

import java.io.*;   // Import java standard I/O library.
import java.net.*;   // Import java networking library.
import javax.net.ssl.*;  // Import java ssl library.
import java.security.*; // Import java security library.
import java.util.*; // Import java util library.
import javax.crypto.*;  // Import java crypto library.

/**
 * @version 23/10/13
 * @author Scott Pearson (20954512)
 */
public class Developer {

    String infile;  // Declare a variable to hold the dev clients file.

    /**
     * This is the constructor method and will be used to init.
     * @param infile The specified file from developer.
     */
    public Developer(String infile) {
        this.infile = infile;   // Copy variable.
    }

    /**
     * This method will attempt to connect to the linkbroker.
     */
    void client_connect() {
        try {
            Socket sock = new Socket("localhost", 3231);    // Init a new socket set to local host on port 3231.
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));   // Set up buffered reader so we can read what we are given through network.
            System.out.print("Received string: '"); 

            while (!in.ready()) { } // Wait.
            System.out.println(in.readLine()); // Read one line and output it
            System.out.print("'\n");
            in.close(); // Close
        } catch (Exception e) {
            System.out.println("Connection failed\n");
        }
    }
}
}
