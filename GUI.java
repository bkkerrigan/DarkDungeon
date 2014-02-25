package dungeon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

public class GUI extends JFrame{

	private final int GRAPHICS_SCALE = 30;
	ArrayList<Entity> items;
	
	MouseMenu mouseMenu;
	boolean showMouseMenu = false;
	
	GUI(){
		items = new ArrayList<Entity>();
		mouseMenu = new MouseMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Deep Darkness");
		setSize(500, 1000);
		setVisible(true);
	}
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		
		for(int i = items.size() - 1; i > 0; i --){
			if(items.get(i) instanceof Drawable){
				((Drawable) items.get(i)).draw(g2, GRAPHICS_SCALE);
			}
		}
		
		if(mouseMenu.isVisible()){
			mouseMenu.draw(g2);
		}
		
	}
		
	public void setEntities(ArrayList<Entity> arrayList){
		items = arrayList;
	}
	
	
	
	
	public class MouseMenu{
		
		private int pos_x;
		private int pos_y;
		
		LinkedList<String> choices;
		Entity chosenEntity;
		
		boolean isVisible;
		
		
		public MouseMenu(){
			choices = new LinkedList<String>();
			choices.add("EAT");
			choices.add("MY");
			choices.add("SHORTS");
			choices.add("SHORTS");
			isVisible = false;
			setChosenEntity(null);
		}
		
		public void setMenuVisible(boolean choice){
			isVisible = choice;
		}
		
		public boolean isVisible(){
			return isVisible;
		}
		
		public void setChosenEntity(Entity e){
			chosenEntity = e;
		}
		
		public void draw(Graphics g) {
			
			Graphics2D g2 = (Graphics2D) g;
			
			g2.setColor(Color.darkGray);
			
			System.out.println(pos_x + " " + pos_y);
			g2.fillRect(pos_x, pos_y, 100, 25 * choices.size());
			
			for(int i = 0; i < choices.size(); i++){
				
				g2.setColor(Color.gray);
				g.fillRect(pos_x + 10, 7 + pos_y + 25 * i, 85, 15);
				g.setColor(Color.black);
				g.drawString(choices.get(i), pos_x + 10, 20 + pos_y+ 25 * i);
			}
		}
		
		public void setPosX(int x){
			pos_x = x;
		}
		public void setPosY(int y){
			System.out.println("y is" + pos_y);
			pos_y = y;
		}
	}
	
	
}
