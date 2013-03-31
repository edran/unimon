package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;
import com.unimongame.*;
import com.unimongame.attack.Attack;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ChooseUnimonPanel extends JPanel implements ListSelectionListener,
		ActionListener {

//	private DefaultListModel<String> model = new DefaultListModel<String>();
//	private DefaultListModel<String> unimonModel = new DefaultListModel<String>();
	private DefaultListModel model = new DefaultListModel();
	private DefaultListModel unimonModel = new DefaultListModel();
//	private JList<String> listAttacks;
//	private JList<String> listUnimons;
	private JList listAttacks;
	private JList listUnimons;
	private JTextArea description;
	private LifeBar lifeBar;
	private JLabel hp, type;
	private JButton button;
	private Unimon selected;
	private Attack selectedAttack;
	private ArrayList<Attack> unimonAttacks = new ArrayList<Attack>();
	private FightGUI parent;

	private Player p;

	public ChooseUnimonPanel(Player p, FightGUI parent) {
		setSize(500, 400);
		setLocation(0, 0);
		this.p = p;
		this.parent = parent;
		setLayout(null);
		System.out.println("chooseUnimonPanel constructor");
	
//		listUnimons = new JList<String>(unimonModel);
		listUnimons = new JList(unimonModel);
		listUnimons.setFixedCellHeight(20);
		listUnimons.setFixedCellWidth(150);
		listUnimons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUnimons.addListSelectionListener(this);
		listUnimons.setSize(150, 300);
		listUnimons.setLocation(20, 50);
		add(listUnimons);

//		listAttacks = new JList<String>(model);
		listAttacks = new JList(model);
		listAttacks.setVisibleRowCount(4);
		listAttacks.setFixedCellHeight(20);
		listAttacks.setFixedCellWidth(150);
		listAttacks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAttacks.addListSelectionListener(this);
		listAttacks.setSize(150, 80);
		listAttacks.setLocation(330, 270);
		this.add(listAttacks);

		description = new JTextArea(
				"");
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

		type = new JLabel("type");
		type.setSize(120, 15);
		type.setLocation(190, 330);
		type.setVisible(false);
		this.add(type);

		button = new JButton("Select");
		button.setSize(150, 20);
		button.setLocation(330, 365);
		button.addActionListener(this);
		this.add(button);

		// sets the default selection
		updateValues();
	}

	public void updateValues(){
		System.out.println("updating values");
		System.out.println("model size"+unimonModel.size());
		for(Unimon uni :p.getAliveUnimon()){
			unimonModel.add(unimonModel.getSize(), uni.getName());
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false && listUnimons.getSelectedIndex()>=0) {
			System.out.println("unimon list value not changing");
			if (e.getSource() == listUnimons) {
				System.out.println("unimon list value change");
				model.clear();
				int selectedNumber = listUnimons.getSelectedIndex();
				selected = p.getAliveUnimon().get(selectedNumber);
				description.setText(selected.getDescription()); //Label for Unimon Description

				unimonAttacks = selected.getAttacks();

				for (Attack attack : unimonAttacks) {

					int pos = model.getSize();
					model.add(pos, attack.getName());


				}

				//TODO: Lifebar doesn't change value
				lifeBar.setValues(selected.getMaxHp(), selected.getHp());
				lifeBar.setVisible(true);
				hp.setText("MaxHp: " + selected.getMaxHp() + " HP");
				hp.setVisible(true);
				type.setText("type");
				type.setVisible(true);

			} else if (e.getSource() == listAttacks &&listAttacks.getSelectedIndex()>=0) {

				int i = listAttacks.getSelectedIndex();

				selectedAttack = unimonAttacks.get(i);
				
				/*Description Box thingie
				 * 
				 * - Description
				 * - +/- HP to you
				 * - make your unimon $status
				 * - +/- HP to your opponent
				 * - make your opponent $status 
				 */
				
				String descr = selectedAttack.getDescription() + "\n";
				String se = selectedAttack.getSelfEffect() + " to your unimon\n";
				String ss = "";
				System.out.println("ss = " + selectedAttack.getSelfStatus());
				if(selectedAttack.getSelfStatus() == 0) ss = "Doesn't alter your status\n";
				if(selectedAttack.getSelfStatus() == 3) ss = "Makes your unimon distracted\n";
				if(selectedAttack.getSelfStatus() == 5) ss = "Makes your unimon hungover\n";
				if(selectedAttack.getSelfStatus() == 7) ss = "Makes your unimon confused\n";
				
				String te = selectedAttack.getTargetEffect() + " to your opponent\n";
				String ts = "";
				System.out.println("ts = " + selectedAttack.getTargetStatus());
				if(selectedAttack.getTargetStatus() == 0) ts = "Doesn't alter opponent's status\n";
				if(selectedAttack.getTargetStatus() == 3) ts = "Makes your opponent distracted\n";
				if(selectedAttack.getTargetStatus() == 5) ts = "Makes your opponent hungover\n";
				if(selectedAttack.getTargetStatus() == 7) ts = "Makes your opponent confused\n";
				
				description.setText("# " + descr + 
									"# " + se + 
									"# " + ss +
									"# " + te +
									"# " + ts); // Item Description
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
			parent.unimonSelected(selected);
		}

	}

}