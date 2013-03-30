package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class Rambling extends Attack {

	public Rambling() {
		super("Rambling", "Blah, blah, blah...");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(20);
		target.confuse();
		
	}

}
