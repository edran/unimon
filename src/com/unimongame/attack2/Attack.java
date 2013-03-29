package com.unimongame.attack2;

import com.unimongame.*;

public abstract class Attack{
	private int id;
	private String name;
	private String description;
	private int	selfEffect;
	private String	selfStatus;
	private int 	targetEffect;
	private String targetStatus;
	
	public Attack(int id, String name, String description, int selfEffect, 
			String selfStatus, int targetEffect, String targetStatus){

		this.id = id;
		this.name = name;
		this.description = description;
		this.selfEffect = selfEffect;
		this.selfStatus = selfStatus;
		this.targetEffect = targetEffect;
		this.targetStatus = targetStatus;
		
	}
	
	/*
	 * TO DO
	 * 
	 * DONE
	 * Creation
	 * 42
	 * 
	 */
	
	public abstract void doAttack(Unimon attacker, Unimon target);

	
	public int getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getSelfEffect(){
		return selfEffect;
	}
	
	public String getSelfStatus(){
		return selfStatus;
	}
	
	public int getTargetEffect(){
		return targetEffect;
	}

	public String getTargetStatus(){
		return targetStatus;
	}
	
	
	public String toString(){
		return name + " : " + description;
	}
}
