package game.graphics;

import java.awt.Graphics;

import game.Handler;
import utils.vector.Vector2;

public class GraphicsManager {
	
	private Handler handler;
	
	//arraylist of graphics objects
	
	private Vector2 offset;
	private float scale;
	
	public GraphicsManager(Handler handler) {
		this.handler = handler;
	}
	
	public void update() {
		//update for animated graphics
	}
	
	public void render(Graphics g) {
		
	}

	public Vector2 getOffset() {
		return offset;
	}

	public void setOffset(Vector2 offset) {
		this.offset = offset;
	}

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}
	
}
