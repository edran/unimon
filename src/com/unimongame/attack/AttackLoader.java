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

	public static void load(HashMap<String,Attack> map){
		//while we have no parser.. dummy Unimon.
		map.put("Punch",new Punch());
		
		
		
	}

}

