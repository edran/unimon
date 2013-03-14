package com.unimongame;

import java.util.ArrayList;
import java.util.HashMap;
import com.unimongame.attack.Attack;

public class UnimonLoader {
	public static void load(HashMap<String,Unimon> map){
		//while we have no parser.. dummy Unimon.
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		unimons.add(new Unimon("Profmon",new Type(),"he's not very nice.",100,20));
		unimons.add(new Unimon("Lukemon",new Type(),"A beast",100,60));
		unimons.add(new Unimon("Moronmon", new Type(), "Ninjaa",150,39));
		unimons.add(new Unimon("Duhmon", new Type(),"lolololol",90,40));
		for(Unimon u : unimons){
			map.put(u.getName(), u);
		}
		
	}
	



}
