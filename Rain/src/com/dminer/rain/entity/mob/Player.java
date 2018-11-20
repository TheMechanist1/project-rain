package com.dminer.rain.entity.mob;

import com.dminer.rain.Game;
import com.dminer.rain.entity.projectile.Arrow;
import com.dminer.rain.entity.projectile.Projectile;
import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;
import com.dminer.rain.input.Keyboard;
import com.dminer.rain.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;
	
	
	private int fireRate = 0;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_still;

	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		fireRate = Arrow.ROF;
	}

	@Override
	public void update() {
		if (fireRate > 0) fireRate --;
		int xa = 0, ya = 0;
		if (anim < 7000) anim++;
		else
			anim = 0;
		if (input.up) ya--;
		if (input.down) ya++;
		if (input.left) xa--;
		if (input.right) xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
		
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
		if (p.isRemoved()) level.getProjectiles().remove(i);
		}
		
	}

	private void updateShooting() {
		if (Mouse.getB() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = Arrow.ROF;
		}

	}

	@Override
	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.player_still;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_0;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_still;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_left_0;
				} else {
					sprite = Sprite.player_left_1;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_still;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_down_0;
				} else {
					sprite = Sprite.player_down_1;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_still;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_right_0;
				} else {
					sprite = Sprite.player_right_1;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite);

	}
	
	

}
