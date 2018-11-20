package com.dminer.rain.entity.mob;

import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;

public class RandomEntity extends Mob{
	int time = 0;
	int health = 100;
	private boolean walking = false;
	
	public RandomEntity(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public void update() {
		
		time++;
		if(time > 60) {
			
		int ya = (int) (Math.random() * 2);
		int xa = (int) (Math.random() * 2);
		System.out.println(xa + " " + ya);
		
		if (ya != 1) dir = 0;
		if (xa == 1) dir = 1;
		if (ya == 1) dir = 2;
		if (xa != 1) dir = 3;
		
	
		
		if (dir == 0) x++;
		if (dir == 1) y++;
		if (dir == 2) x--;
		if (dir == 3) y--;
		
		
		xa = 0;
		ya = 0;
		time = 0;
		}
	}
	public void render(Screen screen) {
		
		screen.renderEntity(x - 16, y - 16, Sprite.randomEntity);
	}
	
	
}
