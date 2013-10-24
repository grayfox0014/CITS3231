/*
 * This project will attempt to set up an encrypted connection that will be used
 * to merge software components from a distinct source with other libaries,
 * but will do so in a way that does not expose either sides code.
 * 
 * This project makes use of Jargs which is an open source project that can be
 * found here http://jargs.sourceforge.net/
 */
package cits3231;

import jargs.gnu.*; // Import java command line parser.
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
public class Main {
    
    /**
     * This method will display a help message to the user.
     */
    private static void printUsage() {
        System.err.println("Usage: Developer [-l,--library]" + 
                "[-h --hostname] [-p --portnumber]" +
                 "<infile>" +
                 "Please use option for each additional library.");
    }
    
    /**
     * @param args will be the input file from developer,
     * and the libraries from the software house.
     */
    public static void main(String[] args) {
        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option opt = parser.addStringOption('l', "Library");  // Create a command line option that will specify the library needed.
        CmdLineParser.Option op2 = parser.addStringOption('h', "Hostname");   // Create a command line option that will specify the hostname.
        CmdLineParser.Option opt3 = parser.addIntegerOption('p', "Port");    // Create a command line option that will specify the port number.
        
        try {
            parser.parse(args); // Check our command arguments.
        }
        catch (CmdLineParser.OptionException e ) {
            System.err.println(e.getMessage()); // Print error
            printUsage();   // Display help message.
            System.exit(1);
        }
            
        Vector libnames = parser.getOptionValues(opt);  // Gather all libraries specified into a vector. 
        
        String hostname = (String)parser.getOptionValue(op2);   // Get hostname.
        Integer portnum = (Integer)parser.getOptionValue(opt3, new Integer(0)); // Get portnum or set 0 if not specified.
        String[] file = parser.getRemainingArgs();  // Get in and out file.
        
        System.out.println("libs: " + libnames.toString() +
                "\nhostname: " + hostname +
                "\nPort: " + portnum +
                "\nfile: " + file[0]);
        
        Developer dev = new Developer(hostname, portnum, file[0]); // Create an instance of developer and pass the hostname, portnum and file.
    }
}
