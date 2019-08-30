package game.entity;

import java.awt.Graphics;

import game.Handler;

public abstract class Entity {
	
	protected float speed;
	
	protected Handler handler;
	protected float x, y;
	
	public Entity(Handler handler, int x, int y) {
		this.handler = handler;
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
}