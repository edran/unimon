package com.unimongame.attack;

import com.unimongame.*;

/*
 * Get list from attack_list
 * id,name,description,self_damage,self_status,target_damage,target_status
 */

public class Attack{
	private int 	id;
	private String name;
	private String description;
	private int	selfEffect;
	private int	selfStatus;
	private int 	targetEffect;
	private int	targetStatus;
	
	/*
	 * NOTE WELL for selfStatus and targetStatus: 
	 *		
	 *	   -1	= dead 
	 * 	 (0)1  = nothing		
	 * 		3  = distract
	 * 		5  = hungover
	 *		7  = confuse
	 *
	 */
	
	public Attack(int id, String name, String description, int selfEffect, 
			int selfStatus, int targetEffect, int targetStatus){

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
	
	public void doAttack(Unimon attacker, Unimon target){
		
		attacker.modifyHp(selfEffect);
		if(selfStatus == 3) attacker.distract();
		if(selfStatus == 5) attacker.hungover();
		if(selfStatus == 7) attacker.confuse();
		
		target.modifyHp(targetEffect);
		if(targetStatus == 3) target.distract();
		if(targetStatus == 5) target.hungover();
		if(targetStatus == 7) target.confuse();
		
		
	}

	
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
	
	public int getSelfStatus(){ 		//TODO: decide whether we want int or string
		return selfStatus;
	}
	
	public int getTargetEffect(){
		return targetEffect;
	}

	public int getTargetStatus(){ 		//TODO: decide whether we want int or string
		return targetStatus;
	}
	
	
	public String toString(){
		return name + " : " + description;
	}
}
