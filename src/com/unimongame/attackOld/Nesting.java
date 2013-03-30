package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class Nesting extends Attack {

	public Nesting() {
		super("Nesting", "You gotta be good with your brackets!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

