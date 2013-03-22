package com.unimongame.GUI;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel{
	
    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    protected Color shadowColor = Color.white;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(20, 20);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 3;
    /** The offset of shadow.  */
    protected int shadowOffset = 2;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 150;
	
	public InfoPanel(String name, String type, int hp, LifeBar lifeBar) {
        super();
        setLayout(null);
        setOpaque(false);
        setSize(200,70);
        setBackground(Color.lightGray);
        setForeground(Color.black);
        
        JLabel label1 = new JLabel(name);
        label1.setSize(150, 20);
        label1.setLocation(10, 5);
        label1.setHorizontalAlignment(JLabel.LEFT);
        this.add(label1);
        
        JLabel label2 = new JLabel(type);
        label2.setSize(150, 20);
        label2.setLocation(40, 45);
        label2.setHorizontalAlignment(JLabel.RIGHT);
        this.add(label2);
        
        JLabel label3 = new JLabel(hp + " hp");
        label3.setSize(40, 20);
        label3.setLocation(150, 5);
        label3.setHorizontalAlignment(JLabel.RIGHT);
        this.add(label3);
        
        lifeBar.setLocation(70,30);
        this.add(lifeBar);
        
        
	}
	
  	 @Override
  	 protected void paintComponent(Graphics g) {
  	        super.paintComponent(g);
  	        int width = getWidth();
  	        int height = getHeight();
  	        int shadowGap = this.shadowGap;
  	        Color shadowColorA = new Color(shadowColor.getRed(), 
  		shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
  	        Graphics2D graphics = (Graphics2D) g;

  	        //Sets antialiasing if HQ.
  	        if (highQuality) {
  	            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
  				RenderingHints.VALUE_ANTIALIAS_ON);
  	        }

  	        //Draws shadow borders if any.
  	        if (shady) {
  	            graphics.setColor(shadowColorA);
  	            graphics.fillRoundRect(
  	                    shadowOffset,// X position
  	                    shadowOffset,// Y position
  	                    width - strokeSize - shadowOffset, // width
  	                    height - strokeSize - shadowOffset, // height
  	                    arcs.width, arcs.height);// arc Dimension
  	        } else {
  	            shadowGap = 1;
  	        }

  	        //Draws the rounded opaque panel with borders.
  	        graphics.setColor(getBackground());
  	        graphics.fillRoundRect(0, 0, width - shadowGap, 
  			height - shadowGap, arcs.width, arcs.height);
  	        graphics.setColor(getForeground());
  	        graphics.setStroke(new BasicStroke(strokeSize));
  	        graphics.drawRoundRect(0, 0, width - shadowGap, 
  			height - shadowGap, arcs.width, arcs.height);

  	        //Sets strokes to default, is better.
  	        graphics.setStroke(new BasicStroke());
  	    }
}