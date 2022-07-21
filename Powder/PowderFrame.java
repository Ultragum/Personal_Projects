/*
 * Written by Jamel Chouarfia
 */

import javax.swing.JFrame;

public class PowderFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	PowderFrame() {
		this.add(new PowderPanel());
		this.setTitle("Powder Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
