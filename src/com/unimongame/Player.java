package com.unimongame;

import java.util.ArrayList;

public class Player {
	private ArrayList<Unimon> unimonList;
	private String name;
	private Unimon activeUnimon;
	
	//constructor
	public Player(String name){
		this.name = name;
		unimonList = new ArrayList<Unimon>();
	}
	
	public String getName(){
		return name;
	}
	
	//returns all unimon, alive or dead
	public ArrayList<Unimon> getUnimon(){
		return unimonList;
	}

	/*
	 * returns the unimon on the field
	 */
	public Unimon getAcitveUnimon(){
		return activeUnimon;
	}

	/*
	 * withdraws current unimon if there is one
	 * and sets the give unimon as the active one.
	 */
	public void setAciveUnimon(Unimon uni){
		this.activeUnimon = uni;
	}
	/*
	 * returns the unimon that are still alive
	 */
	public ArrayList<Unimon> getAliveUnimon(){
		ArrayList<Unimon> list = new ArrayList<Unimon>();
		for(Unimon uni : unimonList){
			if(uni.isAlive()){
				list.add(uni);
			}
		}
		return list;
	}

	/*
	 * returns the number of unimon left alive
	 */
	public int numAlive(){
		return getAliveUnimon().size();
	}
	
	public void startOfTurnUpdate(){
		for(Unimon uni: getAliveUnimon()){
			uni.startOfTurn();
		}
	}
}
