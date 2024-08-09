/**
 * This class is used to set up and manage all functionalities related to the menu bar.
 */
package main;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBar extends JMenuBar{
	private MainPanel panel;

	// Menu options
	private JMenu fileMenu = new JMenu("File");
	
	// Menu items
	JMenuItem selectItem;
	JMenuItem saveItem;
	
	// Folder selected via selectItem
	File selectedFolder;
	
	public MenuBar(MainPanel panel) {
		this.panel = panel;
		
		// Add menu options
		this.add(fileMenu);
		
		// Create menu items
		saveItem = new JMenuItem("Save");
		selectItem = new JMenuItem("Select");
		selectItemActionListener();
		
		// Add menu items
		fileMenu.add(saveItem);
		fileMenu.add(selectItem);
	}
	
	public File getSelectedFolder() {
		return this.selectedFolder;
	}
	
	/**
	 * Create the action listener for the selectItem menu item.
	 * This action listener will open a folder select menu and update the selectedFolder attribute with the folder selected
	 */
	public void selectItemActionListener() {
		selectItem.addActionListener((ActionEvent e) -> {
			// When selectItem is clicked, open file chooser menu
			JFileChooser filechooser = new JFileChooser();
			filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			filechooser.setDialogTitle("Image Folder Select");
			filechooser.setApproveButtonText("Select");
			filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			
			// Change selectedFolder to the folder selected
			int filechooserReturnValue = filechooser.showOpenDialog(null);
			if (filechooserReturnValue == JFileChooser.APPROVE_OPTION) {
				this.selectedFolder = filechooser.getSelectedFile();
			}
			System.out.println("Selected Folder: " + this.selectedFolder);
			
			panel.displayImages();
		});
	}
}
