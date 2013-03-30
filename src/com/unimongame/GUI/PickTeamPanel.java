package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;
import com.unimongame.*;
import com.unimongame.attack.Attack;
import com.unimongame.item.Item;
import com.unimongame.item.itemLoader;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class PickTeamPanel extends JPanel implements ListSelectionListener,
		ActionListener {

	private DefaultListModel<String> model = new DefaultListModel<String>();
	private DefaultListModel<String> unimonModel = new DefaultListModel<String>();
	private DefaultListModel<String> teamModel = new DefaultListModel<String>();
	private DefaultListModel<String> itemsModel = new DefaultListModel<String>();
	private DefaultListModel<String> itemsSelectedModel = new DefaultListModel<String>();
	
	private JScrollPane listUnimonsArea, listTeamArea, listItemsArea, listSelectedItemsArea;
	
	private JList<String> listAttacks, listUnimons, listItems, listTeam, listSelectedItems;
	private JTextArea description;
	private LifeBar lifeBar;
	private JLabel moneyLabel, hp, type;
	private JButton button, button2, clear, done;
	private Unimon selected;
	private Attack selectedAttack;
	private Item selectedItem;
	private ArrayList<Attack> unimonAttacks = new ArrayList<Attack>();
	private ArrayList<Unimon> unimons = new ArrayList<Unimon>();
	private ArrayList<Unimon> team = new ArrayList<Unimon>();
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Item> itemsSelected = new ArrayList<Item>();
	private Player p;
	private GameWindow window;
	
	public PickTeamPanel(GameWindow window, Player p) {
		setSize(500, 500);
		setLocation(0, 0);
		this.p = p;
		this.window = window;
		setLayout(null);
		
		Collection<Unimon> c1 = UnimonLoader.load().values();
		for(Unimon uni : c1){
			unimons.add(uni);
		}
		
		Collection<Item> c2 = itemLoader.load().values();
		for(Item item : c2){
			items.add(item);
			System.out.println(item);
		}
		
		//Unimon choosing list
		JLabel uniLabel = new JLabel("Unimons:");
		uniLabel.setSize(150, 20);
		uniLabel.setLocation(20, 25);
		add(uniLabel);
		listUnimons = new JList<String>(unimonModel);
		listUnimons.setFixedCellHeight(20);
		listUnimons.setFixedCellWidth(150);
		listUnimons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUnimons.addListSelectionListener(this);
		listUnimonsArea = new JScrollPane(listUnimons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listUnimonsArea.setBackground(Color.blue);
		listUnimonsArea.setSize(150, 185);
		listUnimonsArea.setLocation(20, 50);
		add(listUnimonsArea);

		//Attack choosing list
		JLabel attackLabel = new JLabel("Attacks:");
		attackLabel.setSize(150, 20);
		attackLabel.setLocation(330, 195);
		add(attackLabel);
		listAttacks = new JList<String>(model);
		listAttacks.setVisibleRowCount(4);
		listAttacks.setFixedCellHeight(20);
		listAttacks.setFixedCellWidth(150);
		listAttacks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAttacks.addListSelectionListener(this);
		listAttacks.setSize(150, 80);
		listAttacks.setLocation(330, 220);
		this.add(listAttacks);
		
		//Items choosing list
		JLabel itemsLabel = new JLabel("Items:");
		itemsLabel.setSize(150,20);
		itemsLabel.setLocation(20, 245);
		add(itemsLabel);
		listItems = new JList<String>(itemsModel);
		listItems.setFixedCellHeight(20);
		listItems.setFixedCellWidth(150);
		listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItems.addListSelectionListener(this);
		listItemsArea = new JScrollPane(listItems, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listItemsArea.setSize(150, 95);
		listItemsArea.setLocation(20, 270);
		add(listItemsArea);

		//Team setup
		JLabel teamLabel = new JLabel("Team and selected items:");
		teamLabel.setSize(150,20);
		teamLabel.setLocation(20,375);
		add(teamLabel);
		listTeam = new JList<String>(teamModel);
		listTeam.setFixedCellHeight(20);
		listTeam.setFixedCellWidth(150);
		listTeamArea = new JScrollPane(listTeam, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listTeamArea.setSize(150, 95);
		listTeamArea.setLocation(20, 400);
		add(listTeamArea);
	
		listSelectedItems = new JList<String>(itemsSelectedModel);
		listSelectedItems.setFixedCellHeight(20);
		listSelectedItems.setFixedCellWidth(150);
		listSelectedItemsArea = new JScrollPane(listSelectedItems, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listSelectedItemsArea.setSize(150, 95);
		listSelectedItemsArea.setLocation(190, 400);
		add(listSelectedItemsArea);
		
		//Descriptions
		JLabel desLabel = new JLabel("Description:");
		desLabel.setSize(290, 20);
		desLabel.setLocation(190, 25);
		add(desLabel);
		description = new JTextArea("");
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setSize(290, 130);
		description.setBackground(Color.white);
		description.setLocation(190, 50);
		add(description);

		lifeBar = new LifeBar(100, 100);
		lifeBar.setLocation(190, 220);
		lifeBar.setVisible(false);
		this.add(lifeBar);

		hp = new JLabel("" + "HP");
		hp.setSize(120, 15);
		hp.setLocation(190, 250);
		hp.setVisible(false);
		this.add(hp);

		type = new JLabel("Type");
		type.setSize(120, 15);
		type.setLocation(190, 280);
		type.setVisible(false);
		this.add(type);
		
		//Money left
		moneyLabel = new JLabel("You have £" + p.getMoney() + " left.");
		moneyLabel.setSize(200, 20);
		moneyLabel.setLocation(190, 320);
		this.add(moneyLabel);
		
		//Buttons
		button = new JButton("Select Unimon");
		button.setSize(120, 20);
		button.setLocation(350, 365);
		button.addActionListener(this);
		this.add(button);
		
		button2 = new JButton("Select Item");
		button2.setSize(120, 20);
		button2.setLocation(210, 365);
		button2.addActionListener(this);
		this.add(button2);
		
		clear = new JButton("Clear");
		clear.setSize(120, 20);
		clear.setLocation(350, 420);
		clear.addActionListener(this);
		this.add(clear);
		
		done = new JButton("Done");
		done.setSize(120, 20);
		done.setLocation(350, 460);
		done.addActionListener(this);
		this.add(done);
		
		// sets the default selection
		updateValues();
	}
	public String littleString(int x) {
		
		if (x<100) {
			return "   | ";
		} else {
			return " | ";
		}
	}
	public void updateValues(){
		
		for(Unimon uni : unimons){
			unimonModel.add(unimonModel.getSize(), "£" + uni.getCost() + littleString(uni.getCost()) + uni.getName());
		}
		
		for(Unimon uni : team) {
			teamModel.add(teamModel.getSize(), (teamModel.getSize()+1) + ": " + uni.getName());
		}
		
		for(Item item : items) {
			itemsModel.add(itemsModel.getSize(), "£" + item.getCost() + littleString(item.getCost()) + item.getName());
		}
		
		for(Item item : itemsSelected) {
			itemsSelectedModel.add(itemsSelectedModel.getSize(), (itemsSelectedModel.getSize()+1) + ": " + item.getName());
		}
		
		button.setVisible(true);
		button2.setVisible(true);
		
		moneyLabel.setText("You have £" + p.getMoney() + " left.");
	}
	
	public void reset() {
		button.setVisible(false);
		unimonModel.clear();
		model.clear();
		teamModel.clear();
		itemsModel.clear();	
		itemsSelectedModel.clear();
	}
	
	public void addToTeam(Unimon uni) {
		team.add(team.size(), uni);
		reset();
		updateValues();
	}
	
	public void addToItems(Item item) {
		itemsSelected.add(itemsSelected.size(), item);
		reset();
		updateValues();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			if (e.getSource() == listUnimons && listUnimons.getSelectedIndex()>=0) {

				int selectedNumber = listUnimons.getSelectedIndex();
				selected = unimons.get(selectedNumber);

				description.setText(selected.getDescription());

				unimonAttacks = selected.getAttacks();
				
				model.clear();
				for (Attack attack : unimonAttacks) {
					model.add(model.getSize(), attack.getName());
				}

				lifeBar.setValues(selected.getMaxHp(), selected.getHp());
				lifeBar.setVisible(true);
				hp.setText("MaxHp: " + selected.getMaxHp() + " HP");
				hp.setVisible(true);
				type.setText("Type");
				type.setVisible(true);

			} else if (e.getSource() == listAttacks && listAttacks.getSelectedIndex()>=0) {

				int i = listAttacks.getSelectedIndex();

				selectedAttack = unimonAttacks.get(i);
				description.setText(selectedAttack.getDescription());

			} else if (e.getSource() == listItems && listItems.getSelectedIndex()>=0) {
				
				int j = listItems.getSelectedIndex();

				selectedItem = items.get(j);
				description.setText(selectedItem.getDescription());
			} else {
		
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			if (p.getMoney()-selected.getCost() >= 0) {
			p.spendMoney(selected.getCost());
			addToTeam(selected);
			}			
	
		} else if (e.getSource() == button2) {
			if(p.getMoney()-selectedItem.getCost() >= 0) {
			p.spendMoney(selectedItem.getCost());
			addToItems(selectedItem);
			}

		} else if (e.getSource() == clear) {
			reset();
			team.clear();
			itemsSelected.clear();
			p.restoreMoney();
			updateValues();
		} else if (e.getSource() == done) {
			
			for (Unimon uni : team) {
				p.addUnimon(uni);
			}
			p.setActiveUnimon(team.get(0));
			System.out.println("done clicked");
			window.teamPicked(p);
			
		}

	}

}