package com.unimongame.attack;

import com.unimongame.Unimon;

public class Jagerbomb extends Attack {

	public Jagerbomb() {
		super("Jagerbomb", "drruunnnk",null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(10);
		target.hungover();

	}

}
