package game.world;

import java.awt.Graphics;

import game.Handler;
import game.collision.CollisionLineManager;

public class Layer {

	private Handler handler;
	
	private CollisionLineManager clm = new CollisionLineManager();
	//graphics manager
	
	public Layer(Handler handler){
		this.handler = handler;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		
	}
	
}
