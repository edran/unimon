package com.unimongame.item;

import java.io.Serializable;

import com.unimongame.Unimon;
	public class Item implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7645292187167814985L;
		private int 	id;
		private String name;
		private String description;
		private int 	cost;
		private int	effect;
		private int	status;

		public Item(int id, String name, String description, int cost, int effect, int status){

			this.id = id;
			this.name = name;
			this.description = description;
			this.cost = cost;
			this.effect = effect;
			this.status = status;

		}

		/*
		public void doAttack(Unimon attacker, Unimon target){

			attacker.modifyHp(selfEffect);
			if(selfStatus == 3) attacker.distract();
			if(selfStatus == 5) attacker.hungover();
			if(selfStatus == 7) attacker.confuse();

			target.modifyHp(targetEffect);
			if(targetStatus == 3) target.distract();
			if(targetStatus == 5) target.hungover();
			if(targetStatus == 7) target.confuse();

		}
		 */

		public int getId(){
			return id;
		}

		public String getName(){
			return name;
		}

		public String getDescription(){
			return description;
		}
		
		public int getCost(){
			return cost;
		}

		public int getEffect(){
			return effect;
		}

		public int getStatus(){ 		//TODO: decide whether we want int or string
			return status;
		}

		public String toString(){
			return name + " : " + cost + " : " + description;
		}
		
		public void use(Unimon uni){
			uni.modifyHp(effect);
		}
	}
