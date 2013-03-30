package com.unimongame.attackOld;

import com.unimongame.Unimon;

public class EvilSyntax extends Attack {

	public EvilSyntax() {
		super("Evil Syntax", "It's just Evil Syntax");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(50);
	}

}

