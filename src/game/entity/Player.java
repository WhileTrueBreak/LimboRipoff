package game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import game.Handler;
import game.collision.CollisionHandler;
import game.collision.CollisionLine;
import game.inputs.Binds;
import utils.Functions;
import utils.vector.Vector2;

public class Player extends Entity{

	private final float JUMP_FORCE = 1; //the force acted on one frame
	private final float SPEED = 10; //pixels per second^2 
	private final float AIR_SPEED = 1f; //pixels per second^2 
	
	private final float MAX_SLOPE_ANGLE = 45;
	private final float ON_GROUND_FRICTION = 0.99f; //pixels per second^2 
	private final float IN_AIR_FRICTION = 0.999f; //pixels per second^2 
	
	private Vector2 acc = Vector2.ZERO.copy();
	private Vector2 vel = Vector2.ZERO.copy();
	
	private boolean onGround = false;
	
	public Player(Handler handler, int x, int y) {
		super(handler, x, y);
		hitbox = new Rectangle(0, 0, 10, 20);
	}

	@Override
	public void update() {
		System.out.println(onGround);
		move();
		updateMotion();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect((int)(pos.getX()-handler.getCamera().getXoff()), (int)(pos.getY()-handler.getCamera().getYoff()), 10, 20);
	}
	
	public void applyForce(Vector2 force) {
		acc.add(force.copy().mult((float)handler.getSpeedMult()));
	}
	
	private void move() {
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_RIGHT)&&onGround) applyForce(Vector2.RIGHT.copy().setMag(SPEED));
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_LEFT)&&onGround) applyForce(Vector2.LEFT.copy().setMag(SPEED));
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_RIGHT)&&!onGround) applyForce(Vector2.RIGHT.copy().setMag(AIR_SPEED));
		if(handler.getKeyManager().isKeyPressed(Binds.MOVE_LEFT)&&!onGround) applyForce(Vector2.LEFT.copy().setMag(AIR_SPEED));
		if(handler.getKeyManager().isKeyPressed(Binds.JUMP)&&onGround) acc.add(Vector2.UP.copy().setMag(JUMP_FORCE));
	}
	
	private void updateMotion() {
		onGround = false;
		vel.add(acc);
		Vector2 tmpPos = Vector2.add(pos.copy(), vel.copy());
		ArrayList<CollisionLine> lines = CollisionHandler.getCollision(hitbox, pos.copy(), tmpPos.copy(), handler.getLayerManager().getLayer(handler.getGame().getCurrentPlayerLayer()).getCollisionLineManager().getLines());
		for(CollisionLine line:lines) {
			//CollisionNormal
			double perpendicularGrad = -1/line.getGradient();
	        double lineAngle = Math.atan2(perpendicularGrad,1);
	        Vector2 collisionNormal = Vector2.fromAngle(lineAngle);
	        float dot = collisionNormal.dot(vel);
	        collisionNormal.setMag(Math.signum(dot));
	        //SlopeAngle
	        double slopeAngle = Math.abs(Functions.toDegree(Math.atan2(line.getGradient(),1)));
	        if(pos.getY()-line.getPoint1().getY()>line.getGradient()*(pos.getX()-line.getPoint1().getY())) slopeAngle+=180;
	        //if slope is angle less than max angle
	        if(slopeAngle < MAX_SLOPE_ANGLE){
	          //set on ground to true
	          onGround = true;
	          vel.setY(0);
	        }
	        //adjust vel to collision
	        vel = Functions.slide(collisionNormal, vel);
	        tmpPos = Vector2.add(pos, vel);
		}
		pos.add(vel);
		if(onGround) vel.setX((float)(vel.getX()*ON_GROUND_FRICTION));
		else vel.setX((float)(vel.getX()*IN_AIR_FRICTION));
		vel.setY((float)(vel.getY()*IN_AIR_FRICTION));
		acc.mult(0);
	}
	
}
