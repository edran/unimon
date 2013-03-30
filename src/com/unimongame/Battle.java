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
	private HashMap<String, Attack> attackList;
	private HashMap<String, Unimon> unimonList;
	private GameWindow[] windows;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private boolean isFinished = false;
	
	//private boolean isTurnOver = false;
	private int playerNum = 0;
	
	

	public Battle(Player playerA, Player playerB) {
		players = new Player[2];
		windows = new GameWindow[2];
		players[0] = playerA;
		players[1] = playerB;
		flipCoin(playerA, playerB);
		attackList = new HashMap<String, Attack>();
		unimonList = new HashMap<String, Unimon>();
		loadUnimon();
	} 

	public void run() {
		pickTeam(players[0]);
		pickTeam(players[1]);
		
		//windows[0] = new GameWindow(this);
		//windows[1]= new GameWindow(this);
		selectUnimon(players[0],players[0].getAliveUnimon().get(0),false);
		selectUnimon(players[1],players[1].getAliveUnimon().get(0),false);
		
		
	
	}
	
	public void start(){
		System.out.println("in start");
		windows[0].setPlayers(players[0],players[1]);
		windows[1].setPlayers(players[1],players[0]);
		windows[0].showFightGUI();
		windows[1].showFightGUI();
		turn(playerNum);
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
	private void turn(int playerNumber) {
		update();
		windows[playerNumber].turn();
		windows[++playerNumber%2].waitOnPlayer();
		
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
			System.out.println("## " + p.getName()
					+ " select a unimon - you have $" + p.getMoney()
					+ " credits left");
			System.out.println("## Type q to finish selection early");
			if (available.size() == 0)
				break;
			for (Unimon u : available) {
				System.out.println(u.getId() + " - " + u.getName() + " :: $" + u.getCost() + " '"
						+ u.getDescription() + "'");
			}

			try {
				System.out.print("Id > ");
				String choice = in.readLine();
				//choice = "01";
				if (choice.equals("q"))
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



	public void selectUnimon(Player p , Unimon uni, boolean endTurn) {
		p.setActiveUnimon(uni);
		if(endTurn){
			endTurn();
		}
	}
	
	private void update(){
		windows[0].updateInfo(players[0],players[1]);
		windows[1].updateInfo(players[1],players[0]);
	}

	private void end(Player winner) {
		isFinished = true;
		System.out.println(winner.getName() + "is the winner");
	}

	public void doAttack(Player attacker,Player target ,int attackNum) {
				System.out.println("attack");
				attacker.getActiveUnimon().attack(attackNum, target.getActiveUnimon());	
				update();
				
				
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