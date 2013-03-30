package com.unimongame.type;
import java.util.ArrayList;

public class Type {
	private String name;
	private String description;
	private ArrayList<String> strengths;
	private ArrayList<String> weaknesses;

	public Type(String name, String description, ArrayList<String> strengths, ArrayList<String> weaknesses){

		this.name = name;
		this.description = description;
		this.strengths = strengths;
		this.weaknesses = weaknesses;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}

	public ArrayList<String> getStrengths(){
		return strengths;
	}

	public ArrayList<String> getWeaknesses(){ 		//TODO: decide whether how types work/how many ect.
		return weaknesses;
	}

	public String toString(){
		return name + " : " + description;
	}
}