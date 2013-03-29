package com.unimongame.attack;

import com.unimongame.Unimon;

public class Haskell extends Attack {

	public Haskell() {
		super("Haskell", "Takes no hostages");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(100);
		// only use attack once
	}

}
