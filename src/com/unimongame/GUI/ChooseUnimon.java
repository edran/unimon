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
	

		public JList<String> listUnimons, listAttacks;
		public JScrollPane area1, area2, area3;
		public JTextArea description, descriptionAttack;
		public Unimon selected;
		public Attack selectedAttack;
		public ArrayList<Unimon> aliveUnimons;
		public ArrayList<Attack> unimonAttacks;
		public ArrayList<String> aliveUnimonsNames, unimonAttacksNames;
		
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

		area1 = new JScrollPane(listUnimons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		area1.setSize(150,300);
		area1.setLocation(20, 50);
		this.add(area1);
		
		
		description = new JTextArea(selected.getDescription());
		area2 = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		area2.setSize(260,200);
		area2.setLocation(220,50);
		area2.setVisible(true);
		this.add(area2);
		
		descriptionAttack = new JTextArea(selectedAttack.getDescription());
		area3 = new JScrollPane(descriptionAttack, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		area3.setSize(150,80);
		area3.setLocation(430, 270);
		area3.setVisible(false);
		this.add(area3);
		
		
		
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