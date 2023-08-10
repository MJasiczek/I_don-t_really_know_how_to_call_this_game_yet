package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyControl implements KeyListener{

	public boolean upPressed, downPressed, leftPressed, rightPressed;
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W ||code ==  KeyEvent.VK_UP) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S ||code ==  KeyEvent.VK_DOWN) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A ||code ==  KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D ||code ==  KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
		/*case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			upPressed = true;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			downPressed = true;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			leftPressed = true;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			rightPressed = true;
		default:
			upPressed = downPressed = leftPressed =rightPressed = false;
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W ||code ==  KeyEvent.VK_UP) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S ||code ==  KeyEvent.VK_DOWN) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A ||code ==  KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D ||code ==  KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
		/*switch(code) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			upPressed = false;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			downPressed = false;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			leftPressed = false;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			rightPressed = false;
		default:
			upPressed = downPressed = leftPressed =rightPressed = false;
		}*/
	}

}
