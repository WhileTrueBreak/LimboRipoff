package game;

import game.display.Camera;
import game.inputs.KeyManager;
import game.inputs.MouseManager;
import game.world.LayerManager;
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
	
	public KeyManager getKeyManager() {
		return main.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return main.getMouseManager();
	}
	
	public Camera getCamera() {
		return main.getCamera();
	}

	public LayerManager getLayerManager() {
		return world.getLayerManager();
	}
	
	//https://pastebin.com/CGukyGrd
	public String getDir() {
		return System.getProperty("user.dir");
	}
	
}
