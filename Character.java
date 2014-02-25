package dungeon;

import java.awt.Graphics;

public abstract class Character extends Entity implements Drawable{

	public void setPosX(int x){
		pos_x = x;
	}
		
	public void setPosY(int y){
		pos_y = y;
	}

	

}
