package com.unimongame.attack2;

import com.unimongame.*;

public abstract class Attack{
	private String name;
	private String description;
	
	public Attack(String name, String description){
		this.name = name;
		this.description = description;
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
		
	
	public String toString(){
		return name + " : " + description;
	}
}
