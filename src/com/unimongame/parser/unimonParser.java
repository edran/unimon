package com.unimongame.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.unimongame.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class unimonParser {
 
	 /*
	  * Get list from unimon_list
	  * id,name,type,hp,cost,description,attack,attack,attack,attack
	  */
	
	
	public static String[][] getData() {
		
		int n = 10; //modify accordingly 
		
		BufferedReader buffer = null;
		String currentLine;
		String[][] data = new String[100][n];
		
		try {
			
			buffer = new BufferedReader(new FileReader("resources/lists/unimon_list"));
			currentLine = buffer.readLine(); //First line
			int i = 0;
			
			while ((currentLine = buffer.readLine()) != null && i < 98) {
				data[i] = currentLine.split(",");
				i++;
			}
			
			String[][] finalData = new String[i][n];
			System.arraycopy(data, 0, finalData, 0, i); //makes length usable.
			return finalData;
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		finally {
			
			try {
				if (buffer != null) buffer.close();
			} 
			
			catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
		return data;
 
	}
	
	public static void main(String[] args){ //Simply a test
		String[][] data = getData();
		for (int k = 0; k < data.length; k++){
			System.out.println("id = " + data[k][0]);
		}
		
	}
}
