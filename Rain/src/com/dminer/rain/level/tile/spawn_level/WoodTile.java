package com.dminer.rain.level.tile.spawn_level;

import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;
import com.dminer.rain.level.tile.Tile;

public class WoodTile extends Tile {
	
	public WoodTile(Sprite sprite) {
		super(sprite);

	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Sprite.wood);
	}
	
	@Override
	public boolean solid() {
		return true;
	}

}
