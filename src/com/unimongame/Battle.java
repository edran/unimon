package com.unimongame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.unimongame.GUI.CombatPanel;
import com.unimongame.GUI.Effects;
import com.unimongame.GUI.FightGUI;
import com.unimongame.GUI.GameWindow;
import com.unimongame.attack.Attack;
import com.unimongame.attack.AttackLoader;

public class Battle {
	private Player[] players;
	private Random rand = new Random();
	private boolean isFinished = false;
	private Server server;
	
	//private boolean isTurnOver = false;
	private int playerNum = 0;
	
	

	public Battle(Player playerA, Player playerB, Server server) {
		players = new Player[2];
		this.server = server;
		players[0] = playerA;
		players[1] = playerB;
		flipCoin();
	} 

	
	
	public void start(){
		turn(playerNum);
	}

	private void flipCoin(){
		playerNum  = Math.abs(rand.nextInt())%2;
	}

	/*
	 * returns 1 if someone wins 0 otherwise.
	 */
	private void turn(int playerNumber) {
		server.startTurn(playerNumber);
	}
	
	
	public void selectUnimon(Player p , Unimon uni, boolean endTurn) {
		p.setActiveUnimon(uni);
		server.update(p.getName()+" changed his Unimon to : "+uni.getName());
		if(endTurn){
			endTurn();
		}else{
			turn(playerNum);
		}
	}
	
	private void end(Player winner) {
		isFinished = true;
		System.out.println(winner.getName() + "is the winner");
	}

	public void doAttack(Player attacker,Player target ,int attackNum) {
				System.out.println(attacker.getActiveUnimon()+" used "+attacker.getActiveUnimon().getAttacks().get(attackNum)
						+"on "+target.getActiveUnimon().getName());
				attacker.getActiveUnimon().attack(attackNum, target.getActiveUnimon());	
				server.update(attacker.getActiveUnimon()+" used "+attacker.getActiveUnimon().getAttacks().get(attackNum)
						+"on "+target.getActiveUnimon().getName());
				System.out.println("isTurnover = true");
				endTurn();
	}

	private void endTurn() {
		checkForWin();
		turn((++playerNum)%2);
	}



	/*
	 * checks for a winner, ends game if there is.
	 */
	private void checkForWin() {
		if (players[0].numAlive() == 0) {
			end(players[1]);
		} else if (players[1].numAlive() == 0) {
			end(players[0]);
		}
	}

}