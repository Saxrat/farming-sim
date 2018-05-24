package inventory;

import processing.core.PApplet;
import processing.core.PImage;

public class CarrotItem extends Inventory {
	String carrotname;
	PImage carrot;
	protected final static int VALUE = 50;

	public CarrotItem(PApplet p) {
		super(p);
		carrotname = "../Assets/carrot.png";
		carrot = window.loadImage(carrotname);
		num = 1;
		
	}
	
	public String returnName() {
		return carrotname;
	}
	
	public int returnValue() {
		return VALUE;
	}

	public void drawItem(int height, int width, int heightshifter) {

		window.strokeWeight(5);
		window.stroke(234, 211, 166);

		window.fill(200, 150, 0);
		window.rect(height * 50 + 75, width * 50 + 25 + heightshifter, 50, 50);
		window.strokeWeight(1);
		window.stroke(0);

		window.image(carrot, height * 50 + 50, width * 50 + heightshifter, 50, 50);
		window.fill(0);
		if (num > 1) {
			window.text(num, height * 50 + 90, width * 50 + heightshifter + 45);
		}
	}

	public void add() {
		num++;
	}

	public void remove() {
		num--;
	}
}
