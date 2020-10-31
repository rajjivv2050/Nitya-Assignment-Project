package com.interview.Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class DrawRectangle extends JComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int x = 50;
    public int y = 10;
    private boolean isFixed=false;
    private int finalX;
    private int finalY;
    
   

    public boolean isFixed() {
		return isFixed;
	}

	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}

	public int getFinalX() {
		return finalX;
	}

	public void setFinalX(int finalX) {
		this.finalX = finalX;
	}

	public int getFinalY() {
		return finalY;
	}

	public void setFinalY(int finalY) {
		this.finalY = finalY;
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(100, this.y, 20, 30);
        g.setColor(Color.BLUE);
        g.fillRect(100, this.y, 20, 30);
       
    }

    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public void moveRight() {
        x = x + 20;
        repaint();
    }

    public void moveLeft() {
        x = x - 20;
        repaint();
    }
    public static ArrayList<DrawRectangle> getList()
    {
    	return new ArrayList<DrawRectangle>();
    }
    
    public static DrawRectangle getObject()
    {
    	return new  DrawRectangle();
    }


    
}
