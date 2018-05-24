package tiles;

import processing.core.PApplet;
import processing.core.PImage;

public class Pumpkin extends Plant{
	String seedname;
	String seedlingname;
	String juvenilename;
	String floweringname;
	String immaturename;
	String maturename;
	PImage juvenile;
	PImage seeds;
	PImage seedlings;
	PImage flowering;
	PImage immature;
	PImage mature;
	int age;
	public final static int SEEDLING_AGE = 20;
	public final static int JUVENILE_AGE = 50;
	public final static int FLOWERING_AGE = 100;
	public final static int IMMATURE_AGE = 150;
	public final static int MATURITY_AGE = 200;

	public Pumpkin(float x, float y, PApplet p) {
		super(x, y, p);
		seedname = "../Assets/pumpkinseeds.png";
		seedlingname = "../Assets/pumpkinseedling.png";
		juvenilename = "../Assets/pumpkinjuvenile.png";
		floweringname = "../Assets/pumpkinflower.png";
		immaturename = "../Assets/pumpkinimmature.png";
		maturename = "../Assets/pumpkinmature.png";
		juvenile = window.loadImage(juvenilename);
		seeds = window.loadImage(seedname);
		seedlings = window.loadImage(seedlingname);
		mature = window.loadImage(maturename);
		flowering = window.loadImage(floweringname);
		immature = window.loadImage(immaturename);
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
	
		}else if(age < FLOWERING_AGE){
			window.image(juvenile, x*TILE_SCALING, y * TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}else if(age < IMMATURE_AGE){
			window.image(flowering, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}else if(age < MATURITY_AGE) {
			window.image(immature, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}else {
			window.image(mature, x*TILE_SCALING, y*TILE_SCALING, TILE_SCALING, TILE_SCALING);
		}

	}
}
