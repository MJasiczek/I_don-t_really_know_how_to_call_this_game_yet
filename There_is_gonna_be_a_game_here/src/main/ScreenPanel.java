package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import character.Player;

public class ScreenPanel extends JPanel implements Runnable {
	
	//Screen Panel Settings
	//16x16 pixel size of tile
	final int tileSize = 16;
	//We need to scale our size for modern monitor usage
	final int scale = 3; 

	//16*3 = 48x48
	public final int scaledTileSize = tileSize*scale;
	
	//displayed number of tiles horizon x vertic
	final int screenTilesNumberHorizon = 18;
	final int screenTilesNumberVert = 16;
	final int screenWidth = scaledTileSize*screenTilesNumberHorizon; //864
	final int screenHeight = scaledTileSize*screenTilesNumberVert; //768
	//Introduction of the concept of time in game using Thread
	Thread gameClock;
	//Player default position
	int playerXPosition = 100;
	int playerYPosition = 100;
	int playerMovementSpeed = 4;
	//FPS
	int fps = 50;
	//create keyHandler object, to use keyControl
	KeyControl keyHandler = new KeyControl();		
	//define Player
	Player player = new Player(this, keyHandler);
			
			
	public ScreenPanel () {
		//size of the screen panel
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		//help to improve render performance
		this.setDoubleBuffered(true);
		//initialize keyListener
		this.addKeyListener(keyHandler);
		//put the focus to recive a key input
		this.setFocusable(true);
	}
	
	/******************************************************************/
	
	
	public void startGameClock() {
		//we passing ScreenPanel to Thread constructor
		gameClock = new Thread(this);
		gameClock.start();
	}
	
	//when we startGameClock, it automatically invokes run method
	@Override
	public void run() {
		//Here we create a Loop Game - first, to update an information / second, to draw screen with updated information
		
		//we want app to update each 60 sec, no mor, so we need a time 
		double drawInterval = 1000/fps;
		double delta = 0;
		//1,000 milliseconds = 1 sec
		long lastTime = System.currentTimeMillis();
		long timeNOW;
		//as long as gameClock exist, it's gonna run a Loop Game
		while(gameClock != null) {
			
			timeNOW =  System.currentTimeMillis();
			delta = delta + (timeNOW - lastTime) / drawInterval;
			lastTime = timeNOW;
			
			if(delta >= 1) {
				//update
				update();
				//draw - that's how you call paintComponent method
				repaint();
				delta--;
			}
			
		}
		
		
	}
	//update method
	public void update() {
		player.update();
	}
	//draw method, build-in JPanel
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//we change Graphics g to 2DGraphics g
		Graphics2D g2d = (Graphics2D)g;
		player.draw(g2d);
		//dispose memory from using process
		g2d.dispose();
	}
}
