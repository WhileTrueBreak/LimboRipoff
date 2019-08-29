package game;

import game.world.World;

public class Handler {
	
	private Main main;
	private World world;
	
	public Handler(Main main) {
		this.main = main;
	}

	public Main getMain() {
		return main;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	//https://pastebin.com/CGukyGrd
	public String getDir() {
		return System.getProperty("user.dir");
	}
	
}
