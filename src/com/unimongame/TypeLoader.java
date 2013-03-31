package com.unimongame;

import java.util.HashMap;

public class TypeLoader {
	
	public static HashMap<String,Type> load(){
		Type student = new Type("Student");
		Type professor = new Type("Professor");
	
		

		HashMap<String,Type> typemap = new HashMap<String,Type>();
		typemap.put("Student",student);
		typemap.put("Professor",professor );
		return typemap;
		
		
	}
}
