package com.unimongame.attack;

import com.unimongame.Unimon;

public class Sneeze extends Attack {

	public Sneeze() {
		super("Sneeze", "Achooo");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.reduceHp(5);
		target.distract();
	
	}

}
