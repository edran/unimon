/**
 * 
 */
package com.unimongame.item;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.Unimon;
import com.unimongame.attack.*;
import com.unimongame.parser.attackParser;
import com.unimongame.item.*;

/*
 * Get list from item_list
 * id,name,description,effect,status
 */

public class itemLoader {
	
	public static void load(HashMap<String,Item> map){
		
		boolean DEBUG = false;
		
		String[][] d = attackParser.getData();
		for (int i = 0; i < d.length; i++){
			
			//name is key, because of item_list
			map.put(d[i][0],new Item(Integer.parseInt(d[i][0]),d[i][1],d[i][2],Integer.parseInt(d[i][3]),
					Integer.parseInt(d[i][4])));
			
		}
	}
}