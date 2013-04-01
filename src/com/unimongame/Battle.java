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
	int numDied = 0;

	public Battle(Player playerA, Player playerB, Server server) {
		players = new Player[2];
		this.server = server;
		players[0] = playerA;
		players[1] = playerB;

		flipCoin();
	}

	public void start() {
		turn();
	}

	private void flipCoin() {
		playerNum = Math.abs(rand.nextInt()) % 2;
	}

	/*
	 * returns 1 if someone wins 0 otherwise.
	 */
	private void turn() {
		System.out.println("Battle - turn Start, player " + playerNum);
		if (!isFinished) {
			server.startTurn(playerNum);
		}
	}

	private void endTurn() {
		playerNum = (playerNum + 1) % 2;
		turn();
	}

	public void selectUnimon(Player p, int i, boolean endTurn) {
		p.setActiveUnimon(p.getBenchUnimon().get(i));
		server.update(players[0], players[1], p.getName()
				+ " changed his Unimon to : " + p.getActiveUnimon().getName());
		if (endTurn) {
			endTurn();
		} else {
			numDied--;
		}
	}

	public void doAttack(int attackerNumber, int targetNumber, int attackNum) {
		System.out.println("Battle : doAttack");
		Player attacker = players[attackerNumber];
		Player target = players[targetNumber];
		attacker.getActiveUnimon().attack(attackNum, target.getActiveUnimon());
		// System.out.println("battle - tagets hp: "
		// + target.getActiveUnimon().getHp());
		server.update(players[0], players[1], attacker.getActiveUnimon()
				.getName()
				+ " used "
				+ attacker.getActiveUnimon().getAttacks().get(attackNum)
						.getName()
				+ " on "
				+ target.getActiveUnimon().getName());
		numDied = checkForDeadUnimon();
		System.out.println("num Died" + numDied);
		while (numDied > 0) {
			System.out.println("doAttack - num Died" + numDied);
		}
		endTurn();
	}

	private int checkForDeadUnimon() {
		String infoString = new String();
		numDied = 0;
		if (!players[0].getActiveUnimon().isAlive()) {
			if (players[0].getAliveUnimon().size() == 0) {
				server.winner(1);
				isFinished = true;
			} else {
				numDied++;
				infoString = players[0].getActiveUnimon().getName()
						+ " is dead \n Select a new Unimon";
				server.unimonDied(0, infoString);
			}
		}
		if (!players[1].getActiveUnimon().isAlive()) {
			if (players[0].getAliveUnimon().size() == 0) {
				server.winner(0);
				isFinished = true;
			} else {
				numDied++;
				infoString = players[1].getActiveUnimon().getName()
						+ " is dead \n Select a new Unimon";
				server.unimonDied(1, infoString);

			}
		}
		return numDied;
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
		numDied = checkForDeadUnimon();
		// System.out.println("num Died"+numDied);
		while (numDied > 0) {
		}
		endTurn();
	}

}