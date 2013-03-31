package com.unimongame;

import java.util.ArrayList;

public class Type {

	private String name;
	private ArrayList<Type> strength;
	private ArrayList<Type> weakness;
	
	public Type(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addStrength(Type stren) {
		strength.add(stren);
	}

	public ArrayList<Type> getStrengths() {
		return strength;
	}
	
	public void addWeakness(Type weak) {
		weakness.add(weak);
	}

	public ArrayList<Type> getWeaknesses() {
		return weakness;
	}
}
