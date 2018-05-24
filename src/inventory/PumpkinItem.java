package inventory;

import processing.core.PApplet;
import processing.core.PImage;

public class PumpkinItem extends Inventory {
	String pumpkinname;
	PImage pumpkin;
	private final static int VALUE = 100;

	public PumpkinItem(PApplet p) {
		super(p);
		pumpkinname = "../Assets/pumpkin.png";
		pumpkin = window.loadImage(pumpkinname);
		num = 1;
		
	}
	
	public String returnName() {
		return pumpkinname;
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

		window.image(pumpkin, height * 50 + 50, width * 50 + heightshifter + 5, 50, 50);
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
