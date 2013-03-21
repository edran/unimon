package com.unimongame.GUI;

import java.awt.Color;

import javax.swing.JProgressBar;


@SuppressWarnings("serial")
public class LifeBar extends JProgressBar{
	
	public LifeBar (int max){
		super(0,max);
		setSize(100,20);
		this.setBackground(Color.BLUE);
		this.setForeground(Color.green);
	}
	
}