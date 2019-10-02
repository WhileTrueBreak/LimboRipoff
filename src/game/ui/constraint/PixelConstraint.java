package game.ui.constraint;

import game.ui.UIComponent;

public class PixelConstraint extends UIConstraint {
	
	private int pixels;
	
	public PixelConstraint(int pixels) {
		this.pixels = pixels;
	}

	@Override
	public int getX(UIComponent container) {
		return container.getX()+pixels;
	}

	@Override
	public int getY(UIComponent container) {
		return container.getY()+pixels;
	}

	@Override
	public int getWidth(UIComponent container) {
		return pixels;
	}

	@Override
	public int getHeight(UIComponent container) {
		return pixels;
	}
	
}
