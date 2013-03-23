package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;

import com.unimongame.*;
import com.unimongame.attack.Attack;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ChooseUnimon extends JPanel implements ListSelectionListener, ActionListener{
	
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		private JList<String> listAttacks;
		private JList<String> listUnimons;
		private JScrollPane area1, area2, area3, area4;
		private JTextArea description, descriptionAttack;
		private LifeBar lifeBar;
		private JLabel hp, type;
		private JButton button;
		private Unimon selected;
		private int selectedNumber;
		private Attack selectedAttack;
		private ArrayList<Unimon> aliveUnimons;
		private ArrayList<Attack> unimonAttacks = new ArrayList<Attack>();
		private ArrayList<String> aliveUnimonsNames = new ArrayList<String>();

		private Player p;
	public ChooseUnimon(Player p) {
		super();
		setSize(500,400);
		setLocation(0,0);
		this.p = p;
		setLayout(null);
		init();
	}
	
	public void init()
	{
		aliveUnimons = p.getAliveUnimon();
		selected = null;
		selectedAttack = null;
		
		for(Unimon uni  : aliveUnimons){
			aliveUnimonsNames.add(uni.getName());
		}
		
		
		
		
		
		listUnimons = new JList<String>((String[]) aliveUnimonsNames.toArray(new String[0]));
        listUnimons.setFixedCellHeight(20);
        listUnimons.setFixedCellWidth(150);
        listUnimons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listUnimons.addListSelectionListener(this);
        
      
        listAttacks = new JList<String>(model);
        listAttacks.setVisibleRowCount(4);
        listAttacks.setFixedCellHeight(20);
        listAttacks.setFixedCellWidth(150);
        listAttacks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listAttacks.addListSelectionListener(this);
        listAttacks.setSize(150,80);
        listAttacks.setLocation(330, 270);
        this.add(listAttacks);
        

		area1 = new JScrollPane(listUnimons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		area1.setSize(150,300);
		area1.setLocation(20, 50);
		this.add(area1);
		
		
		description = new JTextArea();
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		area2 = new JScrollPane(description, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		area2.setSize(290,200);
		area2.setLocation(190,50);
		area2.setVisible(true);
		this.add(area2);
		
		descriptionAttack = new JTextArea();
		descriptionAttack.setEditable(false);
		descriptionAttack.setLineWrap(true);
		descriptionAttack.setWrapStyleWord(true);
		area3 = new JScrollPane(descriptionAttack, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		area3.setSize(290,200);
		area3.setLocation(190, 50);
		area3.setVisible(false);
		this.add(area3);
		
		lifeBar = new LifeBar(100,100);
		lifeBar.setLocation(190,270);
		lifeBar.setVisible(false);
		this.add(lifeBar);
		
		hp = new JLabel("" + "HP");
		hp.setSize(120, 15);
		hp.setLocation(190,300);
		hp.setVisible(false);
		this.add(hp);
		
		type = new JLabel("type");
		type.setSize(120, 15);
		type.setLocation(190,330);
		type.setVisible(false);
		this.add(type);
		
		button = new JButton("Select");
		button.setSize(150,20);
		button.setLocation(330, 365);
		button.addActionListener(this);
		this.add(button);
		
		
		
		
	}
	
	public void destroy(){
		aliveUnimons.removeAll(aliveUnimons);
		aliveUnimonsNames.removeAll(aliveUnimonsNames);
		this.setVisible(false);
		this.model.clear();
		this.removeAll();
		
	}
	
	@Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (e.getSource() == listUnimons) {
            		model.clear();
                   int selectedNumber = listUnimons.getSelectedIndex();
                    selected = aliveUnimons.get(selectedNumber);
                    description.setText(selected.getDescription());
                    area2.setVisible(true);
                    area3.setVisible(false);
                    unimonAttacks = selected.getAttacks();
                    
            		for(Attack attack : unimonAttacks) {
            			
            				int pos = model.getSize();
            				model.add(pos,attack.getName());
            				
            				//System.out.println("for attack : unimonATtakcs not null");
            			
            			}
                    
                    lifeBar.setValues(selected.getMaxHp(),selected.getHp());
                    lifeBar.setVisible(true);
                    hp.setText("MaxHp: "+selected.getMaxHp()+" HP");
                    hp.setVisible(true);
                    type.setText("type");
                    type.setVisible(true);
                    
                    
                } 
            
            if (e.getSource() == listAttacks) {
                for(int i = 0; i < 4; i++)
                {
                    if (i == listAttacks.getSelectedIndex())
                    {
                    	
                    selectedAttack = unimonAttacks.get(i);
                    descriptionAttack.setText(selectedAttack.getDescription());
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

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			
		}
		
	}




}