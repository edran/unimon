package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;
import com.unimongame.*;
import com.unimongame.attack.Attack;
import com.unimongame.item.Item;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ItemPanel extends JPanel implements ListSelectionListener,
		ActionListener {

//	private DefaultListModel<String> model = new DefaultListModel<String>();
//	private DefaultListModel<String> unimonModel = new DefaultListModel<String>();
	private DefaultListModel model = new DefaultListModel();
	private DefaultListModel itemModel = new DefaultListModel();
//	private JList<String> listAttacks;
//	private JList<String> listUnimons;
	private JScrollPane listItemsArea;
	private JList listItems;
	private JTextArea description;
	private JButton button;
	private Item selected;
	private FightGUI parent;

	private Player p;

	public ItemPanel(Player p, FightGUI parent) {
		setSize(500, 400);
		setLocation(0, 0);
		this.p = p;
		this.parent = parent;
		setLayout(null);
		System.out.println("chooseUnimonPanel constructor");
	
//		listUnimons = new JList<String>(unimonModel);
		JLabel uniLabel = new JLabel("Items:");
		uniLabel.setSize(150, 20);
		uniLabel.setLocation(20, 25);
		add(uniLabel);
		listItems = new JList(itemModel);
		listItems.setFixedCellHeight(20);
		listItems.setFixedCellWidth(150);
		listItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listItems.addListSelectionListener(this);
		listItems.setSize(150, 300);
		listItems.setLocation(20, 50);
		listItemsArea = new JScrollPane(listItems,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		listItemsArea.setBackground(Color.blue);
		listItemsArea.setSize(150, 300);
		listItemsArea.setLocation(20, 50);
		add(listItemsArea);

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
		System.out.println("model size"+itemModel.size());
		for(Unimon uni :p.getAliveUnimon()){
			itemModel.add(itemModel.getSize(), uni.getName());
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