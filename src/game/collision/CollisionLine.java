package game.collision;

import utils.vector.Vector2;

public class CollisionLine {
	
	private String file;
	
	private Vector2 point1, point2;
	private double gradient;
	
	public CollisionLine(float x1, float y1, float x2, float y2, String file) {
		this.point1 = new Vector2(x1, y1);
		this.point2 = new Vector2(x2, y2);
		this.gradient = (y1-y2)/(x1-x2);
		this.file = file;
	}

	public Vector2 getPoint1() {
		return point1;
	}

	public Vector2 getPoint2() {
		return point2;
	}

	public double getGradient() {
		return gradient;
	}
	
	public String getFile() {
		return file;
	}
	
}
