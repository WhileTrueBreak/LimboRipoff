package game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import game.display.Display;

public class Main implements Runnable{
	
	private Display display;
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private int width, height;
	private String title;
	
	//handler
	private Handler handler;
	
	//clock
	private double timer;
	
	public Main(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	private void init() {
		display = new Display(title, width, height);
		handler = new Handler(this);
		
//		display.getJFrame().addKeyListener(keyManager);
//		display.getJFrame().addMouseListener(mouseManager);
//		display.getJFrame().addMouseMotionListener(mouseManager);
//		display.getCanvas().addMouseListener(mouseManager);
//		display.getCanvas().addMouseMotionListener(mouseManager);
	}
	
	public void run() {
		running = true;
		init();
		
		int fps = 60000;
		double timeperTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		long start_tick_length = System.nanoTime();
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timeperTick;
			timer += now - lastTime;
			this.timer = timer;
			lastTime = now;
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
				if(delta > 1)
					delta--;
				start_tick_length = System.nanoTime();
			}
			if(timer >= 1000000000) {
				System.out.println("[Main]\t\t" + ticks + " fps");
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
		
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	private void update() {
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// Draw Crap
		
		// End Crap
		bs.show();
		g.dispose();
	}
	
	////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public Double getTimer() {
		return timer;
	}
}
