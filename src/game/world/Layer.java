package game.world;

import java.awt.Graphics;

import game.Handler;
import game.collision.CollisionLineManager;
import game.graphics.GraphicsManager;

public class Layer {

	private Handler handler;
	
	private CollisionLineManager clm = new CollisionLineManager();
	private GraphicsManager gm = new GraphicsManager(handler);
	
	public Layer(Handler handler){
		this.handler = handler;
	}
	
	public void update() {
		gm.update();
	}
	
	public void render(Graphics g) {
		gm.render(g);
	}

	public CollisionLineManager getCollisionLineManager() {
		return clm;
	}

	public GraphicsManager getGraphicsManager() {
		return gm;
	}
	
}
