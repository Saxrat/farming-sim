package inventory;

import processing.core.PApplet;
import processing.core.PImage;

public class PumpkinSeeds extends Inventory{
int num;
String pumpkinseedname;
PImage pumpkinseeds;
int packetshifter = 5;
public static final int VALUE = 20;

	
	public PumpkinSeeds(PApplet p, int number) {
		super(p);
		num = number;
		pumpkinseedname = "../Assets/pumpkinseedpacket.png";
		pumpkinseeds = window.loadImage(pumpkinseedname);
	}
	
	public String returnName() {
		return pumpkinseedname;
	}
	
	public int returnValue() {
		return VALUE;
	}
	
	public void drawItem(int height, int width, int heightShifter) {
		window.strokeWeight(5);
		window.stroke(234, 211, 166);

		window.fill(200, 150, 0);
		window.rect(height * 50 + 75, width * 50 + 25 + heightShifter, 50, 50);
		window.image(pumpkinseeds, height * 50 + 50, (float) (width * 50 + heightShifter + packetshifter), 50, 50);
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
