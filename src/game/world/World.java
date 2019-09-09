package game.world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import game.Handler;
import game.collision.CollisionLine;
import utils.vector.Vector2;

public class World {

	public static final int LAYER_NUM = 3;
	
	public static float GRAVITY = 10f;

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
							Integer.parseInt(linePosition[0]), 
							Integer.parseInt(linePosition[1]), 
							Integer.parseInt(linePosition[2]), 
							Integer.parseInt(linePosition[3]), level));
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

	public LayerManager getLayerManager() {
		return layerManager;
	}

	public ArrayList<String> getLoadedFiles(){
		return loadedFiles;
	}

}
