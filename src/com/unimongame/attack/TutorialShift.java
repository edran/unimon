package com.unimongame.attack;

import com.unimongame.Unimon;

public class TutorialShift extends Attack {

	public TutorialShift() {
		super("TutorialShift", "Surprise");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(40);
		target.confuse();
		
	}

}
