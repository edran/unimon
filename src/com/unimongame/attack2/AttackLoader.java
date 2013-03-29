/**
 * 
 */
package com.unimongame.attack2;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.Unimon;
import com.unimongame.attack.Attack;
import com.unimongame.parser.unimonParser;

public class AttackLoader {
	
	public static void load(HashMap<String,Unimon> UnimonMap, HashMap<String,Attack>attackMap){
		//while we have no parser.. dummy Unimon.
		
		boolean DEBUG = false;
		
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		String[][] d = unimonParser.getData();
		for (int i = 0; i < d.length; i++){
			
			Unimon uni = new Unimon(d[i][0],d[i][1],null,d[i][5],
					Integer.parseInt(d[i][3]),Integer.parseInt(d[i][4]));
			
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
			
			UnimonMap.put(d[i][0],uni);	
		}
		
		
	}
	



}