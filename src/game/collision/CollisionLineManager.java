package game.collision;

import java.util.ArrayList;

public class CollisionLineManager {
	
	ArrayList<CollisionLine>lines = new ArrayList<CollisionLine>();
	
	public CollisionLineManager() {
		
	}
	
	public void addLine(CollisionLine line) {
		lines.add(line);
	}
	
	public void removeLine(CollisionLine line) {
		lines.remove(line);
	}
	
	public ArrayList<CollisionLine> getLinesFromFile(String file){
		ArrayList<CollisionLine> linesFromFile = new ArrayList<CollisionLine>();
		for(CollisionLine line:lines) {
			if(line.getFile()==file) linesFromFile.add(line);
		}
		return linesFromFile;
	}
	
	public ArrayList<CollisionLine> getLines(){
		return lines;
	}
	
}
