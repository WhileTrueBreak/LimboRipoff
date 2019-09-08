package game.state;

import java.awt.Graphics;

import game.Handler;
import game.world.World;

public class Game {
	
	private World world;
	
	public Game(Handler handler) {
		world = new World(handler);
		handler.setWorld(world);
	}
	
	public void update() {
		world.update();
	}
	
	public void render(Graphics g) {
		world.render(g);
	}
	
	
}
