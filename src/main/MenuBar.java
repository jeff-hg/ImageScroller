package main;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Menu options
	private JMenu fileMenu = new JMenu("File");
	
	// Menu items
	JMenuItem selectItem;
	JMenuItem saveItem;
	
	// Folder selected via selectItem. This is the folder that's to be openend.
	File selectedFolder= null;
	
	public MenuBar() {
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
	
	public void selectItemActionListener() {
		selectItem.addActionListener((ActionEvent e) -> {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int fileChooserReturnValue = fileChooser.showOpenDialog(null);
			if (fileChooserReturnValue == JFileChooser.APPROVE_OPTION) {
				selectedFolder = fileChooser.getSelectedFile();
			}
		});
		
	}
}
