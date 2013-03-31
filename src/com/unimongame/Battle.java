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
import com.unimongame.item.Item;

public class Battle {
	private Player[] players;
	private Random rand = new Random();
	private boolean isFinished = false;
	private Server server;

	// private boolean isTurnOver = false;
	private int playerNum = 0;

	public Battle(Player playerA, Player playerB, Server server) {
		players = new Player[2];
		this.server = server;
		players[0] = playerA;
		players[1] = playerB;
		flipCoin();
	}

	public void start() {
		
			turn(playerNum);
		
	}

	private void flipCoin() {
		playerNum = Math.abs(rand.nextInt()) % 2;
	}

	/*
	 * returns 1 if someone wins 0 otherwise.
	 */
	private void turn(int playerNumber) {
		if(!isFinished){
			server.startTurn(playerNumber);			
		}
	}

	public void selectUnimon(Player p, int i, boolean endTurn) {
		// System.out.println("switching from "+p.getActiveUnimon().getName()+" to "+p.getAliveUnimon().get(i).getName());
		p.setActiveUnimon(p.getAliveUnimon().get(i));
		server.update(players[0], players[1], p.getName()
				+ " changed his Unimon to : " + p.getName() + "\n");
		if (endTurn) {
			endTurn();
		} else {
			turn(playerNum);
		}
	}

	public void doAttack(int attackerNumber, int targetNumber, int attackNum) {
		System.out.println("Battle : doAttack");
		Player attacker = players[attackerNumber];
		Player target = players[targetNumber];
		attacker.getActiveUnimon().attack(attackNum, target.getActiveUnimon());
		System.out.println("battle - tagets hp: "
				+ target.getActiveUnimon().getHp());
		server.update(players[0], players[1], attacker.getActiveUnimon()
				.getName()
				+ " used "
				+ attacker.getActiveUnimon().getAttacks().get(attackNum)
						.getName()
				+ "on "
				+ target.getActiveUnimon().getName()
				+ "his new hp is " + target.getActiveUnimon().getHp());
		System.out.println("isTurnover = true");
		endTurn();
	}

	private void endTurn() {
		checkForDeadUnimon();
		turn((++playerNum) % 2);
	}

	private void checkForDeadUnimon() {
		String infoString = new String();
		if (!players[0].getActiveUnimon().isAlive()) {
			if (players[0].getAliveUnimon().size() == 0) {
				server.winner(1);
				isFinished = true;
			} else {

				infoString = players[0].getActiveUnimon().getName()
						+ " is dead \n Select a new Unimon\n";
				server.unimonDied(0, infoString);
			}
		}
		if (!players[1].getActiveUnimon().isAlive()) {
			if (players[0].getAliveUnimon().size() == 0) {
				server.winner(0);
				isFinished = true;
			} else {

				infoString = players[1].getActiveUnimon().getName()
						+ " is dead \n Select a new Unimon\n";
				server.unimonDied(1, infoString);
			}
		}
	}

	/*
	 * checks for a winner, ends game if there is.
	 */

	public void userItem(int clientNumber, int item) {
		Item selectedItem = players[clientNumber].getItems().get(item);
		String infoString = players[clientNumber].getName() + " used "
				+ selectedItem.getName();
		players[clientNumber].useItem(selectedItem);
		server.update(players[0], players[1], infoString);
		endTurn();
	}

}