package com.unimongame.attack;

import com.unimongame.Unimon;

public class Series extends Attack {

	public Series() {
		super("Series", "It's a serious convergence");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(70);
		
	}

}
