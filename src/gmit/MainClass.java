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
		
		
		
		// Variables
		int menuChoice, endProgram;
		String fileName, keyWord;
		
		// Initialise
		menuChoice = endProgram = 0;
		fileName = keyWord = "";
		
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
				System.out.print("Please Enter KeyWord For Encryption: ");
				keyWord = console.next();
				
				System.out.println("Make sure your text file is in the same directory as 'src'.");
				
				System.out.print("Enter name of File (include .txt): ");
				fileName = console.next();
				
				// Checks if file exists
				File file1 = new File(fileName);
				if(!file1.exists()) {
					System.out.println("File: " + fileName + " Does not exists! Connot Encrypt!");
					break;
				} // if
				
				double start = System.currentTimeMillis();

				// encrypt text
				cypher.encryptFile(fileName, keyWord);

				double searchTime = ((System.currentTimeMillis() - start)/1000);
				
				System.out.println("That ran in: " + searchTime + " seconds");
				break;
			case 2: // decrypt file
				System.out.print("Please Enter KeyWord For Decryption: ");
				keyWord = console.next();
				
				System.out.println("Make sure your text file is in the same directory as 'src'.");
				
				System.out.print("Enter name of File (include .txt): ");
				fileName = console.next();
				
				// Checks if file exists
				File file2 = new File(fileName);
				if(!file2.exists()) {
					System.out.println("File: " + fileName + " Does not exists! Connot Decrypt!");
					break;
				} // if
				
				start = System.currentTimeMillis();

				// decrypt file
				cypher.decryptFile(fileName, keyWord);

				searchTime = ((System.currentTimeMillis() - start)/1000);
				
				System.out.println("That ran in: " + searchTime + " seconds");
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
