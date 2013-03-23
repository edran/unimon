package com.unimongame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.unimongame.*;

public class UnimonGame {

	private void choosePlayers(){
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Hello, player 1. What's your name?");
		System.out.print("Player 1 - Name>");
		String choice = in.readLine();
		Player a = new Player(choice);
		System.out.println("Hello, player 2. What's your name?");
		System.out.print("Player 2 - Name>");
		choice = in.readLine();
		Player b = new Player(choice);
		
	}

	public static void main(String[] args){
		
		boolean DEBUG = true;
		
		
		System.out.println("######################################################");
		System.out.println("######################################################");
		System.out.println("##													##");
		System.out.println("##		 Unimon! The battle for the lost lab!		##");
		System.out.println("##													##");
		System.out.println("##				  Text Based Version				##");
		System.out.println("##													##");
		System.out.println("######################################################");
		System.out.println("######################################################");
		System.out.println();
		
		Battle bat = new Battle(a,b);
		bat.run();
				
		
		}
}

