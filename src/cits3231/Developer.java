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
import javax.security.cert.X509Certificate;
import java.security.KeyStore;
import java.util.*; // Import java util library.
import javax.crypto.*;  // Import java crypto library.

/**
 * @version 23/10/13
 * @author Scott Pearson (20954512)
 */
public class Developer {

    String hostname;    // Declare a variable to hold the hostname.
    int portnum;    // Declare a variable to hold the portnum;
    String infile;  // Declare a variable to hold the dev clients file.

    /**
     * This is the constructor method and will be used to init.
     * @param infile The specified file from developer.
     */
    public Developer(String hostname, int portnum, String infile) {
        this.hostname = hostname;   // Copy variable.
        this.portnum = portnum; // Copy variable.
        this.infile = infile;   // Copy variable.
    }

    /**
     * This method will attempt to connect to the linkbroker.
     */
    void client_connect() {
    
    }
}
