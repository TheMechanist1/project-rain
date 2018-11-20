package com.dminer.rain.entity.projectile;

import com.dminer.rain.entity.Entity;
import com.dminer.rain.graphics.Sprite;

public class Projectile extends Entity {
	
	final protected int xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage;
	
	
	
	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x=x;
		this.y=y;
		
	}
	protected void move() {
		
	}

}
