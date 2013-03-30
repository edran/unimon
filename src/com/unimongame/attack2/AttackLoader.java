/**
 * 
 */
package com.unimongame.attack2;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.Unimon;
import com.unimongame.attack2.*;
import com.unimongame.parser.attackParser;

/*
 * Get list from attack_list
 * id,name,description,self_damage,self_status,target_damage,target_status
 */

public class AttackLoader {
	
	public static void load(HashMap<String,Attack> map){
		//while we have no parser.. dummy Unimon.
		
		boolean DEBUG = false;
		
		String[][] d = attackParser.getData();
		for (int i = 0; i < d.length; i++){
			
			map.put(d[i][1],new Attack(Integer.parseInt(d[i][0]),d[i][1],d[i][2],Integer.parseInt(d[i][3]),
					Integer.parseInt(d[i][4]),Integer.parseInt(d[i][5]),Integer.parseInt(d[i][6])));
			

			/*if(DEBUG){
				System.out.println("##");
				System.out.println(uni.getName());
				System.out.println(uni.getAttacks().get(0));
				System.out.println(uni.getAttacks().get(1));
				System.out.println(uni.getAttacks().get(2));
				System.out.println(uni.getAttacks().get(3));
				System.out.println("##");

			}
			*/
			//UnimonMap.put(d[i][0],uni);	
		}
		
		
	}
	



}