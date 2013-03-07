package com.unimongame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

import com.unimongame.attack.Attack;

public class Battle{
	private Player[] players;
	private Random rand = new Random();
	private HashMap<String ,Unimon> unimon;
	
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private boolean isFinished = false;
	
	public Battle(Player playerA, Player playerB){
		players = new Player[2];
		flipCoin(playerA, playerB);
	}
	
	public void run(){
		pickTeam(players[0]);
		pickTeam(players[1]);
		
		for(int i = 0;isFinished==false;i++){
			int playerNumber = i%2;
			turn(playerNumber);
		}
	}
	
	public void loadTypes(){
		
		
	}
	public void loadAttacks(){
		
	}
	public void loadUnimon(){
		
	}
	
	
	
	private void flipCoin(Player a, Player b){
		
		if(rand.nextBoolean())
		{
			players[0] = a;
			players[1] = b;
		}else{
			players[0] = b;
			players[1] = a;
		}
			
	}
	
	/*
	 * returns 1 if someone wins 0 otherwise. 
	 */
	private int turn(int playerNumber){
		players[playerNumber].startOfTurnUpdate();
		if(players[playerNumber].getAcitveUnimon() == null){
			//first round, no unimon on field
			selectUnimon(players[playerNumber]);
		}
		if(!players[playerNumber].getAcitveUnimon().isAlive()){
			//current unimon is dead
			if(!(players[playerNumber].numAlive()==0)){
				//player one has no more unimon and loses
				end(players[1]);
				return 1;
			}else{
				selectUnimon(players[playerNumber]);
			}
		}
		
		//at this stage player has alive unimon on the field.
	
		getAction();
		return 0; // no winner this turn;
		
	}
	
	
	private void pickTeam(Player p){
		
		
	}
	private void getAction(){
		switch(turnMenu()){
		case 1: doAttack(players[0]);
				checkForWin();
		break;
		case 2: selectUnimon(players[0]);
		break;
		case 3: //items aren't implemented yet
		break;
		default: System.out.println("error in turnMenu");
		break;
		}
	}
	
	private void selectUnimon(Player p){
		
	}
	
	private void end(Player winner){
		isFinished = true;
		System.out.println(winner.getName() + "is the winner");
	}
	
	private void doAttack(Player player){
		
	}
	private int turnMenu(){
		System.out.println("1)Attack 2)Change Unimon 3)Use Item");
		try {
			int choice = Integer.parseInt(""+in.readLine().charAt(0)); // gets first char of input.
			if(choice >3 || choice<1 ){
				System.out.println("invalid choice");
				choice = turnMenu();
			}else{
				return choice;
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1; //error
		
	}
	
	/*
	 * checks for a winner, ends game if there is.
	 */
	private void checkForWin(){
		if(players[0].numAlive()==0){
			end(players[1]);
		}else if(players[1].numAlive()==0){
			end(players[0]);
		}
	}
}