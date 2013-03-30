package com.unimongame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import com.unimongame.parser.*;
import com.unimongame.attack.*;

public class UnimonLoader {
	
	public static HashMap<String,Unimon> load(){
		HashMap<String,Unimon> unimonMap = new HashMap<String, Unimon>();
		HashMap<String, Attack> attackMap = new HashMap<String, Attack>();
		AttackLoader.load(attackMap);
		boolean DEBUG = false;
		String[][] d = unimonParser.getData();
		for (int i = 0; i < d.length; i++){
			Unimon uni = new Unimon(d[i][0],d[i][1],null,d[i][5],Integer.parseInt(d[i][3]),Integer.parseInt(d[i][4]));
			uni.addAttack(attackMap.get(d[i][6]));
			uni.addAttack(attackMap.get(d[i][7]));
			uni.addAttack(attackMap.get(d[i][8]));
			uni.addAttack(attackMap.get(d[i][9]));

			if(DEBUG){
				System.out.println("##");
				System.out.println(uni.getName());
				System.out.println(uni.getAttacks().get(0));
				System.out.println(uni.getAttacks().get(1));
				System.out.println(uni.getAttacks().get(2));
				System.out.println(uni.getAttacks().get(3));
				System.out.println("##");

			}
			
			unimonMap.put(d[i][0],uni);	//id is key
			
		}
		return unimonMap;
		
		
	}
	



}
