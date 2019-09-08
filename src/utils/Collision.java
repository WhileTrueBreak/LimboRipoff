package utils;

public class Collision {

	public static boolean lineLine(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		double uA = ((x4-x3)*(y1-y3) - (y4-y3)*(x1-x3)) / ((y4-y3)*(x2-x1) - (x4-x3)*(y2-y1));
		double uB = ((x2-x1)*(y1-y3) - (y2-y1)*(x1-x3)) / ((y4-y3)*(x2-x1) - (x4-x3)*(y2-y1));
		if (uA >= 0 && uA <= 1 && uB >= 0 && uB <= 1) return true;
		return false;
	}

	public static boolean lineCircle(float x1, float y1, float x2, float y2, float cx, float cy, float r) {
		boolean inside1 = pointCircle(x1,y1, cx,cy,r);
		boolean inside2 = pointCircle(x2,y2, cx,cy,r);
		if (inside1 || inside2) return true;
		double distX = x1 - x2;
		double distY = y1 - y2;
		double len = Math.sqrt( (distX*distX) + (distY*distY) );
		double dot = (((cx-x1)*(x2-x1)) + ((cy-y1)*(y2-y1)) ) / Math.pow(len,2);
		double closestX = x1 + (dot * (x2-x1));
		double closestY = y1 + (dot * (y2-y1));
		boolean onSegment = linePoint(x1,y1,x2,y2,(float)closestX,(float)closestY);
		if (!onSegment) return false;
		distX = closestX - cx;
		distY = closestY - cy;
		double distance = Math.sqrt( (distX*distX) + (distY*distY) );
		if (distance <= r) return true;
		return false;
	}

	public static boolean pointCircle(float px, float py, float cx, float cy, float r) {
		double distX = px - cx;
		double distY = py - cy;
		double distance = Math.sqrt( (distX*distX) + (distY*distY) );
		if (distance <= r) return true;
		return false;
	}

	public static boolean linePoint(float x1, float y1, float x2, float y2, float px, float py) {
		double d1 = Math.hypot(px-x1,py-y1);
		double d2 = Math.hypot(px-x2,py-y2);
		double lineLen = Math.hypot(x1-x2,y1-y2);
		double buffer = 0.1;    // higher # = less accurate
		if (d1+d2 >= lineLen-buffer && d1+d2 <= lineLen+buffer) return true;
		return false;
	}

	public static boolean lineRect(float x1, float y1, float x2, float y2, float rx, float ry, float rw, float rh) {
		boolean left =   lineLine(x1,y1,x2,y2, rx,ry,rx, ry+rh);
		boolean right =  lineLine(x1,y1,x2,y2, rx+rw,ry, rx+rw,ry+rh);
		boolean top =    lineLine(x1,y1,x2,y2, rx,ry, rx+rw,ry);
		boolean bottom = lineLine(x1,y1,x2,y2, rx,ry+rh, rx+rw,ry+rh);
		if (left || right || top || bottom) return true;
		return false;
	}

}
