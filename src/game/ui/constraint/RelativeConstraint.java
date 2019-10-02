package game.ui.constraint;

import game.ui.UIComponent;

public class RelativeConstraint extends UIConstraint {
	
	private float percentage;
	
	public RelativeConstraint(float percentage) {
		this.percentage = percentage;
	}

	@Override
	public int getX(UIComponent container) {
		return (int) (container.getX()+container.getWidth()*percentage);
	}

	@Override
	public int getY(UIComponent container) {
		return (int) (container.getY()+container.getHeight()*percentage);
	}

	@Override
	public int getWidth(UIComponent container) {
		return (int) (container.getWidth()*percentage);
	}

	@Override
	public int getHeight(UIComponent container) {
		// TODO Auto-generated method stub
		return (int) (container.getHeight()*percentage);
	}
	
}
