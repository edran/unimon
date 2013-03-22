package com.unimongame;

import java.util.ArrayList;

public class Player {
	private ArrayList<Unimon> unimonList;
	private String name;
	private Unimon activeUnimon;
	private int money = 100; //Let's start with this, shall we?
	
	//constructor
	public Player(String name){
		this.name = name;
		unimonList = new ArrayList<Unimon>();
	}
	
	public String getName(){
		return name;
	}
	
	public void addUnimon(Unimon uni){
		unimonList.add(uni);
	}
	//returns all unimon, alive or dead
	public ArrayList<Unimon> getUnimon(){
		return unimonList;
	}

	/*
	 * returns the unimon on the field
	 */
	public Unimon getActiveUnimon(){
		return activeUnimon;
	}

	/*
	 * withdraws current unimon if there is one
	 * and sets the give unimon as the active one.
	 */
	public void setActiveUnimon(Unimon uni){
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
		int i = getAliveUnimon().size();
		System.out.println("nul alive = "+ i);
		return i;
	}
	
	public void startOfTurnUpdate(){
		for(Unimon uni: getAliveUnimon()){
			uni.startOfTurn();
		}
	}
	
	public int getMoney(){
		return money;
	}
	
	public void spendMoney(int x){
		money-=x;
	}
}
