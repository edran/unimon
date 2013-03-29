package com.unimongame;

import java.io.Serializable;

import com.unimongame.attack.Attack;

public class Message implements Serializable{
 static final long serialVersionUID = 8031047968928742647L;
 private final MessageType mType;
 private String attack;
 private String item;
 private String turnMessage;
// numbers are the position of unimon in players AliveUnimon list
 private int UnimonSelected; 
 private int itemUsedOn;

 
 public Message(MessageType mType){
	 this.mType = mType;
 }
 
 public MessageType getMessageType(){
	return mType; 
 }
 
 public void setAttack(String attack){
	 this.attack = attack;
 }
 public String getAttack(){
	 return attack;
 }
 
 public void setSelectUnimon(){
	 
 }
 
 public int getSelectedUnimon(){
	 return UnimonSelected;
 }
 

public void setItem(String item) {
	this.item = item;
}

public String getItem() {
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
