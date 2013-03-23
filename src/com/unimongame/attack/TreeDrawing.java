package com.unimongame.attack;

import com.unimongame.Unimon;

public class TreeDrawing extends Attack {

	public TreeDrawing() {
		super("Tree Drawing", "Be ecologic!");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

