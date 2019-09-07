package game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import utils.vector.Vector2;

public abstract class Entity {
	
	protected Handler handler;
	
	protected Vector2 pos;
	protected Rectangle hitbox;
	
	public Entity(Handler handler, int x, int y) {
		this.handler = handler;
		pos = new Vector2(x, y);
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
}