package com.unimongame.attack;

import com.unimongame.Unimon;

public class CompileError extends Attack {

	public CompileError() {
		super("CompileError", "OOPs");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(35);
		
	}

}
