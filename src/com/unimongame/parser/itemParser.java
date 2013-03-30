package com.unimongame.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.unimongame.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class itemParser {
 
  /*
   * Get list from item_list
   * id,name,description,effect,status
   */
	
	public static String[][] getData() {
		
		int n = 4; //modify accordingly to data
		
		BufferedReader buffer = null;
		String currentLine;
		String[][] data = new String[100][n]; //modify accordingly
		
		try {
			
			buffer = new BufferedReader(new FileReader("resources/lists/item_list"));
			currentLine = buffer.readLine(); //$value line
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
			System.out.println(data[k][0] + " = " + data[k][1] + 
					" " + data[k][2] + " " + data[k][3]);
		}
		
	}
}
