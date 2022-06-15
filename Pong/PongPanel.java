/*
 * Written by Jamel Chouarfia
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

public class PongPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int SCREEN_WIDTH = 1200;
	static final int SCREEN_HEIGHT = 600;
	static final int DELAY = 34;
	final int boundSize = SCREEN_HEIGHT/20;
	final int topBounds = SCREEN_HEIGHT/20;
	final int bottomBounds = SCREEN_HEIGHT - SCREEN_HEIGHT/20;
	final int paddleLength = (int) SCREEN_HEIGHT/3;
	final int ballLength = SCREEN_WIDTH/40;
	final int playerPaddleContact = SCREEN_WIDTH/40;
	final int computerPaddleContact = SCREEN_WIDTH - SCREEN_WIDTH/40;
	int playerY = SCREEN_HEIGHT/2;
	int computerY = SCREEN_HEIGHT/2;
	int playerPaddleTop = playerY - paddleLength/2;
	int playerPaddleBottom = playerY + paddleLength/2;
	int computerPaddleTop = computerY - paddleLength/2;
	int computerPaddleBottom = computerY + paddleLength/2;
	int playerVelocity = 0;
	int computerVelocity = 0;
	int ballX = SCREEN_WIDTH/2;
	int ballY = SCREEN_HEIGHT/2;
	int ballVelocityX = 10;
	int ballVelocityY = 0;
	int ballTop = ballY - ballLength/2;
	int ballBottom = ballY + ballLength/2;
	int ballLeft = ballX - ballLength/2;
	int ballRight = ballX + ballLength/2;
	int score = 0;
	boolean running = false;
	char Direction = 'u';
	Random random;
	Timer timer;
	
	PongPanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	
	public void startGame() {
		ballVelocityY = random.nextInt(5);
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (running) {
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, SCREEN_WIDTH, boundSize);
			g.fillRect(0, bottomBounds, SCREEN_WIDTH, boundSize);
			g.setColor(Color.WHITE);
			g.fillRect(0, playerPaddleTop, SCREEN_WIDTH/40, paddleLength);
			g.fillRect(SCREEN_WIDTH-(SCREEN_WIDTH/40), computerPaddleTop, SCREEN_WIDTH/40, paddleLength);
			g.fillOval(ballX-ballLength/2, ballY-ballLength/2, ballLength, ballLength);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: "+score, (SCREEN_WIDTH - metrics.stringWidth("Score:"+score))/2, g.getFont().getSize()+SCREEN_HEIGHT/20);
		} else {
			gameOver(g);
		}
	}
	
	public void move() {
		switch(Direction) {
			case 'n':
				break;
			case 'u':
				playerVelocity = playerVelocity - 5;
				Direction = 'n';
				break;
			case 'd':
				playerVelocity = playerVelocity + 5;
				Direction = 'n';
				break;
		}

		if (bottomBounds > playerPaddleBottom + playerVelocity && playerPaddleTop + playerVelocity > topBounds) {
			playerY = playerY + playerVelocity;
			
			if (playerVelocity > 0) {
				playerVelocity--;
			} else if (0 > playerVelocity){
				playerVelocity++;
			}
		} else {
			if (playerVelocity > 0) {
				int temp = (bottomBounds) - (playerPaddleBottom);
				playerY = (bottomBounds) - (playerVelocity - temp) - paddleLength/2;
				playerVelocity = playerVelocity * (-1);
				playerVelocity++;
				
				if (playerVelocity > 0) {
					playerVelocity--;
				} else {
					playerVelocity++;
				}
			} else {
				int temp = topBounds - (playerPaddleTop);
				playerY = topBounds + (-playerVelocity - temp) + paddleLength/2;
				playerVelocity = playerVelocity * (-1);
				playerVelocity--;
				
				if (playerVelocity > 0) {
					playerVelocity--;
				} else {
					playerVelocity++;
				}
			}
		}
		
		playerPaddleTop = playerY - paddleLength/2;
		playerPaddleBottom = playerY + paddleLength/2;
		System.out.println(playerVelocity);
	}
	
	public void ballMove() {
		if (ballBottom + ballVelocityY > bottomBounds) {
			int temp = bottomBounds - ballBottom;
			ballY = bottomBounds - (ballVelocityY - temp) - ballLength/2;
			ballVelocityY = ballVelocityY * (-1);
		} else if (topBounds > ballTop + ballVelocityY) {
			int temp = topBounds - ballTop;
			ballY = topBounds - (ballVelocityY - temp) + ballLength/2;
			ballVelocityY = ballVelocityY * (-1);			
		} else if (ballRight + ballVelocityX > computerPaddleContact && ballY > computerPaddleTop && computerPaddleBottom > ballY) {
			int temp = computerPaddleContact - ballRight;
			ballX = computerPaddleContact - (ballVelocityX - temp) - ballLength/2;
			ballVelocityX = (ballVelocityX + 5) * (-1);
			ballVelocityY = ballVelocityY + (ballY - computerY)/10;
		} else if (playerPaddleContact > ballLeft + ballVelocityX ) {
			int temp = playerPaddleContact - ballLeft;
			ballX = playerPaddleContact - (ballVelocityX - temp) + ballLength/2;
			ballVelocityX = (ballVelocityX - 5) * (-1);
			ballVelocityY = ballVelocityY + (ballY - playerY)/10;
		} else {
			ballX = ballX + ballVelocityX;
			ballY = ballY + ballVelocityY;
		}
		
		if (ballVelocityY > 80) {
			ballVelocityY = 80;
		} else if (-80 > ballVelocityY) {
			ballVelocityY = -80;
		}
		
		ballTop = ballY - ballLength/2;
		ballBottom = ballY + ballLength/2;
		ballLeft = ballX - ballLength/2;
		ballRight = ballX + ballLength/2;
	}
	
	public void aiMove() {
		if (ballY > computerY + 20) {
			computerVelocity = computerVelocity + 2;
		} else if (computerY > ballY + 20){
			computerVelocity = computerVelocity - 2;
		}
		
		if (bottomBounds > computerPaddleBottom + computerVelocity && computerPaddleTop + computerVelocity > topBounds) {
			computerY = computerY + computerVelocity;
			
			if (computerVelocity > 0) {
				computerVelocity--;
			} else {
				computerVelocity++;
			}
		} else {
			if (computerVelocity > 0) {
				int temp = (bottomBounds) - (computerPaddleBottom);
				computerY = (bottomBounds) - (computerVelocity - temp) - paddleLength/2;
				computerVelocity = computerVelocity * (-1);
				computerVelocity++;
				
				if (computerVelocity > 0) {
					computerVelocity--;
				} else {
					computerVelocity++;
				}
			} else {
				int temp = topBounds - (computerPaddleTop);
				computerY = topBounds + (-computerVelocity - temp) + paddleLength/2;
				computerVelocity = computerVelocity * (-1);
				computerVelocity--;
				
				if (computerVelocity > 0) {
					computerVelocity--;
				} else {
					computerVelocity++;
				}
			}
		}
		
		computerPaddleTop = computerY - paddleLength/2;
		computerPaddleBottom = computerY + paddleLength/2;
	}
	
	public void goalCheck() {
		if (ballX >= SCREEN_WIDTH) {
			score++;
			newBall();
		} else if (0 >= ballX) {
			running = false;
		}
	}
	
	public void newBall() {
		ballX = SCREEN_WIDTH/2;
		ballY = SCREEN_HEIGHT/2;
		ballVelocityX = 10;
		ballVelocityY = random.nextInt(5);
		ballTop = ballY - ballLength;
		ballBottom = ballY + ballLength;
		ballLeft = ballX - ballLength;
		ballRight = ballX + ballLength;
	}
	
	public void gameOver(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics1.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Score: "+score, (SCREEN_WIDTH - metrics2.stringWidth("Score:"+score))/2, g.getFont().getSize()+SCREEN_HEIGHT/20);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (running) {
			move();
			ballMove();
			aiMove();
			goalCheck();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					Direction = 'u';
					break;
				case KeyEvent.VK_DOWN:
					Direction = 'd';
					break;
				default:
					Direction = 'n';
					break;
			}
		}
		
		public void keyReleasedWIP(KeyEvent e) {
			
		}
	}
}
