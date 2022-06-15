/*
 * Written by Jamel Chouarfia
 */

import javax.swing.JFrame;

public class PongFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("static-access")
	PongFrame() {
		this.add(new PongPanel());
		this.setTitle("Pong");
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
