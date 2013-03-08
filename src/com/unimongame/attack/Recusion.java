package com.unimongame.attack;

import com.unimongame.Unimon;

public class Recusion extends Attack {

	public Recusion(String name, String description) {
		super(name, description);
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.confuse();

	}

}
