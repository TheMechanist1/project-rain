package com.dminer.rain.graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;

	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite rocky_grass = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 7, 0, SpriteSheet.tiles);
	public static Sprite bricks = new Sprite(16, 0, 1, SpriteSheet.tiles);
	public static Sprite void_sprite = new Sprite(16, 0x1B87E0);

	public static Sprite bricks2 = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite bricks3 = new Sprite(16, 0, 3, SpriteSheet.tiles);
	public static Sprite wood = new Sprite(16, 1, 1, SpriteSheet.tiles);
	public static Sprite leaves = new Sprite(16, 1, 2, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 1, 3, SpriteSheet.tiles);

	public static Sprite player_still = new Sprite(16, 0, 13, SpriteSheet.tiles);
	public static Sprite player_down_0 = new Sprite(16, 0, 14, SpriteSheet.tiles);
	public static Sprite player_down_1 = new Sprite(16, 0, 15, SpriteSheet.tiles);
	public static Sprite player_left_0 = new Sprite(16, 1, 13, SpriteSheet.tiles);
	public static Sprite player_left_1 = new Sprite(16, 1, 14, SpriteSheet.tiles);
	public static Sprite player_right_0 = new Sprite(16, 2, 13, SpriteSheet.tiles);
	public static Sprite player_right_1 = new Sprite(16, 2, 14, SpriteSheet.tiles);
	public static Sprite player_up_0 = new Sprite(16, 3, 13, SpriteSheet.tiles);
	public static Sprite player_up_1 = new Sprite(16, 3, 14, SpriteSheet.tiles);

	public static Sprite randomEntity = new Sprite(16, 0, 5, SpriteSheet.tiles);
	
	public static Sprite arrow = new Sprite(16, 0, 4, SpriteSheet.tiles);
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int size, int color) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void setColor(int color) {
		for (int i = 0; i < SIZE * SIZE; i++) {
			pixels[i] = color;
		}

	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
