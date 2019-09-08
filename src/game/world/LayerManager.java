package game.world;

import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;

public class LayerManager {
	
	private Handler handler;
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public LayerManager(Handler handler) {
		this.handler = handler;
	}
	
	public void update() {
		for(Layer l:layers) l.update();
	}
	
	public void render(Graphics g) {
		for(Layer l:layers) l.render(g);
	}

	public ArrayList<Layer> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}

	public void addLayer(Layer layer) {
		layers.add(layer);
	}
	
	public void removeLayer(Layer layer) {
		layers.remove(layer);
	}
	
	public ArrayList<Layer> resetLayers() {
		return layers = new ArrayList<Layer>();
	}
	
}
