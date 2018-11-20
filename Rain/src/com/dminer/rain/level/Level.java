package com.dminer.rain.level;

import java.util.ArrayList;
import java.util.List;

import com.dminer.rain.entity.Entity;
import com.dminer.rain.entity.projectile.Projectile;
import com.dminer.rain.graphics.Screen;
import com.dminer.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();

	public static Level spawn = new SpawnLevel("/levels/spawnLevel.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	protected Level(String path) {
		LoadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {
	}

	protected void LoadLevel(String path) {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	@SuppressWarnings("unused")
	private void time() {

	}

	public boolean tileCollison(double x, double y, double xa, double ya, int size) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (((int) x + (int) xa) + c % 2 * size * 4 + 2) / 16;
			int yt = (((int) y + (int) ya) + c / 2 * size * 3 + 7) / 16;
			if (getTile(xt, yt).solid()) solid = true;

		}
		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);

			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public void addProjectile(Projectile p) {
		p.init(this);
		projectiles.add(p);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		if (tiles[x + y * width] == Tile.col_grass) return Tile.grass;
		if (tiles[x + y * width] == Tile.col_rockygrass) return Tile.rockygrass;
		if (tiles[x + y * width] == Tile.col_flower) return Tile.flower;
		if (tiles[x + y * width] == Tile.col_wood) return Tile.wood;
		if (tiles[x + y * width] == Tile.col_leaves) return Tile.leaves;
		if (tiles[x + y * width] == Tile.col_bricks) return Tile.bricks;
		if (tiles[x + y * width] == Tile.col_water) return Tile.water;
		return Tile.voidTile;

	}

}
