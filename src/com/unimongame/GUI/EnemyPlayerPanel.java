package com.unimongame.GUI;

import java.awt.Point;

import com.unimongame.Player;

@SuppressWarnings("serial")
public class EnemyPlayerPanel extends PlayerPanel {
	public final static Point IMAGE_LOCATOIN = new Point(348, 0);
	public final static Point INFO_LOCATOIN = new Point(20,20);
	private static final Point PANEL_LOCATION = new Point(0,0);

	public EnemyPlayerPanel(Player player) {
		super(player);
	}
	
	protected Point getIconLocation(){
		return IMAGE_LOCATOIN;
	}
	
	protected Point getInfoPanelLocation(){
		return INFO_LOCATOIN;
	}
	
	protected Point getPanelLocation(){
		return PANEL_LOCATION;
	}

}
