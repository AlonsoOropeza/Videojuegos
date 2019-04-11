package classes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	Player player;
	public KeyInput(Player player) {
		this.player = player;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		player.keyPressed(key);
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		player.keyReleased(key);
	}
	public void keyTyped(KeyEvent e) {
		
	}
}
