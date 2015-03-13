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
		int menuChoice, endProgram = 0;;
		
		System.out.println("The ADFGVXET Encryption");
		
		while(endProgram != 99)
		{
			// to make sure int in correct range is entered
			do
			{
				System.out.println("\nWould You Like To Encrypt or Decrypt a Text File?\n");
				System.out.println("1.) Encrpt Text File.");
				System.out.println("2.) Decrypt Text File.");
				System.out.println("3.) Exit.\n");
				
				System.out.print("Enter Option: ");
				
				while(!console.hasNextInt()) // in case an int isn't entered
				{
					System.out.println("\nWould You Like To Encrypt or Decrypt a Text File?\n");
					System.out.println("1.) Encrpt Text File.");
					System.out.println("2.) Decrypt Text File.");
					System.out.println("3.) Exit.\n");
					
					System.out.print("Enter Option: ");
					console.next(); // to advance Scanner past input
				} // while
				
				menuChoice = console.nextInt();
			}while(menuChoice < 1 || menuChoice > 3);
			
			switch(menuChoice)
			{
			case 1: // encrypt file
				// read text file
				cypher.readFile();
				break;
			case 2: // decrypt file
				break;
			case 3: // exit
				endProgram = 99;
				break;
			} // switch
		} // while
		System.out.println("\n . . . Program Ended . . .\n");
		
		// close Scanner
		console.close();
	} // main
} // Class
