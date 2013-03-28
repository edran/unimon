![Alt text](https://raw.github.com/inf1op/unimon/master/Unimon%20Logo%20%28HQ%29.png "Optional title")
======
A University based battling game.

[POSSIBLE] Types of Unimon (so far):
- Informatics Student
- Science Student
- Humanities Student
- EUSA REP
- Professor

TODO - Basile
- Finish GUI
- Write the Menu
- Finish bag

TODO - Luke
- Linking the GUI and making the 1 Computer version
- MOAR randomness!

TODO - Nantas
- Write down the methods for the LAN
- Linking the methods with the Text based version.

TODO - ALL
- Write MOAR attacks!
- Write MOAR Unimons!
- 
- 
- 
-


ATTACK TEMPLATE - $attack.java /src/unimongame/attack

package com.unimongame.attack;

import com.unimongame.Unimon;

public class $attack_name extends Attack {

  public $attack_name() {
		super("$attack_name", "$Attack_description");
	}

	@Override
	public void doAttack(Unimon attacker, Unimon target) {
		target.$attack();
		$attack();

	}

}


