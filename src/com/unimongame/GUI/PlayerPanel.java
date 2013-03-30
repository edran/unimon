package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JPanel;
import com.unimongame.Player;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel {
	public final static Color BACKGROUND_COLOR = new Color(0, 0, 0, 64); // transparent
	public final static Point IMAGE_LOCATOIN = new Point(0,0);
	public final static Point INFO_LOCATOIN = new Point(280,20);
	private static final Point PANEL_LOCATION = new Point(0,200);
	private Player player;
	ImagePanel imgPanel;
	InfoPanel infoPanel;

	public PlayerPanel(Player player) {
		// setup variables
		this.player = player;

		// panel properties
		setLayout(null);
		setSize(500, 200);
		setBackground(BACKGROUND_COLOR);
		setLocation(getPanelLocation());
		setVisible(true);
		
		// add icon
		setIcon();
		imgPanel.setSize(152, 200);
		imgPanel.setLocation(getIconLocation());
		imgPanel.setBackground(BACKGROUND_COLOR);
		imgPanel.setVisible(true);
		add(imgPanel);

		// info Panel
		infoPanel = new InfoPanel(player);
		infoPanel.setLocation(getInfoPanelLocation());
		add(infoPanel);
	}

	protected Point getPanelLocation(){
		return PANEL_LOCATION;
	}
	protected Point getIconLocation(){
		return IMAGE_LOCATOIN;
	}
	
	protected Point getInfoPanelLocation(){
		return INFO_LOCATOIN;
	}
	
	public void updateStats(Player player) {
		this.player = player;
		changeUnimon();
		infoPanel.updateInfo(player);
	}

	public void changeUnimon() {
		infoPanel.updateInfo(player);
		imgPanel.updateImg(getImagePath());
	}

	private String getImagePath() {
		return "resources/img/unimon/" + player.getActiveUnimon().getName() + ".png";
	}

	private void setIcon() {
		imgPanel = new ImagePanel(getImagePath());
	}

}
