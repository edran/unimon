package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class Polymorphism extends Attack {

	public Polymorphism() {
		super("Polymorphism", "CHANGE!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

