package tiles;

import inventory.CarrotSeeds;
import inventory.EggplantSeeds;
import inventory.Empty;
import inventory.Inventory;
import inventory.PumpkinSeeds;
import processing.core.PApplet;
import processing.core.PImage;

public class Store extends Tile {
	String storedisplayname;
	String storetilename;
	PImage storetile;
	PImage storedisplay;
	Inventory[][] display;
	boolean isDisplay;
	String crossoutname;
	PImage crossout;
	int col = 0;

	public Store(float x, float y, PApplet p) {
		super(x, y, p);
		storedisplayname = "../Assets/storeback.png";
		storetilename = "../Assets/storetile.png";
		crossoutname = "../Assets/crossout.png";
		crossout = window.loadImage(crossoutname);
		storetile = window.loadImage(storetilename);
		storedisplay = window.loadImage(storedisplayname);
		display = new Inventory[10][10];
		isDisplay = false;
	}

	public void setDisplay(Inventory[][] playerInventory) {
		for (int col = 0; col < playerInventory[0].length; col++) {
			display[0][col] = playerInventory[0][col];
		}
		for (int i = 1; i < display.length; i++) {
			for (int j = 0; j < display[0].length; j++) {
				display[i][j] = new Empty(window);
			}
		}
		display[2][0] = new EggplantSeeds(window, 1);
		display[2][1] = new CarrotSeeds(window, 1);
		display[2][2] = new PumpkinSeeds(window, 1);
	}

	public void displayStore() {
		window.image(storedisplay, TILE_SCALING - 2, TILE_SCALING, 505, 500);

		for (int row = 0; row < display.length; row = row + 2) {
			for (int col = 0; col < display[0].length; col++) {
				display[row][col].drawItem(col, row, TILE_SCALING);
				display[row][col].displayValue(display[row][col].returnValue(), col, row);
				checkDisplay(row, col);

			}
		}
	}

	public void checkDisplay(int r, int c) {

		if (display[r][c].getNum() < 1) {
			Empty empty = new Empty(window);
			display[r][c] = empty;
			window.image(crossout, c * TILE_SCALING + TILE_SCALING, r * TILE_SCALING + TILE_SCALING);
		}

	}

	public int sellBuy() {
		int gold = 0;
		for (int r = 0; r < display.length; r = r + 2) {
			for (int c = 0; c < display[0].length; c++) {
				if (window.mouseY >= (r * TILE_SCALING + TILE_SCALING)
						&& window.mouseY <= (r * TILE_SCALING + (2 * TILE_SCALING))) {
					if (window.mouseX >= (c * TILE_SCALING + TILE_SCALING)
							&& window.mouseX <= (c * TILE_SCALING + 2 * TILE_SCALING)) {
						gold = display[r][c].returnValue();
						if (r > 0) {
							gold = gold * (-1);
							for (int col = 0; col < display[0].length; col++) {
								if (display[0][col].getClass() == display[r][c].getClass()) {
									display[0][col].add();
								} else if (display[0][col] instanceof Empty) {
									System.out.println("Found empty");
									if (display[r][c] instanceof CarrotSeeds) {
										display[0][col] = new CarrotSeeds(window, 1);

									} else if (display[r][c] instanceof EggplantSeeds) {
										display[0][col] = new EggplantSeeds(window, 1);

									} else if (display[r][c] instanceof PumpkinSeeds) {
										display[0][col] = new PumpkinSeeds(window, 1);

									} else {
										System.out.println("Made empty");
										display[0][col] = new Empty(window);

									}
									this.col = col;
									display[0][col].drawItem(col, 0, TILE_SCALING);
									return gold;
								}

							}
						} else {
							display[r][c].remove();
						}
						if (display[r][c].getNum() <= 0) {
							Empty empty = new Empty(window);
							display[r][c] = empty;

						}
					}
				}
			}
		}
		System.out.println(gold);
		return gold;
	}

	public Inventory[][] returnStore() {
		return display;
	}

	public boolean isDisplayed() {
		return isDisplay;
	}

	public void toggleDisplay() {
		System.out.println("Store toggled.");
		if (isDisplay) {
			isDisplay = false;
			System.out.println("Store set false");
		} else {
			isDisplay = true;
			System.out.println("Store set true");
		}
	}

	public void drawTile() {
		window.image(storetile, x * TILE_SCALING, y * TILE_SCALING, TILE_SCALING, TILE_SCALING);
	}
}
