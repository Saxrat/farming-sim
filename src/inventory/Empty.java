package inventory;

import processing.core.PApplet;

public class Empty extends Inventory {

	public Empty(PApplet p) {
		super(p);
	}

	public void drawItem(int height, int width, int heightshifter) {
		
			window.strokeWeight(5);
			window.stroke(234, 211, 166);
		
		
		window.fill(200, 150, 0);
		window.rect(height * 50 + 75, width * 50 + 25 + heightshifter, 50, 50);
		window.strokeWeight(1);
		window.stroke(0);

	}
}
