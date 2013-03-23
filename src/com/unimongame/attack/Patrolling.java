package com.unimongame.attack;

import com.unimongame.Unimon;

public class Patrolling extends Attack {

	public Patrolling() {
		super("Patrolling", "Controlling your exercises day and night");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

