package main;

import javax.swing.*;

public class Window extends JFrame {
	
	private JPanel mainFrame = new MainFrame();
	private JMenu menubar;
	
	public Window() {
		// Setup
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Image Scroller (´・ω・`)");
		
		// Adding frames
		this.add(mainFrame);
		this.pack();
		
		// NOTE: You must place this after setting the frame size (after pack() in this case)
		// Otherwise the method will center the top-left corner of the frame with your screen rather than the center of the frame.
		this.setLocationRelativeTo(null);
		
		
		// Keep this at the bottom of the constructor
		this.setVisible(true);
	}
}
