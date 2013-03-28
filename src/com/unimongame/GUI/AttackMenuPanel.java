package com.unimongame.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.unimongame.Player;

public class AttackMenuPanel extends JPanel implements ActionListener {
	private JButton attack1, attack2, attack3, attack4;
	private Player self;
	private FightGUI parent;

	public AttackMenuPanel(FightGUI parent, Player p) {
		this.self = p;
		this.parent = parent;
		// Buttons
		attack1 = new JButton(self.getActiveUnimon().getAttacks().get(0)
				.getName());
		attack1.setLocation(0, 0);
		attack1.setSize(150, 50);
		attack1.setToolTipText(self.getActiveUnimon().getAttacks().get(0)
				.getDescription());
		attack1.addActionListener(this);
		add(attack1);

		attack2 = new JButton(self.getActiveUnimon().getAttacks().get(1)
				.getName());
		attack2.setLocation(150, 0);
		attack2.setSize(150, 50);
		attack2.setToolTipText(self.getActiveUnimon().getAttacks().get(1)
				.getDescription());
		attack2.addActionListener(this);
		add(attack2);

		attack3 = new JButton(self.getActiveUnimon().getAttacks().get(2)
				.getName());
		attack3.setLocation(0, 50);
		attack3.setSize(150, 50);
		attack3.setToolTipText(self.getActiveUnimon().getAttacks().get(2)
				.getDescription());
		attack3.addActionListener(this);
		add(attack3);

		attack4 = new JButton(self.getActiveUnimon().getAttacks().get(3)
				.getName());
		attack4.setLocation(150, 50);
		attack4.setSize(150, 50);
		attack4.setToolTipText(self.getActiveUnimon().getAttacks().get(3)
				.getDescription());
		attack4.addActionListener(this);
		add(attack4);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == attack1) {
			 parent.doAttack(self.getActiveUnimon().getAttacks().get(0));
		
		 } else if (e.getSource() == attack2) {
			 parent.doAttack(self.getActiveUnimon().getAttacks().get(0));
		
		 } else if (e.getSource() == attack3) {
			 parent.doAttack(self.getActiveUnimon().getAttacks().get(0));
		
		 } else if (e.getSource() == attack4) {
			 parent.doAttack(self.getActiveUnimon().getAttacks().get(0));
		 }		
	}

}
