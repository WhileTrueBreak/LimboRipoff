package game.display;

import game.Handler;
import game.entity.Entity;

public class Camera {
	
	private Handler handler;
	private float xoff, yoff;
	
	public Camera(Handler handler, float xoff, float yoff) {
		this.handler = handler;
		this.xoff = xoff;
		this.yoff = yoff;
	}
	
	public void focusOnEntity(Entity e, int spring) {
		float cameraSpring = spring;
		float setX = e.getX()-handler.getDisplay().getJFrame().getWidth()/2;
		float setY = e.getY() - handler.getDisplay().getJFrame().getHeight()/2;
		if(cameraSpring == 0)
			move((setX-xoff), (setY-yoff));
		else
			move((setX-xoff)/cameraSpring, (setY-yoff)/cameraSpring);
	}
	
	public void focusOnPoint(int x, int y, int spring) {
		float cameraSpring = spring;
		float setX = x - handler.getDisplay().getJFrame().getWidth()/2;
		float setY = y - handler.getDisplay().getJFrame().getHeight()/2;
		if(cameraSpring == 0)
			move((setX-xoff), (setY-yoff));
		else
			move((setX-xoff)/cameraSpring, (setY-yoff)/cameraSpring);
	}
	
	public void move(float amtx, float amty) {
		xoff += amtx;
		yoff += amty;
	}

	public float getXoff() {
		return xoff;
	}

	public void setXoff(int xoff) {
		this.xoff = xoff;
	}

	public float getYoff() {
		return yoff;
	}

	public void setYoff(int yoff) {
		this.yoff = yoff;
	}
	
}
