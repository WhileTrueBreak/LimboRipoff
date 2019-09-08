package game.world;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;

public class World {
	
	private Handler handler;
	
	private ArrayList<String>loadedFiles = new ArrayList<String>();
	
	private LayerManager layerManager;
	
	
	public World(Handler handler) {
		this.handler = handler;
		layerManager = new LayerManager(handler);
	}
	
	public void update() {
		layerManager.update();
	}
	
	public void render(Graphics g) {
		layerManager.render(g);
	}
	
	public void loadLevel(String file) {
		if(loadedFiles.contains(file)) return;
		//load graphics and lines from file
	}

	public LayerManager getLayerManager() {
		return layerManager;
	}

}
