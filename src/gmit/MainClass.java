/*
 * Author: Ross Byrne 2015
 * My version of German ADFGVX Cypher
 * I added two extra letters, E and T
 * to cover extra special characters
 * */

package gmit;

import java.io.*;
import java.util.*;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		// objects
		Scanner console = new Scanner(System.in);
		
		Cypher cypher = new Cypher();
		
		// Checks if file exists, creates it if it doesn't
		File file = new File("text.txt");
		if(!file.exists()) {
			file.createNewFile();
		} // if
		
		// variables
		char key = ' ';
		String key1 = " ";
		
		System.out.println("The ADFGVXET Encryption");
		
		try {
			cypher.readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		while(key != '/')
		{
			System.out.print("Enter A Letter to be encryped ('/' to exit): ");
			key = console.next().charAt(0);
			key = Character.toLowerCase(key);
			
			System.out.println(cypher.getEncryption(key));
		} // while
		
		do
		{
			System.out.print("Enter two letters to be decryped ('/' to exit): ");
			key1 = console.next();
			
			key1 = key1.toUpperCase();
	
			System.out.println(cypher.getDecryption(key1));
		}while(!key1.equals("/")); // while
		
		System.out.println("\nProgram Ended\n");
		
		// close Scanner
		console.close();
	} // main
} // Class
