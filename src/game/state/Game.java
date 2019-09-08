package game.state;

import java.awt.Graphics;

import game.Handler;
import game.entity.Player;
import game.world.World;

public class Game {
	
	private World world;
	
	private Player player;
	
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
	
	public void loadSave(String file) {
		//load from save
	}
	
}
