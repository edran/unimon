package com.unimongame.attack;

import com.unimongame.Unimon;

public class Logiclessness extends Attack {

	public Logiclessness() {
		super("Logiclessness", "There's nothing more confusing than the absence of logic.");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

