package game.world;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;
import game.world.loader.LevelLoader;

public class World {

	public static final int LAYER_NUM = 3;
	
	public static float GRAVITY = 3f;

	private Handler handler;

	private ArrayList<String>loadedFiles = new ArrayList<String>();

	private LayerManager layerManager;


	public World(Handler handler) {
		this.handler = handler;
		handler.setWorld(this);
		layerManager = new LayerManager(handler, LAYER_NUM);
		for(int i = 0;i < LAYER_NUM;i++) layerManager.addLayer(new Layer(handler), i);
		loadLevel("1.level");
	}

	public void update() {
		layerManager.update();
	}

	public void render(Graphics g) {
		layerManager.render(g);
	}

	public void loadLevel(String level) {
		if(loadedFiles.contains(level)) return;
		loadedFiles.add(level);
		//load graphics and lines from file
		new LevelLoader(handler, level).start();
	}

	public LayerManager getLayerManager() {
		return layerManager;
	}

	public ArrayList<String> getLoadedFiles(){
		return loadedFiles;
	}

}
