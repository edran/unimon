package com.unimongame.attack;

import com.unimongame.Unimon;

public class FelineScratch extends Attack {

	public FelineScratch() {
		super("Feline Scratch", "Throw a CATNULLEXCEPTION");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
		

	}

}

