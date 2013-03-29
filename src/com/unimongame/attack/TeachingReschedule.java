package com.unimongame.attack;

import com.unimongame.Unimon;

public class TeachingReschedule extends Attack {

	public TeachingReschedule() {
		super("TeachingReschedule", "Deal with it");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(45);
		
	}

}
