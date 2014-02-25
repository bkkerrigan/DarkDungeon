package dungeon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Toolkit;

public class Dungeon extends Level{
	
	Random rand = new Random();
	ArrayList<Entity> entities;
	
	Tile[][] map;
	
	int dimension;
	int startx;
	int starty;
	boolean lightsOn = false;
	
	public Dungeon(){	
		entities = new ArrayList<Entity>();
		dimension = 50;
		startx = 10;
		starty = 10;		
		map = new Tile[dimension][dimension];
		fillMap();
		for(int i = 0; i < 5; i++){
			carve(startx, starty, 500);
		}
	}
	public Tile[][] getMap(){
		return map;
	}
	public void carve(int x, int y, int count){	
		int direction = rand.nextInt(9);
		int newStart = rand.nextInt(20);

		if(newStart == 1){
			startx = x;
			starty = y;
		}
		if(count == 0){
			return;
		}
		map[x][y].setCarved(true);
		switch(direction){
			case(0):
				x++;
				break;
			case(1):
				x--;
				break;
			case(2):
				y++;
				break;
			case(3):
				y--;
				break;
			default:
				break;
		}
		if(isEdge(x, y)){
			x = startx;
			y = starty;
		}
		carve(x, y, count-1);
	}
	
	public boolean isEdge(int x, int y){
		return (x == 1) || (x == 19) || (y == 1) || (y == 19);
	}	
	public void fillMap(){
		for(int l = 0; l < dimension; l++){
			for(int w = 0; w < dimension; w++){
				map[l][w] = new Tile(l, w);
				entities.add(map[l][w]);
			}	
		}
	}
	
	/*
	public void draw(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		for(int l = 0; l < dimension; l++){
			for(int w = 0; w < dimension; w++){
				//if(map[l][w].isOnScreen())	
					map[l][w].draw(g2);
			}	
		}
		
	}*/
	
	public boolean notCarved(int x, int y){
		return !map[x][y].isCarved();
	}
	
	public void turnLightsOff(){
		for(int l = 0; l < dimension; l++){
			for(int w = 0; w < dimension; w++){
					map[l][w].setVisible(false);
					lightsOn = false;
			}	
		}
	}
	
	public void turnLightsOn(){
		for(int l = 0; l < dimension; l++){
			for(int w = 0; w < dimension; w++){
					map[l][w].setVisible(true);
					lightsOn = true;
			}	
		}
	}
	
	public boolean checkLightsOn(){
		return lightsOn;
	}
	
	public void visibleTiles(int x, int y, int radius){
		for(int l = x; l < radius + x; l++){
			for(int w = y; w < radius + y; w++){
				map[l][w].setVisible(true);
			}
		}
	}
	
	public void setTilesInView(int x, int y, int radius){
		for(int l = x; l < radius + x; l++){
			for(int w = y; w < radius + y; w++){
				map[l][w].setVisible(true);
			}
		}
	}
	
	@Override
	public ArrayList<Entity> collectEntities() {
		return entities;
	}

	
}
