package com.unimongame.attack;

import com.unimongame.Unimon;

public class Coursework extends Attack {

	public Coursework() {
		super("Coursework", "No life");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
				
	}

}
