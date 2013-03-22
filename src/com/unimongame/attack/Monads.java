package com.unimongame.attack;

import com.unimongame.Unimon;

public class Monads extends Attack {

	public Monads() {
		super("Monads", "Adds complexity and makes the unimon feeling like a boss");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.increaseHp(30);

	}

}
