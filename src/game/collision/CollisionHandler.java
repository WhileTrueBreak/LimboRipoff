package game.collision;

import java.awt.Rectangle;
import java.util.ArrayList;

import utils.Collision;
import utils.vector.Vector2;

public class CollisionHandler {
	
	public static ArrayList<CollisionLine> getCollision(Rectangle hitbox, Vector2 oldPosition, Vector2 newPosition, ArrayList<CollisionLine> lines){
		ArrayList<CollisionLine> collidedLines = new ArrayList<CollisionLine>();
		for(CollisionLine cl:lines) {
			boolean collided = false;
			if(Collision.lineLine(cl.getPoint1().getX(), cl.getPoint1().getY(), cl.getPoint2().getX(), cl.getPoint2().getY(), 
					oldPosition.getX(), oldPosition.getY(), newPosition.getX(), newPosition.getY())) collided = true;
			if(Collision.lineRect(cl.getPoint1().getX(), cl.getPoint1().getY(), cl.getPoint2().getX(), cl.getPoint2().getY(), 
					newPosition.getX(), newPosition.getY(), hitbox.width, hitbox.height)) collided = true;
			if(collided) collidedLines.add(cl);
		}
		return collidedLines;
	}
	
}
