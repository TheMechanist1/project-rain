package com.dminer.rain.level.tile.spawn_level;

import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;
import com.dminer.rain.level.tile.Tile;

public class WaterTile extends Tile {
	
	public WaterTile(Sprite sprite) {
		super(sprite);

	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Sprite.water);
	}
	
	@Override
	public boolean solid() {
		return false;
	}

}
