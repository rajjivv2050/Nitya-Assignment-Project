package com.interview.Tetris;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class DrawRectangleInJFrame extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Timer timer;
	static int i = 0;
	public final static int maxHeight = 300;
	public final static int maxWidth = 1300;

	private int baseForX[] = new int[(maxWidth / 20)];

	/*
	 * public DrawRectangleInJFrame() { // Set JFrame title
	 * super("Draw A Rectangle In JFrame");
	 * 
	 * // Set default close operation for JFrame
	 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * 
	 * // Set JFrame size setSize(400, 400);
	 * 
	 * // Make JFrame visible setVisible(true); }
	 */
	public void paint(Graphics g) {
		super.paint(g);

		// draw rectangle outline

		// g.drawRect(50, i, 20, 30);

		// set color to RED
		// So after this, if you draw anything, all of it's result will be RED
		g.setColor(Color.RED);

		// fill rectangle with RED
		// g.fillRect(20,20,100,100);
	}

	private DrawRectangle draw;
	private ArrayList<DrawRectangle> listOfRectangles;

	public void keyPressed(KeyEvent e) {
		// System.out.println("keyPressed");
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			listOfRectangles.get(listOfRectangles.size() - 1).moveRight();
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			listOfRectangles.get(listOfRectangles.size() - 1).moveLeft();

	}

	public void keyTyped(KeyEvent e) {
		// System.out.println("keyTyped");
	}

	public DrawRectangleInJFrame() {
//		this.draw = DrawRectangle.getObject();
		this.listOfRectangles = DrawRectangle.getList();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		for(int k=0;k<this.baseForX.length;k++) 
		{
			this.baseForX[k]=maxHeight;
		}
	}

	private void createObj() {
		DrawRectangle draw = DrawRectangle.getObject();

		this.listOfRectangles.add(draw);
		for (DrawRectangle e : this.listOfRectangles) {
			this.getContentPane().add(e);
		}
	}

	public static void main(String[] args) {
		DrawRectangleInJFrame myFrame = new DrawRectangleInJFrame();
//		ArrowTest mainPanel = new ArrowTest();
//		myFrame.getContentPane().add(myFrame.draw);
		// myFrame.getContentPane().add(myFrame.listOfRectangles);
		myFrame.createObj();
		myFrame.pack();
		myFrame.setVisible(true);

		timer = new Timer(500, new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				int flag = 0;//not used
				DrawRectangle temp = myFrame.listOfRectangles.get(myFrame.listOfRectangles.size() - 1);
				int indexXTemp = (int) Math.floor(temp.getX()/20);
				if (i <= myFrame.baseForX[indexXTemp] && flag == 0) {
					
					// myFrame.repaint();
					i = i + 30;
					temp.setY(i);
					temp.repaint();
					
					// System.out.println("Yahi hai width
					// "+myFrame.getContentPane().getSize().getWidth()); 1366

					// System.out.println(DrawRectangleInJFrame.i);

				} 
				else 
				{
					//System.out.println("in else "+myFrame.baseForX[indexXTemp]);
					//System.out.println("X = " + myFrame.listOfRectangles.get(myFrame.listOfRectangles.size() - 1).getX());
					//System.out.println("Y = " + myFrame.listOfRectangles.get(myFrame.listOfRectangles.size() - 1).getY());
					//int indexX = myFrame.listOfRectangles.get(myFrame.listOfRectangles.size() - 1).getX() / 20;
					//int indexY = myFrame.listOfRectangles.get(myFrame.listOfRectangles.size() - 1).getY() - 30;
					
					myFrame.baseForX[indexXTemp] -= 30;
					//System.out.println(indexX + " ="+indexY);
					
					i = 0;
					myFrame.createObj();
					myFrame.revalidate();
					// myFrame.repaint();
					// myFrame.setVisible(true);
				}
				// myFrame.listOfRectangles.get(myFrame.listOfRectangles.size()-1).setFinalX(myFrame.draw.getX());
				// myFrame.listOfRectangles.get(myFrame.listOfRectangles.size()-1).setFinalY(myFrame.draw.getY());
				/*
				 * else { i=30; myFrame.draw1=DrawRectangle.getObject();
				 * myFrame.getContentPane().add(myFrame.draw1); myFrame.draw.repaint();
				 * myFrame.draw1.repaint();
				 * 
				 * 
				 * System.out.println("outside if");
				 * 
				 * }
				 */
			}

			// write code to stop when screen ends @ 350

		});

		// GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		// System.out.println(env.getMaximumWindowBounds());

		timer.start();

	}

//	@Override
//	public void focusGained(FocusEvent e) {
//		System.out.println("from focus");
//		
//	}
//
//	@Override
//	public void focusLost(FocusEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}