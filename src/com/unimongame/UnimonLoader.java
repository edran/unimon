package com.unimongame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import com.unimongame.parser.*;
import com.unimongame.attack.*;

public class UnimonLoader {
	public static void load(HashMap<String,Unimon> map){
		//while we have no parser.. dummy Unimon.
		ArrayList<Unimon> unimons = new ArrayList<Unimon>();
		String[][] d = unimonParser.getData();
		for (int i = 0; i < d.length; i++){
			unimons.add(new Unimon(d[i][0],d[i][1],new Type(),d[i][5],Integer.parseInt(d[i][3]),Integer.parseInt(d[i][4])));
		}
		/*
		unimons.add(new Unimon("01","Profmon",new Type(),"he's not very nice.",100,20));
		unimons.add(new Unimon("02","Lukemon",new Type(),"A beast",100,60));
		unimons.add(new Unimon("03","Moronmon", new Type(), "Ninjaa",150,39));
		unimons.add(new Unimon("04","Duhmon", new Type(),"lolololol",90,40));
		*/
		for(Unimon u : unimons){
			u.addAttack(new Punch());
			u.addAttack(new Recursion());
			map.put(u.getName(), u);
		}
		
	}
	



}
