package tiles;

import processing.core.PApplet;
import processing.core.PImage;

public class Grass extends Tile{
	PImage grass;

	String imagename = "../Assets/grass.png";
	public Grass(float x, float y, PApplet p) {
		super(x, y, p);
		grass = window.loadImage(imagename);
	}
	
	public void drawTile() {
		window.image(grass, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		
	}
}
