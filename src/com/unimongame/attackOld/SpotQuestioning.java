package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class SpotQuestioning extends Attack {

	public SpotQuestioning() {
		super("SpotQuestioning", "Total mind blank");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(40);
		target.confuse();
		
	}

}
