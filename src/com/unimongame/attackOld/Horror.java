package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class Horror extends Attack {

	public Horror() {
		super("Horror", "It's soooo small");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(25);
		
	}

}
