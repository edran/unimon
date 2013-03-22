package com.unimongame.attack;

import com.unimongame.Unimon;

public class Recursion extends Attack {

	public Recursion() {
		super("Recursion", "confuses all players", null);
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.confuse();

	}

}
