package game.world.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import game.Handler;
import game.collision.CollisionLine;
import utils.vector.Vector2;

public class LevelLoader  implements Runnable{

	private boolean running = false;
	private Thread thread;

	private Handler handler;
	private String level;

	public LevelLoader(Handler handler, String level) {
		this.handler = handler;
		this.level = level;
	}

	public void run() {
		File file = new File(handler.getDir()+"/levels/"+level);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			String currentCommand = "";
			Vector2 reletivePosition = Vector2.ZERO;
			int currentLayer = -1;
			while ((line = br.readLine()) != null) {
				if(line.charAt(0)=='!') currentCommand = line;
				boolean end = false;
				switch(currentCommand) {
				case "!layer":
					currentLayer++;
					break;
				case "!end":
					end = true;
				}
				if(end) break;
				if(currentCommand == line) continue;
				switch(currentCommand) {
				case "!xy":
					String[] xy = line.split("\\s+");
					reletivePosition = new Vector2(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
					break;
				case "!line":
					String[] linePosition = line.split("\\s+");
					handler.getLayerManager().getLayer(currentLayer).getCollisionLineManager().addLine(new CollisionLine(
							Integer.parseInt(linePosition[0])+reletivePosition.getX(),  
							Integer.parseInt(linePosition[1])+reletivePosition.getY(),  
							Integer.parseInt(linePosition[2])+reletivePosition.getX(),  
							Integer.parseInt(linePosition[3])+reletivePosition.getY(), level)); 
					break;
				case "!graphic":
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
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

}
