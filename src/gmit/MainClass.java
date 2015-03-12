/*
 * Author: Ross Byrne 2015
 * My version of German ADFGVX Cypher
 * I added two extra letters, E and T
 * to cover extra special characters
 * */

package gmit;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		// hash map
		HashMap<Character, String> cypherMap = new HashMap<Character, String>();
		
		char key = ' ';
		
		// add to hashmap
		cypherMap.put('p', new String("AA"));
		cypherMap.put('h', new String("AD"));
		cypherMap.put('0', new String("AF"));
		cypherMap.put('q', new String("AG"));
		cypherMap.put('g', new String("AV"));
		cypherMap.put('6', new String("AX"));
		cypherMap.put(' ', new String("AE"));
		cypherMap.put('>', new String("AT"));
		
		cypherMap.put('4', new String("DA"));
		cypherMap.put('m', new String("DD"));
		cypherMap.put('e', new String("DF"));
		cypherMap.put('a', new String("DG"));
		cypherMap.put('1', new String("DV"));
		cypherMap.put('y', new String("DX"));
		cypherMap.put('"', new String("DE"));
		cypherMap.put('<', new String("DT"));
		
		cypherMap.put('l', new String("FA"));
		cypherMap.put('2', new String("FD"));
		cypherMap.put('n', new String("FF"));
		cypherMap.put('o', new String("FG"));
		cypherMap.put('f', new String("FV"));
		cypherMap.put('d', new String("FX"));
		cypherMap.put('\'', new String("FE"));
		cypherMap.put('}', new String("FT"));
		
		
		System.out.println("The ADFGVXET Encryption");
		
		while(key != '/')
		{
			System.out.print("Enter A Letter to be encryped ('/' to exit): ");
			key = console.next().charAt(0);
			key = Character.toLowerCase(key);
			
			System.out.println(cypherMap.get(key));
		} // while
		
		System.out.println("\nProgram Ended\n");
	} // main
} // Class
