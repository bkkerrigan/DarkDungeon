package dungeon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class Door extends Structure{

	public Door(int x, int y){
		image = Toolkit.getDefaultToolkit().getImage("/home/brendan/workspace/RandomDungeonGenerator/src/dungeon/resources/pics/door.jpg");
		pos_x = x;
		pos_y = y;
	}
	@Override
	public void draw(Graphics g, int graphicsScale) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, pos_x * 30, pos_y * 30, 30, 30, null);
	}
	

}
