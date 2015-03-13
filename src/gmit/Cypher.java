/*
 * All of the encryption happens here. 
 */

package gmit;

import java.util.*;
import java.io.*;

public class Cypher {
	
	// member variables
	
	// hash maps
	private Map<Character, String> encryptMap = new HashMap<Character, String>(64);
	private Map<String, Character> decryptMap = new HashMap<String, Character>(64);
	
	// constructor
	Cypher()
	{
		// encryption hashmap values
		encryptMap.put('p', new String("AA"));
		encryptMap.put('h', new String("AD"));
		encryptMap.put('0', new String("AF"));
		encryptMap.put('q', new String("AG"));
		encryptMap.put('g', new String("AV"));
		encryptMap.put('6', new String("AX"));
		encryptMap.put(' ', new String("AE"));
		encryptMap.put('>', new String("AT"));
		
		encryptMap.put('4', new String("DA"));
		encryptMap.put('m', new String("DD"));
		encryptMap.put('e', new String("DF"));
		encryptMap.put('a', new String("DG"));
		encryptMap.put('1', new String("DV"));
		encryptMap.put('y', new String("DX"));
		encryptMap.put('"', new String("DE"));
		encryptMap.put('<', new String("DT"));
		
		encryptMap.put('l', new String("FA"));
		encryptMap.put('2', new String("FD"));
		encryptMap.put('n', new String("FF"));
		encryptMap.put('o', new String("FG"));
		encryptMap.put('f', new String("FV"));
		encryptMap.put('d', new String("FX"));
		encryptMap.put('\'', new String("FE"));
		encryptMap.put('}', new String("FT"));
		
		encryptMap.put('x', new String("GA"));
		encryptMap.put('k', new String("GD"));
		encryptMap.put('r', new String("GF"));
		encryptMap.put('3', new String("GG"));
		encryptMap.put('c', new String("GV"));
		encryptMap.put('v', new String("GX"));
		encryptMap.put('.', new String("GE"));
		encryptMap.put('{', new String("GT"));
		
		encryptMap.put('s', new String("VA"));
		encryptMap.put('5', new String("VD"));
		encryptMap.put('z', new String("VF"));
		encryptMap.put('w', new String("VG"));
		encryptMap.put('7', new String("VV"));
		encryptMap.put('b', new String("VX"));
		encryptMap.put(',', new String("VE"));
		encryptMap.put('&', new String("VT"));
		
		encryptMap.put('j', new String("XA"));
		encryptMap.put('9', new String("XD"));
		encryptMap.put('u', new String("XF"));
		encryptMap.put('t', new String("XG"));
		encryptMap.put('i', new String("XV"));
		encryptMap.put('8', new String("XX"));
		encryptMap.put(':', new String("XE"));
		encryptMap.put('=', new String("XT"));
		
		encryptMap.put('*', new String("EA"));
		encryptMap.put('-', new String("ED"));
		encryptMap.put('!', new String("EF"));
		encryptMap.put('?', new String("EG"));
		encryptMap.put('(', new String("EV"));
		encryptMap.put(')', new String("EX"));
		encryptMap.put(';', new String("EE"));
		encryptMap.put('%', new String("ET"));
		
		encryptMap.put('[', new String("TA"));
		encryptMap.put(']', new String("TD"));
		encryptMap.put('/', new String("TF"));
		encryptMap.put('\\', new String("TG"));
		encryptMap.put('+', new String("TV"));
		encryptMap.put('#', new String("TX"));
		encryptMap.put('@', new String("TE"));
		encryptMap.put('_', new String("TT"));
		
		// decryption hashmap
		decryptMap.put("AA", new Character('p'));
		decryptMap.put("AD", new Character('h'));
		decryptMap.put("AF", new Character('0'));
		decryptMap.put("AG", new Character('q'));
		decryptMap.put("AV", new Character('g'));
		decryptMap.put("AX", new Character('6'));
		decryptMap.put("AE", new Character(' '));
		decryptMap.put("AT", new Character('>'));
		
		decryptMap.put("DA", new Character('4'));
		decryptMap.put("DD", new Character('m'));
		decryptMap.put("DF", new Character('e'));
		decryptMap.put("DG", new Character('a'));
		decryptMap.put("DV", new Character('1'));
		decryptMap.put("DX", new Character('y'));
		decryptMap.put("DE", new Character('"'));
		decryptMap.put("DT", new Character('<'));
		
		decryptMap.put("FA", new Character('l'));
		decryptMap.put("FD", new Character('2'));
		decryptMap.put("FF", new Character('n'));
		decryptMap.put("FG", new Character('o'));
		decryptMap.put("FV", new Character('f'));
		decryptMap.put("FX", new Character('d'));
		decryptMap.put("FE", new Character('\''));
		decryptMap.put("FT", new Character('}'));
		
		decryptMap.put("GA", new Character('x'));
		decryptMap.put("GD", new Character('k'));
		decryptMap.put("GF", new Character('r'));
		decryptMap.put("GG", new Character('3'));
		decryptMap.put("GV", new Character('c'));
		decryptMap.put("GX", new Character('v'));
		decryptMap.put("GE", new Character('.'));
		decryptMap.put("GT", new Character('{'));
		
		decryptMap.put("VA", new Character('s'));
		decryptMap.put("VD", new Character('5'));
		decryptMap.put("VF", new Character('z'));
		decryptMap.put("VG", new Character('w'));
		decryptMap.put("VV", new Character('7'));
		decryptMap.put("VX", new Character('b'));
		decryptMap.put("VE", new Character(','));
		decryptMap.put("VT", new Character('&'));
		
		decryptMap.put("XA", new Character('j'));
		decryptMap.put("XD", new Character('9'));
		decryptMap.put("XF", new Character('u'));
		decryptMap.put("XG", new Character('t'));
		decryptMap.put("XV", new Character('i'));
		decryptMap.put("XX", new Character('8'));
		decryptMap.put("XE", new Character(':'));
		decryptMap.put("XT", new Character('='));
		
		decryptMap.put("EA", new Character('*'));
		decryptMap.put("ED", new Character('-'));
		decryptMap.put("EF", new Character('!'));
		decryptMap.put("EG", new Character('?'));
		decryptMap.put("EV", new Character('('));
		decryptMap.put("EX", new Character(')'));
		decryptMap.put("EE", new Character(';'));
		decryptMap.put("ET", new Character('%'));
		
		decryptMap.put("TA", new Character('['));
		decryptMap.put("TD", new Character(']'));
		decryptMap.put("TF", new Character('/'));
		decryptMap.put("TG", new Character('\\'));
		decryptMap.put("TV", new Character('+'));
		decryptMap.put("TX", new Character('#'));
		decryptMap.put("TE", new Character('@'));
		decryptMap.put("TT", new Character('_'));
				
	}
	
	public String getEncryption(char key)
	{
		return encryptMap.get(key);
	} // getEncryption()
	
	public Character getDecryption(String key)
	{
		return decryptMap.get(key);
	} // getDecryption()
	
	public void readFile() throws FileNotFoundException, IOException
	{
		StringBuilder encryptedString = new StringBuilder();
		char c = ' ';
		int i;
		
		// read text from file, line by line and encrypt it as it goes
		try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		       
		    	System.out.println("Unencrypted Text: " + line);
		    	
		    	// encrypt line of text
		    	for (i = 0; i < line.length(); i++){
		    		// get each character in string "line"
				    c = line.charAt(i);  
				    
				    c = Character.toLowerCase(c); // convert to lower case
				    
				    // encrypt each character and build a string
				    encryptedString.append(getEncryption(c));
				} // for
		    } // for
		} 
		catch(Exception e)
		{
			System.out.println("Could Not load text from file!");
		} // try catch
		
		// print out encrypted text
		System.out.println("Encrypted Text: " + encryptedString);
		
		StringBuilder decryptedString = new StringBuilder();
		StringBuilder tempString = new StringBuilder();
		char[] c1 = new char[encryptedString.length()];
		
		// loop through encrypted string and separate string
		// into char array
		for (i = 0; i < encryptedString.length(); i++){
			// split string into characters
		    c1[i] = encryptedString.charAt(i);  
		   
		    c1[i] = Character.toUpperCase(c1[i]); // make sure all upper case
		} // for
		
		// loop through char array and add characters in pairs to a string
		// decrypted string and add to decrypted string
		for(i = 0; i < c1.length; i += 2)
		{
			tempString.append(c1[i]); // get chars in pairs for string
			tempString.append(c1[i+1]);
			
			// decrypt string to get letter
			decryptedString.append(getDecryption(tempString.toString()));
	
			// empty string builder
			tempString.setLength(0);
		}
		// print out decrypted string
		System.out.println("Decrypted Text: " + decryptedString.toString());
		
	} // readFile()

	/*
	 *  To encrypt whole string (after reading in) use this sample code
	 *  
	 *  String s = "...stuff...";

		for (int i = 0; i < s.length(); i++){
		    char c = s.charAt(i);        
		    
		     *  encrypt character
		     * 
		     * use key word here
		     * to jumble order of encrypted text
		     * 
		     * use string builder here to
		     * rebuild encripted text as string
		     *  
		}
	 */
	
} // Class
