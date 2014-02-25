package dungeon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class Player extends Character{
	
	private Image image;
	
	public Player(){
		pos_x = 5;
		pos_y = 5;
		image = Toolkit.getDefaultToolkit().getImage("/home/brendan/workspace/RandomDungeonGenerator/src/dungeon/resources/pics/player.jpg");
	}
	
	@Override
	public void draw(Graphics g, int graphicsScale) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.drawImage(image, pos_x * 30, pos_y * 30, 30, 30, null);
	}
	
	public void goLeft(){
		pos_x = pos_x - 1;
	}
	public void goRight(){
		pos_x = pos_x + 1;
	}
	public void goUp(){
		pos_y = pos_y - 1;
	}
	public void goDown(){
		pos_y = pos_y + 1;
	}
}
