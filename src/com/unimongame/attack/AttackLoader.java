/**
 * 
 */
package com.unimongame.attack;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.attack.*;

/**
 * TO DO, copied from UnimonLoader
 * WE NEED A PARSER.
 */

public class AttackLoader {

	public static void load(HashMap<String,Attack> map){
		//while we have no parser.. dummy Unimon.
		map.put("Punch",new Punch());
		map.put("Jagerbomb", new Jagerbomb());
		map.put("Recursion", new Recursion());
		map.put("Monads", new Monads());
		map.put("Time Distortion", new TimeDistortion());
		map.put("Feline Scratch", new FelineScratch());
		map.put("Locgiclessness", new Logiclessness());
		map.put("Nesting", new Nesting());
		map.put("Patrolling", new Patrolling());
		map.put("Ploymorphism", new Polymorphism());
		map.put("Regexplosion",new Regexplosion());
		map.put("Salesman",new Salesman());
		map.put("TreeDrawing",new TreeDrawing());

	}

}

