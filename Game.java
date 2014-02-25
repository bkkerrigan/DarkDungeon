package dungeon;

import java.util.ArrayList;

public class Game implements EntityHost {
	
	ArrayList<Drawable> drawables;
	ArrayList<Entity> entities;
	
	public Player player;
	public Dungeon dungeon;
	
	public Game(){
		player = new Player();
		dungeon = new Dungeon();
		
		entities = new ArrayList<Entity>();
		loadEntities();
	}
	
	
	private void loadEntities(){
		entities.add(dungeon);
		entities.add(player);
		entities.add(new Door(5, 5));
		
	}
	
	@Override
	public ArrayList<Entity> collectEntities() {
		for(int i = 0; i < entities.size(); i++){
			Entity entity = entities.get(i);
			if(entity instanceof EntityHost){	
				for(Entity e: ((EntityHost) entity).collectEntities()){				
					if(!entities.contains(e)){
						Entity ent = e;
						entities.add(ent);
					}		
				}	
			}
		}

		return entities;
	}
	
	
}
