package dungeon;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Controller {
	
	GUI gui;
	Game model;
	ArrayList<Drawable> drawThese;
	
	public Controller(){
		
	}
	
	public Controller(GUI g, Game m){
		
		MouseButtonListener mouseButts = new MouseButtonListener();
		MouseMoveListener mouseMoves = new MouseMoveListener();
		
		gui = g;
		model = m;
		gui.addKeyListener(new keyListen());
		gui.addMouseListener(mouseButts);
		gui.addMouseMotionListener(mouseMoves);
		
		update();
		
	}
	
	private class keyListen implements KeyListener{
		
		/**
		 * KEYS
		 * 
		 * 37 = left
		 * 38 = up
		 * 39 = right
		 * 40 = down
		 */
		
		int key;
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			key = arg0.getKeyCode();
			switch(key){
				case(32):
					if(model.dungeon.checkLightsOn())
						model.dungeon.turnLightsOff();
					else
						model.dungeon.turnLightsOn();
					break;
				case(37):
					model.player.goLeft();
					if(model.dungeon.notCarved(model.player.getPosX(), model.player.getPosY()))
						model.player.goRight();
					break;
				case(38):
					model.player.goUp();
					if(model.dungeon.notCarved(model.player.getPosX(), model.player.getPosY()))
						model.player.goDown();
					break;
				case(39):
					model.player.goRight();
					if(model.dungeon.notCarved(model.player.getPosX(), model.player.getPosY()))
						model.player.goLeft();
					break;
				case(40):
					model.player.goDown();
					if(model.dungeon.notCarved(model.player.getPosX(), model.player.getPosY()))
						model.player.goUp();
					break;
			}	
			update();
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
		}
		@Override
		public void keyTyped(KeyEvent arg0) {	
		}	
	}

	private class MouseButtonListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			int button = arg0.getButton();
			System.out.println(button);
			switch(button){
				
				case(1):
					for(Entity item: model.collectEntities()){
						if(arg0.getX() / 30 == item.getPosX() && arg0.getY() / 30 == item.getPosY())
							System.out.println("You clicked" + item.toString());
					}
					
					System.out.println(arg0.getX() + " " + arg0.getY());
					
					gui.mouseMenu.setMenuVisible(false);
					update();
					break;
				case(2):
					break;
				case(3):
					for(Entity item: model.collectEntities()){
						if(arg0.getX() / 30 == item.getPosX() && arg0.getY() / 30 == item.getPosY())
							System.out.println("You clicked" + item.toString());
					}
				
					gui.mouseMenu.setMenuVisible(true);
					
					System.out.println(arg0.getX() + " " + arg0.getY());

					
					gui.mouseMenu.setPosX(arg0.getX());
					System.out.println("my y is " + arg0.getY());
					gui.mouseMenu.setPosY(arg0.getY());
					
					break;
				default:
					break;
			}
			
			update();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
	}
	
	private class MouseMoveListener implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent arg0) {
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {		
		}
		
	}
	
	public void update(){
		
		if(!model.dungeon.checkLightsOn()){
			model.dungeon.turnLightsOff();
		}
		
		model.dungeon.visibleTiles(model.player.getPosX() - 2, model.player.getPosY() - 2, 5);
		
		gui.setEntities(model.collectEntities());
		gui.repaint();
	}
	
}

