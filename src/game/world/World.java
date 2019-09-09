package game.world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import game.Handler;

public class World {

	public static float GRAVITY = 5;

	private Handler handler;

	private ArrayList<String>loadedFiles = new ArrayList<String>();

	private LayerManager layerManager;


	public World(Handler handler) {
		this.handler = handler;
		layerManager = new LayerManager(handler);
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
		File file = new File(handler.getDir()+"/levels/"+level);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				System.out.println(st);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public LayerManager getLayerManager() {
		return layerManager;
	}

	public ArrayList<String> getLoadedFiles(){
		return loadedFiles;
	}

}
