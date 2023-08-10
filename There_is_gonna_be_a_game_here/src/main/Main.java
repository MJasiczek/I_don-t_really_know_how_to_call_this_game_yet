package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		//create window
		JFrame window = new JFrame();
		//create screenPanel (game control)
		ScreenPanel screenPanel = new ScreenPanel();
		//properly close window on x
		window.getDefaultCloseOperation();
		//off resize
		window.setResizable(false);
		//set title
		window.setTitle("2D Game..I guess??xoxo");
		//add screenPanel (game)
		window.add(screenPanel);
		//size the window to fit size and layout of ScreenPanel
		window.pack();
		//set location center
		window.setLocationRelativeTo(null);
		//set visibility
		window.setVisible(true);
		
		
		
		
		//start screenPanel - Loop Game
		screenPanel.startGameClock();
		
	}

}
