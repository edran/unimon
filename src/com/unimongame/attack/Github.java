package com.unimongame.attack;

import com.unimongame.Unimon;

public class Github extends Attack {

	public Github() {
		super("Github", "Commit change fail");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(70);
		
	}

}
