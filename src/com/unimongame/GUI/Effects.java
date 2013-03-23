package com.unimongame.GUI;

import java.util.Date;
import javax.swing.JPanel;

public class Effects {

	public static void runEffect(JPanel panel, String mode, String speed, int time) {

		int x = (int) panel.getLocation().getX();
		int y = (int) panel.getLocation().getY();
		int period = 150;

		if (speed.equals("fast")) {
			period = 50;
		} else if (speed.equals("moderate")) {
			period = 150;
		} else if (speed.equals("slow")) {
			period = 300;
		}

		long start = new Date().getTime();
		long now = new Date().getTime();

		if (mode.equals("horizontal")) {
			while (now - start <= time) {
				panel.setLocation(x, y);
				waiting(period / 4);
				panel.setLocation(x + 10, y);
				waiting(period / 4);
				panel.setLocation(x, y);
				waiting(period / 4);
				panel.setLocation(x - 10, y);
				waiting(period / 4);

				now = new Date().getTime();
			}
		} else if (mode.equals("vertical")) {
			while (now - start <= time) {
				panel.setLocation(x, y);
				waiting(period / 4);
				panel.setLocation(x, y + 10);
				waiting(period / 4);
				panel.setLocation(x, y);
				waiting(period / 4);
				panel.setLocation(x, y - 10);
				waiting(period / 4);

				now = new Date().getTime();
			}
		} else if (mode.equals("diagonal")) {
			while (now - start <= time) {
				panel.setLocation(x, y);
				waiting(period / 4);
				panel.setLocation(x + 10, y + 10);
				waiting(period / 4);
				panel.setLocation(x, y);
				waiting(period / 4);
				panel.setLocation(x - 10, y - 10);
				waiting(period / 4);

				now = new Date().getTime();
			}
		}

		panel.setLocation(x, y);

	}

	public static void waiting(int n) {

		long t0, t1;

		t0 = System.currentTimeMillis();

		do {
			t1 = System.currentTimeMillis();
		} while (t1 - t0 < n);
	}

}