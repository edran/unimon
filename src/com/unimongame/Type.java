package com.unimongame;

import java.io.Serializable;
import java.util.ArrayList;

public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3025756759293719509L;
	private String name;
	private ArrayList<Type> strength = new ArrayList<Type>();
	private ArrayList<Type> weakness = new ArrayList<Type>();
	
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
