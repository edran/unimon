package com.unimongame.attack;

import java.io.Serializable;

import com.unimongame.Unimon;

public class MultipleTurnAttack implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2662780983073504696L;
	private int remainingTurns;
	private Unimon attacker;
	private Unimon target;
	private Attack attack;
	private Boolean needsToBeAlive = true;
	
	MultipleTurnAttack(int turns,Unimon attacker, Unimon target, Attack attack, Boolean needsToBeAlive){
		this(turns,attacker,target,attack);
		this.needsToBeAlive = needsToBeAlive;
		
	}
	MultipleTurnAttack(int turns,Unimon attacker, Unimon target, Attack attack){
		this.remainingTurns = turns;
		this.attacker = attacker;
		this.target = target;
		this.attack = attack;
	}

	protected int getRemainingTurns() {
		return remainingTurns;
	}

	protected Unimon getAttacker() {
		return attacker;
	}

	protected Unimon getTarget() {
		return target;
	}

	protected Attack getAttack() {
		return attack;
	}
	
	protected void doAttack(){
		if(getAttacker().getStatus()==1 ||!(needsToBeAlive)){
			attack.doAttack(attacker, target);
		}
	
	}
	
	protected void endTurn(){
		remainingTurns --;
	}

	protected Boolean finished(){
		return ((getAttacker().getStatus()==1 &&!(needsToBeAlive))||getRemainingTurns()<=0 );
	}
}
