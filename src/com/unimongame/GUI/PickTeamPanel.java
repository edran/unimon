package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;
import com.unimongame.*;
import com.unimongame.attack.Attack;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class PickTeamPanel extends JPanel implements ListSelectionListener,
		ActionListener {

	private DefaultListModel<String> model = new DefaultListModel<String>();
	private DefaultListModel<String> unimonModel = new DefaultListModel<String>();
	private JList<String> listAttacks, listUnimons, listTeam, listItems;
	private JTextArea description;
	private LifeBar lifeBar;
	private JLabel hp, type;
	private JButton button, clear, done;
	private Unimon selected;
	private Attack selectedAttack;
	private ArrayList<Attack> unimonAttacks = new ArrayList<Attack>();
	private ArrayList<Unimon> unimons = (ArrayList<Unimon>) UnimonLoader.load().values();
	private ArrayList<Unimon> team = new ArrayList<Unimon>();

	private Player p;
	private GameWindow window;

	public PickTeamPanel(GameWindow window, Player p) {
		setSize(500, 500);
		setLocation(0, 0);
		this.p = p;
		this.window = window;
		setLayout(null);
		System.out.println("chooseUnimonPanel constructor");
	
		//Jlists
		listUnimons = new JList<String>(unimonModel);
		listUnimons.setFixedCellHeight(20);
		listUnimons.setFixedCellWidth(150);
		listUnimons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUnimons.addListSelectionListener(this);
		listUnimons.setSize(150, 180);
		listUnimons.setLocation(20, 50);
		add(listUnimons);

		listAttacks = new JList<String>(model);
		listAttacks.setVisibleRowCount(4);
		listAttacks.setFixedCellHeight(20);
		listAttacks.setFixedCellWidth(150);
		listAttacks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAttacks.addListSelectionListener(this);
		listAttacks.setSize(150, 80);
		listAttacks.setLocation(330, 270);
		this.add(listAttacks);

		listTeam = new JList<String>(unimonModel);
		listTeam.setFixedCellHeight(20);
		listTeam.setFixedCellWidth(150);
		listTeam.setSize(150, 100);
		listTeam.setLocation(20, 400);
		add(listTeam);
		
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
			unimonModel.add(unimonModel.getSize(), uni.getCost() + " | " + uni.getName());
		}
		button.setVisible(true);
		listUnimons.setSelectedIndex(0);

	}
	
	public void reset() {
		System.out.println("reset");
		button.setVisible(false);
		unimonModel.clear();
		model.clear();
	}
	
	public void addToTeam(Unimon uni) {
		team.add(team.size(), uni);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false && listUnimons.getSelectedIndex()>=0) {
			System.out.println("unimon list value not changing");
			if (e.getSource() == listUnimons) {
				System.out.println("unimon list value change");
				model.clear();
				int selectedNumber = listUnimons.getSelectedIndex();
				selected = unimons.get(selectedNumber);
				description.setText(selected.getDescription());

				unimonAttacks = selected.getAttacks();

				for (Attack attack : unimonAttacks) {

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
			team.clear();
		} else if (e.getSource() == done) {
			
			for (Unimon uni : team) {
				p.addUnimon(uni);
			}
			
			window.teamPicked();
		}

	}

}