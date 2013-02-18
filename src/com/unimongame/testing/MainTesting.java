package com.unimongame.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.unimongame.*;

public class MainTesting {
	public static ArrayList<Unimon> unimons = new ArrayList<Unimon>();
	private static Unimon[] onField = new Unimon[2];
	private static ArrayList<ArrayList<Unimon>> teams = new ArrayList<ArrayList<Unimon>>();
	private static ArrayList<Unimon> team1 = new ArrayList<Unimon>();
	private static ArrayList<Unimon> team2 = new ArrayList<Unimon>();
	public static Scanner scanIn = new Scanner(System.in);	



	public static void main(String[] args) {
		addUnimon();
		System.out.println("player 1, select Team");
		selectTeam(team1);
		selectTeam(team2);
		teams.add(team1);
		teams.add(team2);
		onField[0] = selectCurrentUnimon(teams.get(0));
		onField[1] = selectCurrentUnimon(teams.get(1));







	}

	public static void selectTeam(List<Unimon> team){
		int i =0;
		for(Unimon uni : unimons){
			System.out.print((i++)+") "+uni.getName());
		}

		while(true){
			int choice = -1;
			if(scanIn.hasNext()){
				choice = Integer.parseInt(scanIn.nextLine()); 
			}
			if(choice>=0){
				team.add(unimons.get(choice));

				System.out.println(unimons.get(choice).getName()+ " was added to your team!");
				System.out.println("choose again");
			}
			else{
				break;
			}
		}

	}

	public static void turn(){


	}

	public static Unimon selectCurrentUnimon(ArrayList<Unimon> team){
		
			System.out.println("send out unimon");

			int i =0;
			for(Unimon uni : team){
				System.out.print((i++)+") "+uni.getName());
			}
			Unimon returnUni = null;
			for(int x = -1;x<0;){
				int choice = -1;
				
				if(scanIn.hasNext()){
					choice = Integer.parseInt(scanIn.nextLine()); 
				}
				if(team.size()>choice){
					returnUni =  unimons.get(choice);
				}
			}
			return returnUni;
		

		

	}
	public static void addUnimon(){
		unimons.add(new Unimon("ScumBag Steve",new Type(),"will cheat up, mess troll you and generally fuck you over.",100));
		unimons.add(new Unimon("Luke McAuley",new Type(),"A beast",100));
		unimons.add(new Unimon("Soho", new Type(), "Ninjaa",150));
		unimons.add(new Unimon("Don", new Type(),"lolololol",90));

	}
}
