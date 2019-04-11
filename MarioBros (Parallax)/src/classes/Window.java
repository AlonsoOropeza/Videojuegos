package classes;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {
	private JFrame window;
	private int width, height;
	private Canvas canvas;
	private String title;
	
	public Window(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		createWindow();
	}
	
	public void createWindow() {
		window = new JFrame(title);
		
		window.setSize(width, height);
		window.setPreferredSize(new Dimension(width, height));
		window.setMinimumSize(new Dimension(width, height));
		window.setMaximumSize(new Dimension(width, height));
		
		window.setFocusable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		canvas = new Canvas();
		
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		
		canvas.setFocusable(false);
		window.add(canvas);
		window.pack();
		window.requestFocus();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return window;
	}
}
