package game.world;

import java.util.ArrayList;

public class LayerManager {
	
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	
	public LayerManager() {
		
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
