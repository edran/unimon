package com.unimongame;

import java.util.ArrayList;
import java.util.HashMap;
import com.unimongame.attack.Attack;
import com.unimongame.attack.Punch;
import com.unimongame.attack.Recursion;

public class UnimonLoader {
	public static void load(HashMap<String,Unimon> map){
		//while we have no parser.. dummy Unimon.
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		unimons.add(new Unimon("01","Profmon",new Type(),"he's not very nice.",100,20));
		unimons.add(new Unimon("02","Lukemon",new Type(),"A beast",100,60));
		unimons.add(new Unimon("03","Moronmon", new Type(), "Ninjaa",150,39));
		unimons.add(new Unimon("04","Duhmon", new Type(),"lolololol",90,40));
		for(Unimon u : unimons){
			u.addAttack(new Punch());
			u.addAttack(new Recursion());
			map.put(u.getName(), u);
		}
		
	}
	



}
