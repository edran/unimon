package com.unimongame.attack;

import com.unimongame.Unimon;

public class Recursion extends Attack {

	public Recursion() {
		super("Recursion", "It confuses all players!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.confuse();

	}

}
