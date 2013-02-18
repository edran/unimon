package com.unimongame.attack;

import java.util.ArrayList;

public class MulitpleTurnAttackList {
	private ArrayList<MultipleTurnAttack> attacks;
	
	
	private void cleanUp(){ 
		for(MultipleTurnAttack att : attacks){
			if(att.finished()){
				attacks.remove(att);
			}
		}
	}
	
	private void decreaseTurns(){
		for(MultipleTurnAttack att : attacks){
			att.endTurn();
		}
		
	}
	
	public void doAttacks(){
		for(MultipleTurnAttack att : attacks){
				att.doAttack();
			}	
	}
	
	public void addMultipleTurnAttack(MultipleTurnAttack att){
		attacks.add(att);
	}
	
	public void removeAttack(Attack attackToRemove){
		while(attacks.contains(attackToRemove)){
			attacks.remove(attackToRemove);
		}
	}
	

	public void endOfTurn(){
		decreaseTurns();
		cleanUp();
	}
	

}
