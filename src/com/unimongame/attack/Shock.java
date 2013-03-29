package com.unimongame.attack;

import com.unimongame.Unimon;

public class Shock extends Attack {

	public Shock() {
		super("Shock", "Ooooooh my God");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(30);
		target.distract(1);
		
	}

}
