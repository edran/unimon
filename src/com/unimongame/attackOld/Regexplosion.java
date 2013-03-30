package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class Regexplosion extends Attack {

	public Regexplosion() {
		super("Regexplosion", "Now you have got two problems.");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

