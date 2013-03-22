package com.unimongame.attack;

import com.unimongame.Unimon;

public class Punch extends Attack {

	public Punch() {
		super("Punch", "knuckle sandwich", null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}
