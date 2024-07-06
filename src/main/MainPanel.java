package main;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	private static final Dimension SCREEN_SIZE = (Toolkit.getDefaultToolkit()).getScreenSize();
	private int frameHeight;
	private int frameWidth;
	
	public MainPanel() {
		// setup
		this.frameHeight = (int) (SCREEN_SIZE.height / 1.2);
		this.frameWidth = (int) (SCREEN_SIZE.width / 2);
		this.setPreferredSize(new Dimension(frameWidth, frameHeight));
	}
}
