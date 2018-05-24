package inventory;

import processing.core.PApplet;

public abstract class Inventory {
	protected int num;

	PApplet window;
	public Inventory(PApplet p) {
		num = 1;
		window = p;
		
	}
	
	public int returnValue() {
		return 0;
	}
	public void displayValue(int value, float x, float y) {
		if(value > 0) {
		window.textAlign(window.CENTER);
		window.textSize(20);
		window.fill(0);
		window.text(value, x*50 + 75, y * 50 + 125);
		window.textAlign(window.LEFT);
		window.textSize(12);
		}
	}
	
	public void add() {
		
	}
	
	public void remove() {
		
	}
	
	public int getNum() {
		return num;
	}
	
	public String returnName() {
		return null;
	}
	
	
	public void drawItem(int height, int length, int heightShifter) {
		
	}
	
}
