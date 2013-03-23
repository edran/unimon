package com.unimongame.attack;

import com.unimongame.Unimon;

public class Salesman extends Attack {

	public Salesman() {
		super("Salesman", "It's a salesman, man!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

