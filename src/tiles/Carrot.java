package tiles;

import processing.core.PApplet;
import processing.core.PImage;

public class Carrot extends Plant {
	String seedname;
	String seedlingname;
	String juvenilename;
	String maturename;
	PImage juvenile;
	PImage seeds;
	PImage seedlings;
	PImage mature;
	int age;
	public final static int SEEDLING_AGE = 20;
	public final static int JUVENILE_AGE = 50;
	public final static int MATURITY_AGE = 100;

	public Carrot(float x, float y, PApplet p) {
		super(x, y, p);
		seedname = "../Assets/carrotseeds.png";
		seedlingname = "../Assets/carrot seedlings.png";
		juvenilename = "../Assets/carrotjuvenile.png";
		maturename = "../Assets/carrotharvest.png";
		juvenile = window.loadImage(juvenilename);
		seeds = window.loadImage(seedname);
		seedlings = window.loadImage(seedlingname);
		mature = window.loadImage(maturename);
		age = 0;

	}
	
	public void age() {
		if(watered)
		age++;
	}
	
	public boolean isHarvestable() {
		if(age >= MATURITY_AGE) {
			return true;
		}else {
			return false;
		}
	}

	public void drawTile() {

		if (watered) {
			window.image(wateredsoil, x * 50, y * 50, 50, 50);
		} else {
			window.image(drysoil, x * 50, y * 50, 50, 50);
		}
		if (age < SEEDLING_AGE) {
			window.image(seeds, x * 50, y * 50, 50, 50);
		} else if(age < JUVENILE_AGE){
			window.image(seedlings, x * 50, y * 50, 50, 50);
		}else if(age < MATURITY_AGE){
			window.image(juvenile, x*TILE_SCALING, y * TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}else {
			window.image(mature, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}

	}

}
