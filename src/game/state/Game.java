package game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game.Handler;
import game.entity.Player;
import game.inputs.Binds;
import game.world.World;
import utils.vector.Vector2;

public class Game {
	
	private Handler handler;
	
	private World world;
	
	private Player player;
	private int currentPlayerLayer = 1;
	
	public Game(Handler handler) {
		this.handler = handler;
		world = new World(handler);
		player = new Player(handler, 200, 0);
	}
	
	public void update() {
		if(handler.getKeyManager().isKeyPressed(KeyEvent.VK_R)) player = new Player(handler, 200, 0);
		
		world.update();
		player.applyForce(Vector2.DOWN.copy().setMag(World.GRAVITY));
		player.update();
		handler.getCamera().focusOnEntity(player, 150);
	}
	
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.setColor(Color.red);
	    g.drawString(Integer.toString((int) Math.round(handler.getCurrentFps())) + "fps", handler.getWidth()-50, 20);
	}
	
	public void loadSave(String file) {
		//load from save
	}

	public int getCurrentPlayerLayer() {
		return currentPlayerLayer;
	}

	public void setCurrentPlayerLayer(int currentPlayerLayer) {
		this.currentPlayerLayer = currentPlayerLayer;
	}
	
}
