package com.unimongame;
import com.unimongame.attack.*;

import java.io.Serializable;
import java.util.*;

public class Unimon implements Cloneable, Serializable{

	/*
	 * MAX_*_TURNS  refers to the max turns a signal attack can 
	 * add. A unimon could have longer after multiple attacks;
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 248512478196705557L;
	private static final int MAX_DISTRACT_TURNS 	= 3;
	private static final int MAX_CONFUSE_TURNS  	= 5;
	private static final int MAX_HUNGOVER_TURNS 	= 3;
	private int status								= 1;
	private int turnsUntilNotConfused				= 0;
	private int turnsUntilNotDistracted		    = 0;
	private int turnsUntilNotHungover			    = 0;
	private MulitpleTurnAttackList multipleTurnAttacks;
	private int hp;
	private int maxHp;
	private Random rand;
	private String id;
	private String name;
	private Type type;
	private String description;
	private int cost;
	private ArrayList<Attack> attacks;



	public Unimon(String id, String name, Type type, String des,int startHp, int cost){
		this.id = id;
		this.name = name;
		this.type = type;
		this.status =1;
		this.hp = startHp;
		this.maxHp = startHp;
		this.description = des;
		this.cost = cost;
		attacks = new ArrayList<Attack>();
		rand = new Random();
		multipleTurnAttacks = new MulitpleTurnAttackList();

	}
	
	/*
	 * Returns the id of the unimon.
	 */
	public String getId(){
		return id;
	}
	
	/*
	 * Returns the name of the unimon.
	 */
	public String getName(){
		return name;
	}
	
	
	/*
	 * Returns a description of the unimon.
	 */
	public String getDescription(){
		return description;
	}

	/*
	 * Returns the current health points of the unimon
	 */
	public int getHp(){
		return hp;
	}
	
	public int getMaxHp(){
		return maxHp;
	}
	
	/*
	 * amount > 0, increaseHp
	 * amount < 0, reduceHp
	 */
	public void modifyHp(int amount){
		hp += amount;
		if(hp <= 0){
			hp = 0;
			status = -1;
		}
		if (hp>maxHp) {
			hp = maxHp;
		}
	}	
	
	
	/*
	 * Decreases the the health points of the unimon
	 */
	public void reduceHp(int amount){
		hp -=amount;
		if(hp<=0){
			hp = 0;
			status = -1;
		}
	}


	/*
	 * Increases the current health points of the unimon.
	 * Can increase above the starting 100.
	 */
	public void increaseHp(int amount){
		hp += amount;
	}

	/*
	 * Confused unimon do damaged to themselves CONFUSE_PERCENTAGE of the time.
	 * Confuses the unimon between 1 and MAX_SLEEP_TURNS
	 */
	public void confuse(){
		status *= 7;
		turnsUntilNotConfused += rand.nextInt(MAX_CONFUSE_TURNS)+1;
	}

	/*
	 * Distracted unimon distracted unimon don't attack DISTRACT_PERCENTAGE of the time.
	 * Distract the unimon for between 1 and MAX_DISTRACT_TURNS
	 */
	public void distract(){
		status *=3;
		turnsUntilNotDistracted += rand.nextInt(MAX_DISTRACT_TURNS)+1;	
	}


	/*
	 * Sleeping unimon are immobilised
	 * sleep 
	 */
	public void hungover(){
		status *=5;
		turnsUntilNotHungover += rand.nextInt(MAX_HUNGOVER_TURNS)+1;
	}

	/*
	 * returns the status of the unimon
	 * see status guide above
	 */
	public int getStatus(){
		return status;
	}

	/*
	 * returns all the attack of the unimon
	 */
	public ArrayList<Attack> getAttacks(){
		return attacks;
	}


	/*
	 * attacks the given Unimon using the given attack.
	 */
	public void attack(Attack att, Unimon target){
		att.doAttack(this, target);
	}

	public void attack(int attackPosition, Unimon target){
		attacks.get(attackPosition).doAttack(this, target);
	}

	/*
	 * Adds an attack to the unimon.
	 */
	public void addAttack(Attack att){
			attacks.add(att);
	}
	
	public void addMultipleTurnAttack(){
		
	}
	/*
	 * returns the type of the unimon.
	 */
	public Type getType(){
		return type;
	}

	/*
	 * returns the cost of the unimon.
	 * cost is only used when selected unimon at the start.
	 */
	public int getCost(){
		return cost;
	}


	/*
	 * returns true if unimon is confused.
	 */
	public boolean isConfused(){
		return getStatus() %7 == 0;
	}

	/*
	 * returns true if unimon is distracted.
	 */
	public boolean isDistracted(){
		return getStatus() %3 == 0;
	}

	/*
	 * returns true if unimon is asleep.
	 */
	public boolean isHungover(){
		return getStatus() %5 == 0;
	}

	/*
	 *returns true if unimon is alive
	 */
	public boolean isAlive(){
		return getStatus()!=-1;
	}

	/*
	 * does damage from attacks which effect unimon every turn.
	 */
	public void startOfTurn(){
		this.multipleTurnAttacks.doAttacks();
		
	}
	
	/*
	 * updates status of unimon
	 */
	public void endOfTurn(){

		if(turnsUntilNotConfused>1){
			turnsUntilNotConfused--;
		}else if(turnsUntilNotConfused==1){
			turnsUntilNotConfused = 0;
			status /=7;
		}
		if(turnsUntilNotDistracted>1){
			turnsUntilNotDistracted--;
		}else if(turnsUntilNotDistracted==1){
			turnsUntilNotDistracted = 0;
			status /=3;
		}
		if(turnsUntilNotHungover>1){
			turnsUntilNotHungover--;
		}else if(turnsUntilNotHungover==1){
			turnsUntilNotHungover = 0;
			status /=5;
		}
		
		multipleTurnAttacks.endOfTurn();
		
	}
	
	@Override
	public String toString(){
		return name+" has "+hp+"hp and has a status of "+getStatus()+" their attacks are : "+Arrays.toString(attacks.toArray());
		
	}
	
	
	public Object clone() {
		try
		{
		return super.clone();
		}
		catch(Exception e){ return null; }
		}
}
