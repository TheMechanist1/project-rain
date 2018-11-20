package com.dminer.rain.level.tile;

import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;

public class RockyGrassTile extends Tile{

	public RockyGrassTile(Sprite sprite) {
		super(sprite);
	}

	@Override
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, Sprite.rocky_grass);
	}
	
	@Override
	public boolean solid() {
		return false;
	}
}
