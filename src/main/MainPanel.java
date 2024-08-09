/**
 * This class is used to manage the main functionalities of the program.
 */
package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPanel extends JPanel {
	private static final Dimension SCREEN_SIZE = (Toolkit.getDefaultToolkit()).getScreenSize();
	
	private int frameHeight;
	private int frameWidth;
	private MenuBar menubar;
	
	// The folder we're displaying images from
	private File selectedFolder;
	
	public MainPanel() {
		this.frameHeight = (int) (SCREEN_SIZE.height / 1.2);
		this.frameWidth = (int) (SCREEN_SIZE.width / 2);
		this.setPreferredSize(new Dimension(frameWidth, frameHeight));
		this.setLayout(new GridBagLayout());
	}
	
	/**
	 * Set the menubar
	 */
	public void setMenubar(MenuBar bar) {
		this.menubar = bar;
	}
	
	/**
	 * Displays images on the screen from selectedFolder attribute
	 */
	public void displayImages() {
		if (menubar != null) {
			this.selectedFolder = menubar.getSelectedFolder();
		}
		
		if (selectedFolder == null) {
			System.out.println("No Folder selected");
			return;
		}
		
		// Get all images from selectedFolder in the directory
		File[] imageFiles = selectedFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png") || 
				name.toLowerCase().endsWith(".jpg") || 
				name.toLowerCase().endsWith(".jpeg"));
		

	    if (imageFiles == null || imageFiles.length == 0) {
	        System.out.println("No images found in the selected folder");
	        return;
	    }

	    // Remove any previous components from the panel
	    this.removeAll();
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

	    // Load and display each image
	    for (File imageFile : imageFiles) {
	        try {
	            BufferedImage img = ImageIO.read(imageFile);
	            ImageIcon icon = new ImageIcon(img);
	            JLabel label = new JLabel(icon);
	            this.add(label, gbc);
	            gbc.gridy++; // Move to the next row
	            
	            frameHeight += icon.getIconHeight() + gbc.insets.top + gbc.insets.bottom;
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // Adjust panel size
	    this.setPreferredSize(new Dimension(frameWidth, frameHeight));

	    // Repaint and revalidate the panel to show the images
	    this.revalidate();
	    this.repaint();
	}
}
