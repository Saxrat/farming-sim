package tiles;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Plant extends Tile{
int age;
int moisture;
boolean watered;
String watereddirtname = "../Assets/wateredsoil.png";
String drydirtname = "../Assets/drysoil.png";
PImage wateredsoil;
PImage drysoil;

	public Plant(float x, float y, PApplet p) {
		super(x, y, p);
		age = 0;
		watered = false;
		moisture = 0;
		wateredsoil = window.loadImage(watereddirtname);
		drysoil = window.loadImage(drydirtname);
	}
	
	public void drawTile() {
		if (watered) {
			window.fill(58, 50, 33);
		}else {
			window.fill(124, 107, 71);
		}
		window.rect(x * 50 + 25, y * 50 + 25, 50, 50);
		window.fill(239, 228, 186);
		window.ellipse(x*50 + 25, y*50 + 25, 25, 15);

	}
	
	
	public void age() {
		age++;
		if(moisture != 0) {
			moisture--;
		}
	}

	public void setWatered() {
		watered = true;
	}

	public void setDry() {
		watered = false;
	}
	
	public void water() {
		setWatered();
		moisture = 1000;
		
	}
	
}
