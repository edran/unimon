package com.unimongame.attack;

import com.unimongame.*;

public abstract class Attack{
	private String name;
	private String description;
	private String power;
	
	public Attack(String name, String description, String power){
		this.name = name;
		this.description = description;
		this.power = power;
	}
	
	/*
	 * Must be overloaded by each attack subclass
	 */
	
	public abstract void doAttack(Unimon attacker, Unimon target);
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
		
	public String power(){
		return power;
	}
	
	public String toString(){
		return name + " : " + power + " : " + description;
	}
}
