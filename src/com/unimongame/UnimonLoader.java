package com.unimongame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import com.unimongame.parser.*;
import com.unimongame.attack.*;

public class UnimonLoader {
	
	public static void load(HashMap<String,Unimon> UnimonMap, HashMap<String,Attack>attackMap){
		//while we have no parser.. dummy Unimon.
		
		boolean DEBUG = false;
		
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		String[][] d = unimonParser.getData();
		for (int i = 0; i < d.length; i++){
			Unimon uni = new Unimon(d[i][0],d[i][1],null,d[i][5],Integer.parseInt(d[i][3]),Integer.parseInt(d[i][4]));
			uni.addAttack(attackMap.get(d[i][6]));
			uni.addAttack(attackMap.get(d[i][7]));
			uni.addAttack(attackMap.get(d[i][8]));
			uni.addAttack(attackMap.get(d[i][9]));

			if(DEBUG){
				System.out.println("##");
				System.out.println(uni.getAttacks().get(0));
				System.out.println(uni.getAttacks().get(1));
				System.out.println(uni.getAttacks().get(2));
				System.out.println(uni.getAttacks().get(3));
				System.out.println("##");

			}
			
			UnimonMap.put(d[i][0],uni);	
		}
		/*
		unimons.add(new Unimon("01","Profmon",new Type(),"he's not very nice.",100,20));
		unimons.add(new Unimon("02","Lukemon",new Type(),"A beast",100,60));
		unimons.add(new Unimon("03","Moronmon", new Type(), "Ninjaa",150,39));
		unimons.add(new Unimon("04","Duhmon", new Type(),"lolololol",90,40));
		*/
		/*
		for(Unimon u : unimons){
			u.addAttack(new Punch());
			u.addAttack(new Recursion());
			map.put(u.getName(), u);
		}
		*/
		
	}
	



}
