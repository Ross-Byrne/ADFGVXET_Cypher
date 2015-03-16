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
	
	public void encryptFile(String fileName, String keyWord)
	{
		StringBuilder encryptedString = new StringBuilder();
		char c = ' ';
		int i, j, count;
		
		// 2dim array list to hold text from file
		List<List<Character>> text = new ArrayList<List<Character>>();
	
		// read text from file, line by line and encrypt it as it goes
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		  
		    	// encrypt line of text
		    	for (i = 0; i < line.length(); i++){
		    		// get each character in string "line"
				    c = line.charAt(i);  
				    
				    c = Character.toLowerCase(c); // convert to lower case
				   
				    // encrypt each character and build a string
				    if(getEncryption(c) == null)
				    {
				    	// dont add it 
				    }
				    else
				    {
				    	encryptedString.append(getEncryption(c));
				    } // if
				} // for
		    } // for
		} 
		catch(Exception e)
		{
			System.out.println("Could Not load text from file!");
		} // try catch
		
		int numOfRows = 0;
		
		if(encryptedString.length() % keyWord.length() != 0){
			numOfRows = (encryptedString.length() / keyWord.length()) +1;
		}
		else{
			numOfRows = encryptedString.length() / keyWord.length();
		} // if
		
		// creates num of rows needed
		for(i = 0; i < numOfRows; i++){
			text.add(new ArrayList<Character>());
		} // for
		
		count = 0;
		i = 0;
		for(count = 0; count < encryptedString.length();) {
			for(j = 0; j < keyWord.length(); j++)
			{
				if(count == encryptedString.length()){
					break;
				}
				text.get(i).add(encryptedString.charAt(count));
				//System.out.print(text.get(i).get(j));
				
	    		count++; // count number of characters processed
	    	} // for
			//System.out.println();
			i++;
		} // for
		
		try
		{
			// print encrypted text to file
			PrintWriter writer = new PrintWriter((new BufferedWriter(new FileWriter("Encrypted.txt"))));
			
			count = 0;
			i = 0;
			for(count = 0; count < encryptedString.length();) {
				for(j = 0; j < numOfRows; j++)
				{
					if(count == encryptedString.length()){
						break;
					} // if
					
					if(i == text.get(j).size()){
						// do nothing
					}
					else{
						writer.write(text.get(j).get(i));
						//System.out.print(text.get(j).get(i));
						count++; // count number of characters processed
					} // if
		    	} // for
				//System.out.println();
				i++;
			} // for
			
			writer.close();
		} 
		catch (Exception e1)
		{
			System.out.println("Error..");
		}
	
		/*try{
			// print encrypted text to file
			PrintWriter writer = new PrintWriter("Encrypted.txt");
			
			// write text to file
			writer.print(encryptedString);
			
			writer.close();
		} 
		catch (Exception e)
		{
			System.out.println("Error, Could Not Write Encrypted Text To File");
		} // try catch*/
	} // encryptFile()
	
	public void decryptFile(String fileName, String keyWord)
	{
		StringBuilder encryptedString = new StringBuilder();
		StringBuilder decryptedString = new StringBuilder();
		StringBuilder tempString = new StringBuilder();
		char c1 = ' ';
		char c2 = ' ';
		int i, count, j;
		
		// 2dim array list to hold text from file
		List<List<Character>> text = new ArrayList<List<Character>>();
			
		// read text from file, line by line and decrypt it as it goes
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	encryptedString.append(line);
		    	
		    	// loop through characters in string and add characters in pairs 
		    	// to a  temp string. decrypt temp string and add decrypted character
		    	// to main decrypted string
		    /*	for (i = 0; i < line.length(); i++){
		    		
				    c1 = line.charAt(i);  
				  //  c2 = line.charAt(i+1);
				    
				    c1 = Character.toUpperCase(c1); // convert to upper case
				 //   c2 = Character.toUpperCase(c2);
				    
				//.append(c1); // get chars in pairs for string
				//	tempString.append(c2);
					
				  /*  // Decrypt each pair of characters and build a string
				    decryptedString.append(getDecryption(tempString.toString()));
				    
					// empty string builder temp
					tempString.setLength(0);*/
		    		
		    		//encryptedString.append(line);
		    		
		    		//tempString.setLength(0);
		    	//} // for*/
		    } // for
		} 
		catch(Exception e)
		{
			System.out.println("Could Not load text from file!");
		} // try catch
		
		int numOfRows = 0;
		int remainder = 0;
		
		remainder = encryptedString.length() % keyWord.length();
		
		if(encryptedString.length() % keyWord.length() != 0){
			numOfRows = (encryptedString.length() / keyWord.length()) +1;
		}
		else{
			numOfRows = encryptedString.length() / keyWord.length();
		} // if
		
		// create num of rows needed
		for(i = 0; i < numOfRows; i++){
			text.add(new ArrayList<Character>());
		} // for
		
		count = 0;
		i = 0;
		// reverse keyword diffusion
		for(count = 0; count < encryptedString.length();) {
			for(j = 0; j < numOfRows; j++)
			{
				if(count == encryptedString.length()){
					break;
				} // if
				
				// if remainder is not 0, this means an extra row was added that 
				// didnt get completely filled. the remainder is the number of elements 
				// in the last row. when reading column by column dont read anything in 
				// if last element in column is part of the unfilled row.
				if(!(j < numOfRows-1) && !(i < remainder) && remainder != 0){
					// do nothing
				}
				else{
					text.get(j).add(encryptedString.charAt(count));
					//System.out.print(text.get(j).get(i));
					count++; // count number of characters processed	
				} // if
	    	} // for
			//System.out.println();
			i++;
		} // for
		
		// empty string
		encryptedString.setLength(0);
		
		// add diffused characters to string
		for(i = 0; i < text.size(); i++) {
			for(j = 0; j < text.get(i).size(); j++)
			{
				encryptedString.append(text.get(i).get(j));
	    	} // for
		} // for
		
		tempString.setLength(0);
		// decrypt text
		
		// loop through characters in string and add characters in pairs 
    	// to a  temp string. decrypt temp string and add decrypted character
    	// to main decrypted string
    	for (i = 0; i < encryptedString.length(); i += 2){
    		// get characters in pairs from string "line"
		    c1 = encryptedString.charAt(i);  
		    c2 = encryptedString.charAt(i+1);
		    
		    c1 = Character.toUpperCase(c1); // convert to upper case
		    c2 = Character.toUpperCase(c2);
		    
		    tempString.append(c1); // get chars in pairs for string
			tempString.append(c2);
			
		    // Decrypt each pair of characters and build a string
		    decryptedString.append(getDecryption(tempString.toString()));
		    
			// empty string builder temp
			tempString.setLength(0);
    	} // for
		
	/*	try
		{
			// print encrypted text to file
			PrintWriter writer = new PrintWriter((new BufferedWriter(new FileWriter("Test1.txt"))));
		
			count = 0;
			i = 0;
			for(i = 0; i < text.size(); i++) {
				for(j = 0; j < text.get(i).size(); j++){
					if(count == encryptedString.length()){
						break;
					}
					writer.write(text.get(i).get(j));
					//System.out.print(text.get(i).get(j));
					
		    		count++; // count number of characters processed
		    	} // for
				//System.out.println();
			} // for
			
			writer.close();
		} 
		catch (Exception e1)
		{
			System.out.println("Error..");
		}*/
	
		try {
			// print Decrypted text to file
			PrintWriter writer = new PrintWriter("Decrypted.txt");
			
			// write text to file
			writer.print(decryptedString);
			
			writer.close();
		}	
		catch (Exception e)
		{
			System.out.println("Error, Could Not Write Decrypted Text To File.");
		} // try catch
	} // decryptFile()
	
} // Class
