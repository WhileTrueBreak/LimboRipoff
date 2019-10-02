package game.ui;

import java.util.ArrayList;

import game.Handler;

public class UIComponent {
	
	private ArrayList<UIComponent> parentComponents;
	
	private int x, y, width, height;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
