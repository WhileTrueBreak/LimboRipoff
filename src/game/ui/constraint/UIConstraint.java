package game.ui.constraint;

import game.ui.UIComponent;

public abstract class UIConstraint {

	abstract public int getX(UIComponent container);
	abstract public int getY(UIComponent container);
	abstract public int getWidth(UIComponent container);
	abstract public int getHeight(UIComponent container);
	
}
