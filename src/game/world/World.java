package game.world;

import game.Handler;

public class World {
	
	private Handler handler;
	
	//managers
	private LayerManager layerManager;
	
	public World(Handler handler, LayerManager layers) {
		this.handler = handler;
	}

	public LayerManager getLayerManager() {
		return layerManager;
	}
	
	
}
