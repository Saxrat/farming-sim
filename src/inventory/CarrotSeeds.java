package inventory;

import processing.core.PApplet;
import processing.core.PImage;

public class CarrotSeeds extends Inventory {

	PImage carrotseeds;
	String carrotname;
	int packetshifter = 3;
	int num;
	private final static int VALUE = 25;

	public CarrotSeeds(PApplet p, int number) {
		super(p);
		carrotname = "../Assets/Carrotpacket.png";
		carrotseeds = window.loadImage(carrotname);
		num = number;

	}
	
	public int returnValue() {
		return VALUE;
	}
	
	public String returnName() {
		return carrotname;
	}

	public void drawItem(int height, int width, int heightShifter) {
		window.strokeWeight(5);
		window.stroke(234, 211, 166);

		window.fill(200, 150, 0);
		window.rect(height * 50 + 75, width * 50 + 25 + heightShifter, 50, 50);
		window.image(carrotseeds, height * 50 + 50, (float) (width * 50 + heightShifter + packetshifter), 50, 50);
		if (num > 1) {
			window.fill(0);
			window.text(num, height * 50 + 80, width * 50 + heightShifter + 45);
		}

	}

	public int getNum() {
		return num;
	}

	public void add() {
		num++;
	}

	public void remove() {
		num--;
	}
}
