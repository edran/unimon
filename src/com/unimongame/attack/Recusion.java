package com.unimongame.attack;

import com.unimongame.Unimon;

public class Recusion extends Attack {

	public Recusion(String name, String description, String power) {
		super(name, description, power);
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.confuse();

	}

}
