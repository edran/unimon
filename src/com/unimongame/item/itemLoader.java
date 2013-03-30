/**
 * 
 */
package com.unimongame.item;

import java.util.ArrayList;
import java.util.HashMap;

import com.unimongame.parser.*;
import com.unimongame.item.*;

/*
 * Get list from item_list
 * id,name,description,effect,status
 */

public class itemLoader {
	
	public static HashMap<String, Item> load(){
		
		HashMap<String,Item> map = new HashMap<String,Item>();
		boolean DEBUG = false;
		
		String[][] d = itemParser.getData();
		for (int i = 0; i < d.length; i++){
			
			//name is key, because of item_list
			map.put(d[i][0],new Item(Integer.parseInt(d[i][0]),d[i][1],d[i][2],Integer.parseInt(d[i][3]),
					Integer.parseInt(d[i][4]), Integer.parseInt(d[i][5])));
			
		}
		return map;
	}
	
}