package game.world;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	
	private LayerManager layerManager;
	
	private ArrayList<String>loadedFiles = new ArrayList<String>();
	
	public World() {
		
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
	public void loadLevel(String file) {
		if(loadedFiles.contains(file)) return;
		
	}

	public LayerManager getLayerManager() {
		return layerManager;
	}

}
