package game.entity;

import java.awt.Graphics;

import game.Handler;
import game.inputs.Binds;

public class Player extends Entity{

	public Player(Handler handler, int x, int y) {
		super(handler, x, y);
	}

	@Override
	public void update() {
		move();
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	private void move() {
		float dx = 0;
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_RIGHT))dx+=speed;
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_LEFT))dx-=speed;
		//check collision of dx
		//move dx
		//check collision of dy
		//move dy
	}
	
}
