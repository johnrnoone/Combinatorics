package Combinatorics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BadFileReader {
	
//	public static void main (String args[]) throws InterruptedException {
	public static void main (String args[]) {

		
	// Retry three times on failure to open file.
	int retryCount = -1;
	String line = null;
	do {
	    try {
	    	File inputFile = new File ("IMG_3687.JPG");
//	    	File inputFile = new File ("textfile.txt");
	    	if (inputFile.exists()) System.out.println ("inputFile.exists() returns true");
	    	if (!inputFile.exists()) System.out.println ("inputFile.exists() returns false");
	    	
	    	System.out.println ("main() calls br = new BR(input.txt)");
	    	FileInputStream fis = new FileInputStream("textfile.txt");  // jrn
//	    	FileInputStream fis = new FileInputStream("IMG_3687.JPG");  // jrn
	    	InputStreamReader isr = new InputStreamReader (fis);  //jrn
	        BufferedReader br = new BufferedReader(isr);
	    	
//	        BufferedReader br = new BufferedReader(
//		            new InputStreamReader(new FileInputStream("textfile.txt")));
//	            new InputStreamReader(new FileInputStream("input.txt")));
	        line = br.readLine();
	        System.out.println("br.readLine() returns, " + line);
	        br.close();
	    } catch (IOException e) {

	    	System.out.println ("Exception in new BR(input.txt)");
	    	System.out.println ("Exception e. = " + e.getMessage());
	    	e.printStackTrace();

	        Thread.currentThread();
			// Wait a little bit.
//	        Thread.currentThread().sleep(250);
	        try {
	        Thread.sleep(250);
	        } catch (Exception te) {
	        	te.printStackTrace();
	        }

	        if (retryCount == -1) {
	            // Start the count at three if this is the first occurrence.
	            retryCount = 3;
	        } else {
	            // Okay, looks like somebody has tried before.
	            retryCount--;
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	} while (retryCount > 0);
	}
}
