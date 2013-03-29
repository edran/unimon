package com.unimongame.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


@SuppressWarnings("serial")
class ImagePanel extends JPanel {

  private Image img;

  public ImagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public ImagePanel(Image img) {
    this.img = img;
  }

  
  public void updateImg(String imgPath) {
		this.img = new ImageIcon(img).getImage();
		setup();
	}

  private void setup() {
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    setVisible(true);
	  }
  
  public Dimension getImgSize(){
	  return new Dimension(img.getWidth(null), img.getHeight(null));
  }
	


@Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}
