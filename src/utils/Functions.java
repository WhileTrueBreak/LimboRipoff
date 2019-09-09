package utils;

import utils.vector.Vector2;

public class Functions {
	
	public static double toDegree(double rad) {
		return rad*180/Math.PI;
	}
	
	public static double toRadian(double rad) {
		return rad*Math.PI/180;
	}
	
	public static Vector2 slide(Vector2 normal, Vector2 v) {
		return v.copy().sub(normal.copy().mult(normal.dot(v)));
	}
	
}
