package com.unimongame.GUI;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class LifeBar extends JProgressBar {

	private int max;
	private int value;

	public LifeBar(int max, int value) {
		super(0, max);
		this.max = max;
		this.value = value;
		setSize(120, 15);
		setValue(value);
		

		setUI(new BasicProgressBarUI() {
			protected Color getSelectionBackground() {
				return Color.darkGray;
			}

			protected Color getSelectionForeground() {
				return Color.darkGray;
			}
		});
	}

	public void setValues(int max, int value) {
		setMaximum(max);
		setString(value + "");
		setValue(value);

	}

	@Override
	public void setValue(int x) {
		value = x;
		double ratio = (double) value / (double) max;
		if (ratio < 0.33) {
			this.setForeground(Color.RED);
		} else if (ratio < 0.66) {
			this.setForeground(Color.ORANGE);
		} else {
			this.setForeground(Color.GREEN);
		}
		super.setValue((int) value);
		setString(value + "");
		setStringPainted(true);
		

	}

}
