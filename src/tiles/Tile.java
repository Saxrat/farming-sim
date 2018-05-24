package tiles;

import inventory.Inventory;
import processing.core.PApplet;

public abstract class Tile {
	protected float x;
	protected float y;

	protected PApplet window;
	protected String imagename;
	protected final static int TILE_SCALING = 50;
	
	public Tile(float x, float y, PApplet p) {
		this.x = x;
		this.y = y;
		window = p;
	}
	
	public void drawTile() {
		
	}
	
	public void toggleTile() {
		
	}
	
	public void setWatered() {
		
	}
	
	public boolean isDisplayed() {
		return false;
	}
	
	public void setDry() {
	
	}
	
	public void water() {
	}
	public void age() {
		
	}

	public boolean isHarvestable() {
		// TODO Auto-generated method stub
		return false;
	}

	public void displayStore(Inventory[][] playerInventory) {
		
	}

	public void setDisplay(Inventory[][] inventoryBar) {
		// TODO Auto-generated method stub
		
	}
	
	public void toggleDisplay() {
		
	}

	public Inventory[][] returnStore() {
		// TODO Auto-generated method stub
		return null;
	}

	public int sellBuy() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void checkDisplay(int r, int c) {
		// TODO Auto-generated method stub
		
	}
	
}
