package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import imageClasses.Assets;

public class GameLoop implements Runnable{
	public static int width, height;
	public String title;

	public Thread thread;
	
	private Window window;
	private BufferStrategy bs;
	private Graphics g;
	
	private boolean running = false;
	
	private KeyInput keyInput;
	private Player player;
	
	private int x1 = 720;
	
	public GameLoop(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	public void run() {
		init();
		int fps = 60, updates = 0;
		double timePerUpdate = 1000000000/fps, delta = 0;
		long now, lastTime = System.nanoTime(), timer = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerUpdate;
			timer += now -lastTime;
			lastTime = now;
			
			if (delta >=  1) {
				update();
				render();
				updates ++;
				delta --;
			}
			if(timer >= 1000000000) {
				System.out.println("fps: " + updates);
				updates = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public void init() {
		Assets.init();
		window = new Window(width, height, title);
		player = new Player();
		keyInput = new KeyInput(player);
		window.getFrame().addKeyListener(keyInput);

	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void update() {
		if(player.getRight()) {	
			x1++;
			System.out.println(x1);
		}
		if(player.getLeft()) {	
			x1--;
			System.out.println(x1);
		}
		if(x1 >= 1285)
			x1=721;
		if(x1 <= 720)
			x1=1285;
	}
	
	public void render() {
		bs = window.getCanvas().getBufferStrategy();
		if (bs == null) {			
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		g.drawImage(Assets.background, 721-x1, -200, null);
		g.drawImage(Assets.mario, 50, 360, 32, 42, null);
		
		g.dispose();
		bs.show();
	}
}
