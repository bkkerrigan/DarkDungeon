package dungeon;

import java.awt.Image;

public abstract class Structure extends Entity implements Drawable {
	
	Image image;
	
	public Structure(){
		
	}
	
	public void setPosX(int x){
		pos_x = x;
	}
	
	public void setPosY(int y){
		pos_y = y;
	}


}
