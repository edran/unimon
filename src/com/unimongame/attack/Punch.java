package com.unimongame.attack;

import com.unimongame.Unimon;

public class Punch extends Attack {

	public Punch() {
		super("Punch", "It's a knuckle sandwich!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}
