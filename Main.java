package dungeon;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main {
	
	public static void main(String[] args){
		
		GUI view = new GUI();
		Game model = new Game();
		
		Controller controller = new Controller(view, model);

	}

	
}
