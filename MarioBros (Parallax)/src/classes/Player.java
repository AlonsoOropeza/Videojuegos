package classes;

import java.awt.event.KeyEvent;

public class Player {
	private boolean right,left;
	
	public void keyPressed(int k) {
		  if(k == KeyEvent.VK_RIGHT) right = true;
		  if(k == KeyEvent.VK_LEFT) left = true;
	 }
	 public void keyReleased(int k) {
		 if(k == KeyEvent.VK_RIGHT) right = false;
		 if(k == KeyEvent.VK_LEFT) left = false;
	 }
	 
	 public boolean getRight() {
		 return right;
	 }
	 
	 public boolean getLeft() {
		 return left;
	 }
}
