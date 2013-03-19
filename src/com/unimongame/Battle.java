package com.unimongame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.unimongame.attack.Attack;

public class Battle {
	private Player[] players;
	private Random rand = new Random();
	private HashMap<String, Unimon> unimonList;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private boolean isFinished = false;

	public Battle(Player playerA, Player playerB) {
		players = new Player[2];
		flipCoin(playerA, playerB);
		unimonList = new HashMap<String, Unimon>();
		loadUnimon();
	}

	public void run() {
		pickTeam(players[0]);
		System.out.println();
		pickTeam(players[1]);
		selectUnimon(players[0]);
		System.out.println();
		selectUnimon(players[1]);

		for (int i = 0; isFinished == false; i++) {
			int playerNumber = i % 2;
			turn(playerNumber);
		}
	}

	public void loadUnimon() {
		UnimonLoader.load(unimonList);
	}

	private void flipCoin(Player a, Player b) {

		if (rand.nextBoolean()) {
			players[0] = a;
			players[1] = b;
		} else {
			players[0] = b;
			players[1] = a;
		}

	}

	/*
	 * returns 1 if someone wins 0 otherwise.
	 */
	private int turn(int playerNumber) {
		players[playerNumber].startOfTurnUpdate();
		if (players[playerNumber].getActiveUnimon() == null) {
			// first round, no unimon on field
			selectUnimon(players[playerNumber]);
		} else if (!players[playerNumber].getActiveUnimon().isAlive()) {
			// current unimon is dead
			if (!(players[playerNumber].numAlive() == 0)) {
				// player one has no more unimon and loses
				end(players[1]);
				return 1;
			} else {
				selectUnimon(players[playerNumber]);
			}
		}

		// at this stage player has alive unimon on the field.

		getAction(playerNumber);
		return 0; // no winner this turn;

	}

	private void pickTeam(Player p) {
		while (p.getMoney() > 0) {
			ArrayList<Unimon> available = new ArrayList<Unimon>();
			for (Unimon u : unimonList.values()) {
				if (u.getCost() <= p.getMoney()) {
					available.add(u);
				}
			}
			if (available.size() == 0)
				break;
			System.out.println(p.getName() + " select a unimon, you have $"
					+ p.getMoney()
					+ " credits left. Type END to finish selection early");
			if (available.size() == 0)
				break;
			for (Unimon u : available) {
				System.out.println(u.getName() + " :: $" + u.getCost() + " '"
						+ u.getDescription() + "'");
			}

			try {
				System.out.print("Name > ");
				String choice = in.readLine();
				if (choice.equals("END"))
					break;
				else if (!unimonList.containsKey(choice)) {
					System.out.println("invalid choice try again..");
					continue;
				} else {
					// creates a shallow clone of a unimon and adds it to the
					// players list.
					Unimon chosen = unimonList.get(choice);
					p.addUnimon((Unimon) chosen.clone());
					p.spendMoney(chosen.getCost());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void getAction(int p) {
		switch (turnMenu()) {
		case 1:
			doAttack(p);
			checkForWin();
			break;
		case 2:
			selectUnimon(players[p]);
			break;
		case 3: // items aren't implemented yet
			break;
		default:
			System.out.println("error in turnMenu");
			break;
		}
	}

	private void selectUnimon(Player p) {
		while (true) {
			System.out.println("Select Unimon to put out on to field");
			for (int i = 0; i < p.numAlive(); i++) {
				System.out.println(i + ")"
						+ p.getAliveUnimon().get(i).toString());
			}
			try {
				int choice = Integer.parseInt(in.readLine());
				if (choice < 0 || choice >= p.numAlive()) {
					System.out.println("invalid choice" + p.numAlive());
					continue;
				}
				System.out.println(p.getAliveUnimon().get(choice)
						+ " was sent out!");
				p.setActiveUnimon(p.getAliveUnimon().get(choice));
				break;
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}

	}

	private void end(Player winner) {
		isFinished = true;
		System.out.println(winner.getName() + "is the winner");
	}

	private void doAttack(int p) {
		while (true) {

			System.out.println(players[p].getName() + "Select an attack!");
			Unimon actUni = players[p].getActiveUnimon();
			for (int i = 0; i < actUni.getAttacks().size(); i++) {
				System.out.println(actUni.getAttacks().get(i).toString());
			}
			try {
				int choice = Integer.parseInt(in.readLine());
				if (choice < 0 || choice >= actUni.getAttacks().size())
					continue;
				Attack chosen = actUni.getAttacks().get(choice);
				actUni.attack(chosen, players[(p + 1) % 2].getActiveUnimon());
				break;

			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}

	}

	private int turnMenu() {
		System.out.println("1)Attack 2)Change Unimon 3)Use Item");
		try {
			int choice = Integer.parseInt(in.readLine());
			if (choice > 3 || choice < 1) {
				System.out.println("invalid choice");
				choice = turnMenu();
			} else {
				return choice;
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1; // error

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