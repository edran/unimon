package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class LastMinCram extends Attack {

	public LastMinCram() {
		super("LastMinCram", "Redbull haze - it doesn't give you wings");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(20);
				
	}

}
