/**
 * 
 */
package com.unimongame.attack;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.*;
import com.unimongame.attack.Attack;

/**
 * TO DO, copied from UnimonLoader
 * WE NEED A PARSER.
 */

public class AttackLoader {

	public static void load(HashMap<String,Unimon> map){
		//while we have no parser.. dummy Unimon.
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		unimons.add(new Unimon("01","Profmon",new Type(),"he's not very nice.",100,20));
		unimons.add(new Unimon("02","Lukemon",new Type(),"A beast",100,60));
		unimons.add(new Unimon("03","Moronmon", new Type(), "Ninjaa",150,39));
		unimons.add(new Unimon("04","Duhmon", new Type(),"lolololol",90,40));
		for(Unimon u : unimons){
			map.put(u.getName(), u);
			
		}
		
		
		
	}

}

