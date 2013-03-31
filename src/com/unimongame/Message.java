package com.unimongame;

import java.io.Serializable;
import java.util.ArrayList;

import com.unimongame.attack.Attack;

public class Message implements Serializable{
 static final long serialVersionUID = 8031047968928742647L;
 private final MessageType mType;
 private int attack;
 private int item;
 private String turnMessage;
 private Player[] players = new Player[2];
// numbers are the position of unimon in players AliveUnimon list
 private int UnimonSelected; 
 private int itemUsedOn;

 
 public Message(MessageType mType){
	 this.mType = mType;
 }
 
 public MessageType getMessageType(){
	return mType; 
 }
 
 public void setPlayers(Player[] players){
	 this.players = players;
 }
 public Player[] getPlayers(){
	 return players;
 }
 public void setAttack(int attack){
	 this.attack = attack;
 }
 public int getAttack(){
	 return attack;
 }
 
 public void setSelectUnimon(int uni){
	this.UnimonSelected = uni; 
 }
 
 public int getSelectedUnimon(){
	 return UnimonSelected;
 }
 

public void setItem(int item) {
	this.item = item;
}

public int getItem() {
	return item;
}

public void setItemUsedOn(int unimonPos){
	this.itemUsedOn = unimonPos;
}

public int getItemUsedOn(){
	return itemUsedOn;
}

public void setTurnMessage(String turnMessage){
	this.turnMessage = turnMessage;
}

public String getTurnMessage(){
	return turnMessage;
}


}
