package com.dminer.rain.entity.projectile;

import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;

public class Arrow extends Projectile {

	public static final int ROF = 5;

	public Arrow(int x, int y, double dir) {
		super(x, y, dir);
		range = 70;
		speed = 3;
		damage = 10;
		sprite = Sprite.arrow;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	@Override
	public void update() {
		if (level.tileCollison(x, y, nx, ny, 3)) remove ();
		move();
	}

	@Override
	protected void move() {

		x += nx;
		y += ny;
		if (distance() > range) remove();

	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x) + (yOrigin - y) * (yOrigin - y)));
		return dist;

	}

	@Override
	public void render(Screen screen) {
		screen.renderPlayer((int) x, (int) y + 3, sprite);
	}
}
