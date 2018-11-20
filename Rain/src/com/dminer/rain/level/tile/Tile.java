package com.dminer.rain.level.tile;

import com.dminer.rain.graphics.Screen;
import com.dminer.rain.graphics.Sprite;
import com.dminer.rain.level.tile.spawn_level.LeaveTile;
import com.dminer.rain.level.tile.spawn_level.WaterTile;
import com.dminer.rain.level.tile.spawn_level.WoodTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	// Tiles
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.void_sprite);
	public static Tile rockygrass = new RockyGrassTile(Sprite.rocky_grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile bricks = new BrickTile(Sprite.bricks);
	public static Tile brick2 = new BrickTile(Sprite.bricks2);
	public static Tile brick3 = new BrickTile(Sprite.bricks3);
	public static Tile wood = new WoodTile(Sprite.wood);
	public static Tile leaves = new LeaveTile(Sprite.leaves);
	public static Tile water = new WaterTile(Sprite.water);

	public final static int col_grass = 0xFF00FF21;
	public final static int col_rockygrass = 0xFF808080;
	public final static int col_flower = 0xFFFFD800;
	public final static int col_bricks = 0xFFFF0000;
	public final static int col_wood = 0xFF915A3E;
	public final static int col_leaves = 0xFFB6FF00;
	public final static int col_water = 0xFF0026FF;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}
}
