package com.unimongame;

import java.util.HashMap;

public class TypeLoader {
	
	public static HashMap<String,Type> load(){
		Type student = new Type("Student");
		Type professor = new Type("Professor");
		Type geek = new Type("Geek");
	
		professor.addStrength(student);
		professor.addWeakness(geek);
		
		student.addStrength(geek);
		student.addWeakness(professor);
		
		geek.addStrength(professor);
		geek.addWeakness(student);

		HashMap<String,Type> typemap = new HashMap<String,Type>();
		typemap.put("Student",student);
		typemap.put("Professor",professor );
		typemap.put("Geek", geek);
		return typemap;
		
		
	}
}
