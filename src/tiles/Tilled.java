package tiles;

import processing.core.PApplet;
import processing.core.PImage;

public class Tilled extends Tile {
	boolean watered;
	String watereddirtname = "../Assets/wateredsoil.png";
	String drydirtname = "../Assets/drysoil.png";
	PImage wateredsoil;
	PImage drysoil;
	
	public Tilled(float x, float y, PApplet p) {
		super(x, y, p);
		watered = false;
		wateredsoil = window.loadImage(watereddirtname);
		drysoil = window.loadImage(drydirtname);
	}

	public void drawTile() {
		if (watered) {
			window.image(wateredsoil, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}else {
			window.image(drysoil, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}
		

	}

	public void setWatered() {
		watered = true;
	}

	public void setDry() {
		watered = false;
	}
}
