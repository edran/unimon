package com.unimongame;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.attack.Attack;

public class UnimonLoader {
	public static void load(HashMap<String,Unimon> map){
		//while we have no parser.. dummy Unimon.
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		unimons.add(new Unimon("ScumBag Steve",new Type(),"hes not very nice.",100,20));
		unimons.add(new Unimon("Luke McAuley",new Type(),"A beast",100,60));
		unimons.add(new Unimon("Soho", new Type(), "Ninjaa",150,39));
		unimons.add(new Unimon("Don", new Type(),"lolololol",90,40));
		for(Unimon u : unimons){
			map.put(u.getName(), u);
		}
		
	}
	



}
