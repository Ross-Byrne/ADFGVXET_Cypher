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
		
		cypherMap.put('x', new String("GA"));
		cypherMap.put('k', new String("GD"));
		cypherMap.put('r', new String("GF"));
		cypherMap.put('3', new String("GG"));
		cypherMap.put('c', new String("GV"));
		cypherMap.put('v', new String("GX"));
		cypherMap.put('.', new String("GE"));
		cypherMap.put('{', new String("GT"));
		
		cypherMap.put('s', new String("VA"));
		cypherMap.put('5', new String("VD"));
		cypherMap.put('z', new String("VF"));
		cypherMap.put('w', new String("VG"));
		cypherMap.put('7', new String("VV"));
		cypherMap.put('b', new String("VX"));
		cypherMap.put(',', new String("VE"));
		cypherMap.put('&', new String("VT"));
		
		cypherMap.put('j', new String("XA"));
		cypherMap.put('9', new String("XD"));
		cypherMap.put('u', new String("XF"));
		cypherMap.put('t', new String("XG"));
		cypherMap.put('i', new String("XV"));
		cypherMap.put('8', new String("XX"));
		cypherMap.put(':', new String("XE"));
		cypherMap.put('=', new String("XT"));
		
		cypherMap.put('*', new String("EA"));
		cypherMap.put('-', new String("ED"));
		cypherMap.put('!', new String("EF"));
		cypherMap.put('?', new String("EG"));
		cypherMap.put('(', new String("EV"));
		cypherMap.put(')', new String("EX"));
		cypherMap.put(';', new String("EE"));
		cypherMap.put('%', new String("ET"));
		
		cypherMap.put('[', new String("TA"));
		cypherMap.put(']', new String("TD"));
		cypherMap.put('/', new String("TF"));
		cypherMap.put('\\', new String("TG"));
		cypherMap.put('+', new String("TV"));
		cypherMap.put('#', new String("TX"));
		cypherMap.put('@', new String("TE"));
		cypherMap.put('_', new String("TT"));
		
		
		System.out.println("The ADFGVXET Encryption");
		
		while(key != '/')
		{
			System.out.print("Enter A Letter to be encryped ('/' to exit): ");
			key = console.next().charAt(0);
			key = Character.toLowerCase(key);
			
			System.out.println(cypherMap.get(key));
		} // while
		
		System.out.println("\nProgram Ended\n");
		
		// close Scanner
		console.close();
	} // main
} // Class
