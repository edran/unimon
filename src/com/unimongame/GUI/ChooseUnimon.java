package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.unimongame.*;
import com.unimongame.attack.Attack;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChooseUnimon extends JPanel implements ListSelectionListener{
	

		private JList<String> listUnimons, listAttacks;
		private JScrollPane area1, area2, area3, area4;
		private JTextArea description, descriptionAttack;
		private LifeBar lifeBar;
		private JLabel hp, type;
		private Unimon selected;
		private Attack selectedAttack;
		private ArrayList<Unimon> aliveUnimons;
		private ArrayList<Attack> unimonAttacks;
		private ArrayList<String> aliveUnimonsNames, unimonAttacksNames;
		
	public ChooseUnimon(Player p) {
		super();
		setSize(500,400);
		setLocation(0,0);
		setLayout(null);
		
		aliveUnimons = p.getAliveUnimon();
		
		for(Unimon uni  : aliveUnimons){
			aliveUnimonsNames.add(uni.getName());
		}
		
		for(int i=0; i<4; i++) {
		unimonAttacks.add(selected.getAttacks().get(i));
		}
		
		for(Attack attack : unimonAttacks) {
		unimonAttacksNames.add(attack.getName());
		}
		
		listUnimons = new JList<String>((String[]) aliveUnimonsNames.toArray());
        listUnimons.setFixedCellHeight(20);
        listUnimons.setFixedCellWidth(150);
        listUnimons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listUnimons.addListSelectionListener(this);
        
        listAttacks = new JList<String>((String[]) unimonAttacksNames.toArray());
        listAttacks.setFixedCellHeight(20);
        listAttacks.setFixedCellWidth(150);
        listAttacks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listAttacks.addListSelectionListener(this);
        listAttacks.setSize(150,80);
        listAttacks.setLocation(330, 270);
        this.add(listAttacks);
        

		area1 = new JScrollPane(listUnimons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		area1.setSize(150,300);
		area1.setLocation(20, 50);
		this.add(area1);
		
		
		description = new JTextArea(selected.getDescription());
		area2 = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		area2.setSize(290,200);
		area2.setLocation(190,50);
		area2.setVisible(true);
		this.add(area2);
		
		descriptionAttack = new JTextArea(selectedAttack.getDescription());
		area3 = new JScrollPane(descriptionAttack, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		area3.setSize(290,200);
		area3.setLocation(190, 50);
		area3.setVisible(false);
		this.add(area3);
		
		lifeBar = new LifeBar(selected.getMaxHp(),selected.getHp());
		lifeBar.setLocation(190,270);
		this.add(lifeBar);
		
		hp = new JLabel(selected.getMaxHp() + "HP");
		hp.setSize(120, 15);
		hp.setLocation(190,300);
		
		type = new JLabel(selected.getType().toString());
		type.setSize(120, 15);
		type.setLocation(190,330);
		
		
		
		
	}
	
	@Override
    public void valueChanged(ListSelectionEvent e) {

        if (e.getValueIsAdjusting() == false) {
            if (e.getSource() == listUnimons) {
                for(int i = 0; i < aliveUnimons.size(); i++)
                {
                    if (i == listUnimons.getSelectedIndex())
                    {
                    selected = aliveUnimons.get(i);
                    area2.setVisible(true);
                    area3.setVisible(false);
                    }
                    else
                    {
                    
                    }
                } 
            }
            if (e.getSource() == listAttacks) {
                for(int i = 0; i < 4; i++)
                {
                    if (i == listAttacks.getSelectedIndex())
                    {
                    selectedAttack = unimonAttacks.get(i);
                    area2.setVisible(false);
                    area3.setVisible(true);
                    }
                    else
                    {
                    
                    }
                } 
            }
        }
    }




}