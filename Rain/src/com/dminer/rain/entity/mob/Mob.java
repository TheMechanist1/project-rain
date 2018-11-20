package com.dminer.rain.entity.mob;



import java.util.Random;

import com.dminer.rain.entity.Entity;
import com.dminer.rain.entity.projectile.Arrow;
import com.dminer.rain.entity.projectile.Projectile;
import com.dminer.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected final Random random = new Random();

	
	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (ya < 0) dir = 0;
		if (xa > 0) dir = 1;
		if (ya > 0) dir = 2;
		if (xa < 0) dir = 3;

		if (!collison(xa, ya)) {
			x += xa;
			y += ya;
		}
		
	
	}
	
	

	@Override
	public void update() {
	}

	protected void shoot(int x, int y, double dir) {
		//dir *= 180 / Math.PI;
		Projectile p = new Arrow(x-16, y-16, dir);
		level.addProjectile(p);
		
		
	}

	protected boolean collison(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 2 - 10) / 16;
			int yt = ((y + ya) + c / 2 * 2 - 3) / 16;
			if (level.getTile(xt, yt).solid()) solid = true;

		}
		return solid;
	}

	public void render() {
	}
}
