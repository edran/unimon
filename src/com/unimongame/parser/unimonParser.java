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
	 * Get list from parser/unimon_list
	 * 
	 */
	
	
	public static String[][] getData() {
 
		BufferedReader buffer = null;
		String currentLine;
		String[][] data = new String[100][10];
		
		try {
			
			buffer = new BufferedReader(new FileReader("unimon_list"));
			currentLine = buffer.readLine(); //First line
			int i = 0;
			
			while ((currentLine = buffer.readLine()) != null && i < 98) {
				data[i] = currentLine.split(",");
				i++;
			}
			
			String[][] finalData = new String[i][10];
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
