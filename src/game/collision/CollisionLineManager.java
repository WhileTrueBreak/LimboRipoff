package game.collision;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import game.Handler;

public class CollisionLineManager {
	
	private Handler handler;
	
	ArrayList<CollisionLine>lines = new ArrayList<CollisionLine>();
	
	public CollisionLineManager(Handler handler) {
		this.handler = handler;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		for(CollisionLine line:lines)
			g.drawLine((int)(line.getPoint1().getX()+handler.getCamera().getXoff()), 
					(int)(line.getPoint1().getY()+handler.getCamera().getXoff()), 
					(int)(line.getPoint2().getX()+handler.getCamera().getXoff()), 
					(int)(line.getPoint2().getY()+handler.getCamera().getXoff()));
	}
	
	public void addLine(CollisionLine line) {
		lines.add(line);
	}
	
	public void removeLine(CollisionLine line) {
		lines.remove(line);
	}
	
	public ArrayList<CollisionLine> getLinesFromFile(String file){
		ArrayList<CollisionLine> linesFromFile = new ArrayList<CollisionLine>();
		for(CollisionLine line:lines)
			if(line.getFile()==file) linesFromFile.add(line);
		return linesFromFile;
	}
	
	public ArrayList<CollisionLine> getLines(){
		return lines;
	}
	
}
