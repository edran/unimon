package com.unimongame.GUI;

import javax.swing.*;

import com.unimongame.Player;
import com.unimongame.Unimon;

import java.awt.*;

public class InfoPanel extends JPanel{

	//The rounded corner layout comes from http://www.codeproject.com/Articles/114959/Rounded-Border-JPanel-JPanel-graphics-improvements
	
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
	private Unimon currentUni;
	private LifeBar lifeBar;
	JLabel nameLabel, status, typeLabel, numUnimonLabel;
	Player player;
	String statusText;
	String statusShort;
	
	
	public InfoPanel(Player player) {
        setLayout(null);
        setOpaque(false);
        setSize(180,70);
        setBackground(Color.lightGray);
        setForeground(Color.black);
        setVisible(true);
        
        nameLabel = new JLabel();
        nameLabel.setSize(130, 20);
        nameLabel.setLocation(10, 5);
        nameLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(nameLabel);
        
       typeLabel = new JLabel();
        typeLabel.setSize(130, 20);
        typeLabel.setLocation(40, 45);
        typeLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(typeLabel);
        
        numUnimonLabel = new JLabel();
        numUnimonLabel.setSize(60, 20);
        numUnimonLabel.setLocation(110, 5);
        numUnimonLabel.setHorizontalAlignment(JLabel.RIGHT);
        this.add(numUnimonLabel);
        
        this.player = player;
        currentUni = player.getActiveUnimon();
        lifeBar = new LifeBar(currentUni.getMaxHp(),currentUni.getHp()); 
        lifeBar.setLocation(50,30);
        this.add(lifeBar);
        
        status = new JLabel();
        status.setSize(120, 20);
        status.setLocation(10, 45);
        status.setHorizontalAlignment(JLabel.RIGHT);
        this.add(status);
        
        updateInfo(player);
	}
	
	public void updateInfo(Player player){
		this.player = player;
		currentUni =player.getActiveUnimon();
		lifeBar.setMaximum(currentUni.getMaxHp());
		nameLabel.setText(currentUni.getName());
		typeLabel.setText("Type");
		numUnimonLabel.setText(player.numAlive()+"/"+player.getUnimon().size());
		lifeBar.setValue(currentUni.getHp());
		lifeBar.repaint();
		
		statusShort = "";
		statusText = "The unimon is ";
		if (currentUni.isConfused()) {
			statusShort += "CON ";
			statusText += "confused ";
		}
		if (currentUni.isDistracted()) {
			statusShort += "DIS ";
			statusText += "distracted ";
		}
		if (currentUni.isHungover()) {
			statusShort += "HUN ";
			statusText += "hungover ";
		}
		
		status.setText(statusShort);
		status.setToolTipText(statusText);
		
		repaint();
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