/**
 * This class is used to set up and manage all functionalities related to the window.
 */
package main;

import java.io.File;

import javax.swing.*;

public class Window extends JFrame {
	
	private MenuBar menubar;
	private MainPanel mainPanel;
	
	public Window() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Image Scroller (´・ω・`)");
		
		this.mainPanel = new MainPanel();
		this.add(mainPanel);
		this.pack();
		
		setupMenuBar();
		
		mainPanel.setMenubar(menubar);
		
		setupScroll();

		// NOTE: You must place this after setting the frame size (after pack() in this case)
		// Otherwise the method will center the top-left corner of the frame with your screen rather than the center of the frame.
		this.setLocationRelativeTo(null);
		// Keep this at the bottom of the constructor
		this.setVisible(true);
	}
	
	public void setupMenuBar() {
		this.menubar = new MenuBar(mainPanel);
		this.setJMenuBar(menubar);
	}
	
	public void setupScroll() {
		// Create a JScrollPane and add the MainPanel to it
		JScrollPane scrollPane = new JScrollPane(mainPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(20);
		verticalScrollBar.setBlockIncrement(100);
		this.add(scrollPane);
	}
}
