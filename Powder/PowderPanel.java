/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PowderPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final int SIZE = 500;
	private static final int DELAY = 10;
	private static Powder[] PowderElements = new Powder[SIZE*SIZE];
	private static char[][] Occupied = new char[SIZE][SIZE];
	static Random random;
	static Timer timer;
	
	PowderPanel() {
		this.setPreferredSize(new Dimension(SIZE, SIZE));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		preparePowder();
	}
	
	private void preparePowder() {
		int X = 0;
		int Y = 0;
		int Z = 0;
		
		while (500 > Y) {
			while (500 > X) {
				if (10 > Y || Y > 489) {
					PowderElements[Z] = newPowder("Wall", X, Y);
					Occupied[X][Y] = 'W';
				} else if (10 > X || X > 489) {
					PowderElements[Z] = newPowder("Wall", X, Y);
					Occupied[X][Y] = 'W';
				} else {
					PowderElements[Z] = newPowder("Nothing", X, Y);
					Occupied[X][Y] = 'N';
				}
				
				X++;
				Z++;
			}
			
			X = 0;
			Y++;
		}
		
		X = 0;
		Y = 0;
		Z = 0;
		
		while (500 > Y) {
			while (500 > X) {
				if (400 > Y && Y > 100) {
					if (400 > X && X > 100) {
						PowderElements[Z] = newPowder("Fire", X, Y);
						Occupied[X][Y] = 'F';
					}
				}
				
				X++;
				Z++;
			}
			
			X = 0;
			Y++;
		}
		
		startPowder();
	}

	private void startPowder() {
		random = new Random();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	private void draw(Graphics g) {
		int X = 0;
		int Y = 0;
		
		while (500 > Y) {
			while (500 > X) {
				g.setColor(Lookup.ColorOf(Occupied[X][Y]));
				g.drawRect(X, Y, 0, 0);
				X++;
			}
			X = 0;
			Y++;
		}
	}
	
	private void move() {
		int X = 0;
		int Y = 0;
		int Z = 0;
		
		while (SIZE > Y) {
			while (SIZE > X) {
				PowderElements[Z].move(random, Occupied);
				X++;
				Z++;
			}
			X = 0;
			Y++;
		}
	}
	
	private Powder newPowder(String Name, int X, int Y) {
		return new Powder(Name, X, Y);
	}
	
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();
	}

}
