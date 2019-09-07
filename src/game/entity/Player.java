package game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;
import game.inputs.Binds;
import utils.vector.Vector2;

public class Player extends Entity{

	private final float JUMP_FORCE = 20;
	private final float SPEED = 4;
	
	private Vector2 acc = Vector2.ZERO;
	private Vector2 vel = Vector2.ZERO;
	
	public Player(Handler handler, int x, int y) {
		super(handler, x, y);
		hitbox = new Rectangle(0, 0, 10, 20);
	}

	@Override
	public void update() {
		move();
		//TODO refactor updateMovement
		updateMotion();
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	private void applyForce(Vector2 force) {
		acc.add(force);
	}
	
	private void move() {
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_RIGHT)) applyForce(Vector2.RIGHT.setMag(SPEED));
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_LEFT)) applyForce(Vector2.LEFT.setMag(SPEED));
		if(handler.getKeyManager().isKeyPressed(Binds.JUMP)) applyForce(Vector2.UP.setMag(JUMP_FORCE));
	}
	
	private void updateMotion() {
		vel.add(acc);
		Vector2 tmpPos = Vector2.add(pos, vel);
		/*check collisions function
		 * input hitbox and position
		 * output all lines that were collided with
		 * 
		 * collidedLines = collideTest(hitbox, position);
		 * for(line in collidedLines)
		 *     collision math
		**/
		pos.add(vel);
	}
	
}
