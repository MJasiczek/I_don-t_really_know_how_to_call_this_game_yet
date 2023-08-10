package character;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyControl;
import main.ScreenPanel;

public class Player extends Character {

	ScreenPanel screenPanel;
	KeyControl keyHandler;
	
	public Player(ScreenPanel screenPanel, KeyControl keyHandler) {
		this.screenPanel = screenPanel;
		this.keyHandler= keyHandler;
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		xPosition = 100;
		yPosition = 100;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		try {
			
			down = ImageIO.read(getClass().getResource("/player/sprite_00.png"));
			down1 = ImageIO.read(getClass().getResource("/player/sprite_01.png"));
			down2 = ImageIO.read(getClass().getResource("/player/sprite_02.png"));
			up = ImageIO.read(getClass().getResource("/player/sprite_03.png"));
			up1 = ImageIO.read(getClass().getResource("/player/sprite_05.png"));
			up2 = ImageIO.read(getClass().getResource("/player/sprite_06.png"));
			right1 = ImageIO.read(getClass().getResource("/player/sprite_07.png"));
			right2 = ImageIO.read(getClass().getResource("/player/sprite_08.png"));
			left1 = ImageIO.read(getClass().getResource("/player/sprite_09.png"));
			left2= ImageIO.read(getClass().getResource("/player/sprite_10.png"));

		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		//Movement criteria - we start from an upper left corner, which is 0:0
				//X values increases = go to the right   |  Y values increases = go to the down
			
			if(keyHandler.upPressed==true ||keyHandler.downPressed == true || keyHandler.leftPressed==true ||keyHandler.rightPressed==true)
			{
				if(keyHandler.upPressed==true) {
					direction="up";
					yPosition = yPosition - speed;
				} 
				else if(keyHandler.downPressed == true) {
					direction="down";
					yPosition = yPosition + speed;
				}
				else if(keyHandler.leftPressed == true) {
					direction="left";
					xPosition = xPosition -speed;
				} 
				else if(keyHandler.rightPressed == true) {
					direction="right";
					xPosition = xPosition + speed;
				}
				
				spriteCounter++;
				if(spriteCounter > 13) {
					if(spriteNumber == 1) {
						spriteNumber=2;
					}else if(spriteNumber==2) {
						spriteNumber=1;
					}
					spriteCounter=0;
				}
			}else if (keyHandler.upPressed==false ||keyHandler.downPressed == false ||keyHandler.leftPressed==false||keyHandler.rightPressed==false)
			{
				direction="released";
			}
			
			/*}else if (keyHandler.upPressed==false)
			{
				direction="released_UP";
			}else if(keyHandler.downPressed == false){
				direction="released_DOWN";
			}else if(keyHandler.leftPressed==false) {
				direction="released_LEFT";
			}else if(keyHandler.rightPressed==false) {
				direction="released_RIGHT";
			}*/
	}
	public void draw(Graphics g2d) {
		//g2d.setColor(Color.black);
		//g2d.fillRect(xPosition, yPosition, screenPanel.scaledTileSize, screenPanel.scaledTileSize);
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNumber ==1) {
				image = up1;
				}
			else if (spriteNumber==2) {
				image = up2;
			}
			
			break;
		case "down":
			if(spriteNumber ==1) {
			image = down1;
			}
			else if (spriteNumber==2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNumber ==1) {
			image = left1;
			}
			else if(spriteNumber ==2) {
				image = left2;
				}
			break;
		case "right":
			if(spriteNumber ==1) {
			image=right1;
			}
			else if(spriteNumber ==2) {
				image = right2;
				}
			break;
		case "released":
			image=down;
			break;
		/*case "released_UP":
			image=up;
			break;
		case "released_LEFT":
			image=left1;
			break;
		case "released_RIGHT":
			image=right1;
			break;*/
		
		}
		g2d.drawImage(image, xPosition, yPosition, screenPanel.scaledTileSize, screenPanel.scaledTileSize, null);
	}
}
