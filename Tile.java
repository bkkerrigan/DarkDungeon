package dungeon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Tile extends Entity implements Drawable {
	

	Image dirt = Toolkit.getDefaultToolkit().getImage("/home/brendan/workspace/RandomDungeonGenerator/src/dungeon/resources/pics/dirt.jpg");
	Image rock = Toolkit.getDefaultToolkit().getImage("/home/brendan/workspace/RandomDungeonGenerator/src/dungeon/resources/pics/blackrock.jpg");
	Image selectedImage;
	
	boolean carved;
	boolean visible;
	
	public Tile(int x, int y){
		pos_x = x;
		pos_y = y;
		visible = false;
	}
	
	public void setCarved(boolean state){
		carved = state;
	}
	
	public boolean isCarved(){
		return carved;
	}
	
	public void setVisible(boolean b){
		visible = b;
	}
	public boolean isVisible(){
		return visible;
	}
	
	public void setPosX(int x){
		pos_x = x;
	}
	
	public void setPosY(int y){
		pos_y = y;
	}
	
	@Override
	public void draw(Graphics g, int graphicsScale) {
		// TODO Auto-generated method stub
		
		int dim = 30;
		Graphics2D g2 = (Graphics2D) g;
		
		
		if(visible){
			if(isCarved())
				selectedImage = dirt;
			else
				selectedImage = rock;
			g2.drawImage(selectedImage, pos_x*dim, pos_y*dim, dim, dim, null);
		}
		else{
			g2.setColor(Color.black);
			g2.fillRect(pos_x*dim, pos_y*dim, dim, dim);
		}
		

	}

}
