import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.*;

public class LifeBar extends JProgressBar {

	public LifeBar (int max, int value) {
	
	super(0,max);
	double ratio = (double) value / (double) max;

    setUI(new BasicProgressBarUI() {
        protected Color getSelectionBackground() { return Color.darkGray; }
        protected Color getSelectionForeground() { return Color.darkGray; }
      });
	
	if (ratio<0.33) {
	this.setForeground(Color.RED);
	} else if (ratio<0.66) {
	this.setForeground(Color.ORANGE);
	} else {
	this.setForeground(Color.GREEN);
	}
	this.setValue(value);
	this.setString(value +"");
	this.setStringPainted(true);
	this.setSize(120,15);

	}





}
>>>>>>> 74390e34157fe415aff62ca5dbe23f2f3b94cf8a
