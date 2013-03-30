package com.unimongame.attack;

import com.unimongame.Unimon;

public class TimeDistortion extends Attack {

	public TimeDistortion() {
		super("Time Distortion", "It confuses all players!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.confuse();
		target.distract();

	}

}

