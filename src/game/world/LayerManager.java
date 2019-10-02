package game.world;

import java.awt.Graphics;
import game.Handler;

public class LayerManager {
	
	private Handler handler;
	
	private Layer[] layers;
	
	public LayerManager(Handler handler, int layerNum) {
		this.handler = handler;
		this.layers = new Layer[layerNum];
	}
	
	public void update() {
		for(Layer l:layers) l.update();
	}
	
	public void render(Graphics g) {
		for(Layer l:layers) l.render(g);
	}

	public Layer[] getLayers() {
		return layers;
	}
	
	public Layer getLayer(int index) {
		return layers[index];
	}

	public void addLayer(Layer layer, int index) {
		layers[index] = layer;
	}
	
	public void removeLayer(int index) {
		layers[index] = null;
	}
	
	public void resetLayers() {
		layers = new Layer[layers.length];
	}
	
}
