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
	
	private JScrollPane listUnimonsArea, listTeamArea, listItemsArea;
	
	private JList<String> listAttacks, listUnimons, listTeam, listItems;
	private JTextArea description;
	private LifeBar lifeBar;
	private JLabel hp, type;
	private JButton button, clear, done;
	private Unimon selected;
	private Attack selectedAttack;
	private ArrayList<Attack> unimonAttacks = new ArrayList<Attack>();
	private ArrayList<Unimon> unimons = new ArrayList<Unimon>();
	private ArrayList<Unimon> team = new ArrayList<Unimon>();
	//private ArrayList<Item> items = (ArrayList<Item>) itemLoader.load().values();
	private Player p;
	private GameWindow window;

	public PickTeamPanel(GameWindow window, Player p) {
		setSize(500, 500);
		setLocation(0, 0);
		this.p = p;
		this.window = window;
		setLayout(null);
		System.out.println("chooseUnimonPanel constructor");
		
		Collection<Unimon> c = UnimonLoader.load().values();
		for(Unimon uni : c){
			System.out.println(uni.toString());
			unimons.add(uni);
		}
		System.out.println("first uniomon in unimons :"+unimons.get(0).toString());
		
		//Jlists
		listUnimons = new JList<String>(unimonModel);
		listUnimons.setFixedCellHeight(20);
		listUnimons.setFixedCellWidth(150);
		listUnimons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUnimons.addListSelectionListener(this);
		listUnimonsArea = new JScrollPane(listUnimons, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listUnimonsArea.setBackground(Color.blue);
		listUnimonsArea.setSize(150, 180);
		listUnimonsArea.setLocation(20, 50);
		add(listUnimonsArea);

		listAttacks = new JList<String>(model);
		listAttacks.setVisibleRowCount(4);
		listAttacks.setFixedCellHeight(20);
		listAttacks.setFixedCellWidth(150);
		listAttacks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAttacks.addListSelectionListener(this);
		listAttacks.setSize(150, 80);
		listAttacks.setLocation(330, 270);
		this.add(listAttacks);

		listTeam = new JList<String>(teamModel);
		listTeam.setFixedCellHeight(20);
		listTeam.setFixedCellWidth(150);
		listTeamArea = new JScrollPane(listTeam, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listTeamArea.setSize(150, 100);
		listTeamArea.setLocation(20, 400);
		add(listTeamArea);
	
		listItems = new JList<String>(itemsModel);
		listItems.setFixedCellHeight(20);
		listItems.setFixedCellWidth(150);
		listItems.setSize(150, 100);
		listItems.setLocation(20, 400);
		listItemsArea = new JScrollPane(listItems, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listItemsArea.setSize(150, 100);
		listItemsArea.setLocation(20, 400);
		add(listItemsArea);
		
		//Descriptions
		description = new JTextArea("");
		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);
		description.setSize(290, 200);
		description.setBackground(Color.white);
		description.setLocation(190, 50);
		add(description);

		lifeBar = new LifeBar(100, 100);
		lifeBar.setLocation(190, 270);
		lifeBar.setVisible(false);
		this.add(lifeBar);

		hp = new JLabel("" + "HP");
		hp.setSize(120, 15);
		hp.setLocation(190, 300);
		hp.setVisible(false);
		this.add(hp);

		type = new JLabel("Type");
		type.setSize(120, 15);
		type.setLocation(190, 330);
		type.setVisible(false);
		this.add(type);

		button = new JButton("Select");
		button.setSize(150, 20);
		button.setLocation(330, 365);
		button.addActionListener(this);
		this.add(button);
		
		clear = new JButton("Clear");
		clear.setSize(150, 20);
		clear.setLocation(330, 420);
		clear.addActionListener(this);
		this.add(clear);
		
		done = new JButton("Done");
		done.setSize(150, 20);
		done.setLocation(330, 460);
		done.addActionListener(this);
		this.add(done);
		
		// sets the default selection
		updateValues();
	}

	public void updateValues(){
		
		System.out.println("updating values");
		System.out.println("model size"+unimonModel.size());
		for(Unimon uni : unimons){
			System.out.println(uni.toString());
			unimonModel.add(unimonModel.getSize(), uni.getCost() + " | " + uni.getName());
		}
		
		for(Unimon uni : team) {
			teamModel.add(teamModel.getSize(), (teamModel.getSize()+1) + ": " + uni.getName());
		}
//		
//		for(Item item : items) {
//			itemsModel.add(itemsModel.getSize(), (itemsModel.getSize()+1) + ": " + item.getName());
//		}
		
		button.setVisible(true);

	}
	
	public void reset() {
		System.out.println("reset");
		button.setVisible(false);
		unimonModel.clear();
		model.clear();
		teamModel.clear();
		
		
	}
	
	public void addToTeam(Unimon uni) {
		team.add(team.size(), uni);
		reset();
		updateValues();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false && listUnimons.getSelectedIndex()>=0) {
			System.out.println("unimon list value not changing");
			if (e.getSource() == listUnimons) {
				System.out.println("unimon list value change");
				model.clear();
				int selectedNumber = listUnimons.getSelectedIndex();
				System.out.println("selected number"+selectedNumber);
				selected = unimons.get(selectedNumber);
				System.out.println("selected unimon = "+selected.toString());
				description.setText(selected.getDescription());

				unimonAttacks = selected.getAttacks();
				System.out.println("selected unimon attacks"+selected.getAttacks().get(0));
				System.out.println("unimonAttacks"+unimonAttacks.get(0));
				
				for (Attack attack : unimonAttacks) {
					System.out.println(attack);
					int pos = model.getSize();
					model.add(pos, attack.getName());


				}

				lifeBar.setValues(selected.getMaxHp(), selected.getHp());
				lifeBar.setVisible(true);
				hp.setText("MaxHp: " + selected.getMaxHp() + " HP");
				hp.setVisible(true);
				type.setText("type");
				type.setVisible(true);

			} else if (e.getSource() == listAttacks &&listAttacks.getSelectedIndex()>=0) {

				int i = listAttacks.getSelectedIndex();

				selectedAttack = unimonAttacks.get(i);
				description.setText(selectedAttack.getDescription());
				System.out.println("selected Attack = "
						+ selectedAttack.getName());
			}
			else{
				System.out.println("source ="+e.getSource().toString());
		
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			addToTeam(selected);
		} else if (e.getSource() == clear) {
			reset();
			team.clear();
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