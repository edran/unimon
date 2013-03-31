package com.unimongame.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener {
	private JButton attack;
	private JButton bag;
	private JButton unimons;
	private JButton abandon;
	private FightGUI parent;

	public MenuPanel(FightGUI parent) {
		
		this.parent = parent;
		
		setLayout(null);
		setLocation(300, 400);
		setSize(200, 100);
		
		attack = new JButton("Attack");
		attack.setLocation(0, 0);
		attack.setSize(100, 50);
		attack.setBackground(Color.lightGray);
		attack.setForeground(Color.darkGray);
		attack.setVisible(true);
		attack.addActionListener(this);
		add(attack);

		bag = new JButton("Bag");
		bag.setLocation(100, 0);
		bag.setSize(100, 50);
		bag.setBackground(Color.lightGray);
		bag.setForeground(Color.darkGray);
		bag.setVisible(true);
		bag.addActionListener(this);
		add(bag);

		unimons = new JButton("Unimons");
		unimons.setLocation(0, 50);
		unimons.setSize(100, 50);
		unimons.setBackground(Color.lightGray);
		unimons.setForeground(Color.darkGray);
		unimons.setVisible(true);
		unimons.addActionListener(this);
		add(unimons);
		
		abandon = new JButton("Give up!");
		abandon.setLocation(100, 50);
		abandon.setSize(100, 50);
		abandon.setBackground(Color.lightGray);
		abandon.setForeground(Color.darkGray);
		abandon.addActionListener(this);
		abandon.setVisible(true);
		add(abandon);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == attack) {
			parent.showAttacksClicked();
		} else if (e.getSource() == bag) {
			parent.showBagClicked();
		} else if (e.getSource() == unimons) {
			parent.chooseUnimonClicked();
		} else if (e.getSource() == abandon) {
			parent.abandonClicked();
		}
	}

}
