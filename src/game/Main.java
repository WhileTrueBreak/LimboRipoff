package game;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import game.display.Camera;
import game.display.Display;
import game.graphics.Assets;
import game.inputs.KeyManager;
import game.inputs.MouseManager;
import game.state.Game;

public class Main implements Runnable{
	
	private Display display;
	private boolean running = false;
	private Thread thread;
	
	//graphics
	private BufferStrategy bs;
	private Graphics g;
	
	//screen info
	private int width, height;
	private String title;
	
	//input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//handler
	private Handler handler;

	//game
	private Game game;
	
	//camera
	private Camera camera;
	
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

		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		camera = new Camera(handler, 0, 0);
		
		display.getJFrame().addKeyListener(keyManager);
		display.getJFrame().addMouseListener(mouseManager);
		display.getJFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		
		game = new Game(handler);
	}
	
	private void update() {
		game.update();
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
		game.render(g);
		// End Crap
		bs.show();
		g.dispose();
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
				if(handler.getCurrentFps()/1!=0) {
					width = Toolkit.getDefaultToolkit().getScreenSize().width;
					height = Toolkit.getDefaultToolkit().getScreenSize().height;
					update();
					render();
				}
				ticks++;
				delta--;
				if(delta > 1)
					delta--;
				handler.setCurrentFps(1000000000/(System.nanoTime()-start_tick_length));
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
	
	/*************************************************************/
	/**                   GETTERS AND SETTERS                   **/
	/*************************************************************/
	
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

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public Camera getCamera() {
		return camera;
	}

	public Game getGame() {
		return game;
	}
	
}
