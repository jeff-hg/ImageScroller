package main;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window extends JFrame {
	
	private JPanel mainFrame = new MainPanel();
	private JMenuBar menubar = new MenuBar();
	
	public Window() {
		// Setup
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setTitle("Image Scroller (´・ω・`)");
		
		// Adding frames
		this.add(mainFrame);
		this.pack();
		
		// Menubar
		this.setJMenuBar(menubar);
		
		// NOTE: You must place this after setting the frame size (after pack() in this case)
		// Otherwise the method will center the top-left corner of the frame with your screen rather than the center of the frame.
		this.setLocationRelativeTo(null);
		
		// Keep this at the bottom of the constructor
		this.setVisible(true);
	}
}
