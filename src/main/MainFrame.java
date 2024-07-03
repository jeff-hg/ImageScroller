package main;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JPanel {
	private static final Dimension SCREEN_SIZE = (Toolkit.getDefaultToolkit()).getScreenSize();
	private int frameHeight = SCREEN_SIZE.height / 2;
	private int frameWidth = SCREEN_SIZE.width / 2;
	
	public MainFrame() {
		// setup
		this.setPreferredSize(new Dimension(frameWidth, frameHeight));
	}
}
