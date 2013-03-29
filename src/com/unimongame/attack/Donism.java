package com.unimongame.attack;

import com.unimongame.Unimon;

public class Donism extends Attack {

	public Donism() {
		super("Donism", "Whoosh");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(60);
		
	}

}
