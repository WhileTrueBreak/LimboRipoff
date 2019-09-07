package utils.vector;

public class Vector2 {
	
	public final static Vector2 DOWN = new Vector2(0, 1);
	public final static Vector2 UP = new Vector2(0, -1);
	public final static Vector2 LEFT = new Vector2(-1, 0);
	public final static Vector2 RIGHT = new Vector2(1, 0);
	public final static Vector2 ONE = new Vector2(1, 1);
	public final static Vector2 ZERO = new Vector2(0, 0);
	
	private float x, y;
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public double magnitude() {
		return Math.hypot(x, y);
	}
	
	public void mult(float n) {
		x *= n;
		y *= n;
	}
	
	public void div(float n) {
		x /= n;
		y /= n;
	}
	
	public void add(Vector2 v) {
		x += v.getX();
		y += v.getY();
	}
	
	public void sub(Vector2 v) {
		x -= v.getX();
		y -= v.getY();
	}
	
	public float dot(Vector2 v) {
		return x*v.getX()+y*v.getY();
	}
	
	public void normalize() {
		x /= magnitude();
		y /= magnitude();
	}
	
	public Vector2 setMag(float mag) {
		normalize();
		x *= mag;
		y *= mag;
		return this;
	}
	
	public Vector2 copy() {
		return new Vector2(x, y);
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float[] array() {
		float[] arr  = {x, y};
		return arr;
	}

	/**STATIC METHODS**/
	
	public static Vector2 add(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.getX()+v2.getX(), v1.getY()+v2.getY());
	}
	
	public static Vector2 sub(Vector2 v1, Vector2 v2) {
		return new Vector2(v1.getX()-v2.getX(), v1.getY()-v2.getY());
	}
}
