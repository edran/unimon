package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class Pub extends Attack {

	public Pub() {
		super("Pub", "Mother of all bar fights");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(60);
		target.hungover();
		
	}

}
