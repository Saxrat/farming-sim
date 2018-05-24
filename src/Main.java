import inventory.CarrotItem;
import inventory.CarrotSeeds;
import inventory.EggplantItem;
import inventory.EggplantSeeds;
import inventory.Empty;
import inventory.Hoe;
import inventory.Inventory;
import inventory.PumpkinItem;
import inventory.PumpkinSeeds;
import inventory.WateringCan;
import processing.core.PApplet;
import tiles.Carrot;
import tiles.Eggplant;
import tiles.Grass;
import tiles.Plant;
import tiles.Pumpkin;
import tiles.Store;
import tiles.Tile;
import tiles.Tilled;

public class Main extends PApplet {
	float playerX, playerY;
	Tile[][] ground = new Tile[12][12];
	Inventory[][] inventoryBar = new Inventory[1][10];
	boolean[][] inventoryBarSelector = new boolean[1][10];
	int inventoryShifter;

	int selectedSpace = 0;
	int gold;

	public void setup() {
		size(600, 600);
		rectMode(CENTER);
		playerX = 10;
		playerY = 10;
		gold = 0;
		clearInventoryBarSelector(inventoryBarSelector);
		inventoryBarSelector[0][selectedSpace] = true;

		inventoryShifter = 0;
		for (int i = 0; i < ground.length; i++) {
			for (int j = 0; j < ground[0].length; j++) {
				Grass newground = new Grass(i, j, this);
				ground[i][j] = newground;
			}
		}
		ground[0][0] = new Store(0, 0, this);
		for (int col = 0; col < inventoryBar[0].length; col++) {
			inventoryBar[0][col] = new Empty(this);
		}
		inventoryBar[0][0] = new Hoe(this);
		inventoryBar[0][2] = new CarrotSeeds(this, 10);
		inventoryBar[0][1] = new WateringCan(this);
		inventoryBar[0][3] = new EggplantSeeds(this, 10);
		inventoryBar[0][4] = new PumpkinSeeds(this, 10);
	}

	public void draw() {

		drawGrid(ground);
		drawPlayer();
		if (ground[0][0].isDisplayed()) {
			ground[0][0].setDisplay(inventoryBar);
			ground[0][0].displayStore(inventoryBar);
		
		} else {
			checkInventoryBarPlacement();

			drawInventory(inventoryBar);
			checkInventory(inventoryBar);
			move();
		}
		displayGold();
	}

	public void displayGold() {
		int goldX = 595;
		int goldY= 30;
		int goldR = 239;
		int goldG = 219;
		int goldB = 40;
		textAlign(RIGHT);
		textSize(30);
		fill(goldR, goldG, goldB);
		text(gold, goldX, goldY);
		textSize(12);
		textAlign(LEFT);
		fill(0);
	}
	
	public void addToGold(int value) {
		gold = gold + value;
	}
	
	public void removeFromGold(int value) {
		gold = gold - value;
	}

	public void checkInventory(Inventory[][] inventory) {
		for (int i = 0; i < inventory[0].length; i++) {
			if (inventory[0][i].getNum() <= 0) {
				Empty empty = new Empty(this);
				inventory[0][i] = empty;
			}
		}
	}

	public void drawGrid(Tile[][] tiles) {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				tiles[i][j].age();
				tiles[i][j].drawTile();
			}
		}
	}

	public void drawInventory(Inventory[][] collection) {

		boolean changed = false;
		for (int i = 0; i < collection.length; i++) {
			for (int j = 0; j < collection[0].length; j++) {
				collection[i][j].drawItem(j, i, inventoryShifter);
				if (inventoryBarSelector[i][j]) {

					changed = true;
				}
			}
		}
		drawSelectedBox(selectedSpace, 0, inventoryShifter);

	}

	public void drawSelectedBox(int height, int width, int inventoryShifter) {

		strokeWeight(10);
		stroke(150);
		fill(0, 0, 0, 0);
		rect(height * 50 + 75, width * 50 + 25 + inventoryShifter, 50, 50);
		strokeWeight(1);
		stroke(0);

	}

	public void clearInventoryBarSelector(boolean[][] selector) {
		for (int i = 0; i < selector.length; i++) {
			for (int j = 0; j < selector[0].length; j++) {
				selector[i][j] = false;
			}
		}
	}

	public void checkInventoryBarPlacement() {
		if (playerY < 75) {
			inventoryShifter = 500;
		} else {
			inventoryShifter = 0;
		}
	}

	public void drawPlayer() {
		fill(255);
		rect(playerX, playerY, 20, 20);
	}

	public void move() {
		if (keyPressed) {
			if (keyCode == UP || key == 'w') {
				if (playerY >= 10) {
					playerY = playerY - 2;
				}
			}
			if (keyCode == DOWN || key == 's') {
				if (playerY <= 590) {
					playerY = playerY + 2;
				}
			}
			if (keyCode == LEFT || key == 'a') {
				if (playerX >= 10) {
					playerX = playerX - 2;
				}
			}
			if (keyCode == RIGHT || key == 'd') {
				if (playerX <= 590) {
					playerX = playerX + 2;
				}
			}
			if (key == '1') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][0] = true;
				selectedSpace = 0;
			}
			if (key == '2') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][1] = true;
				selectedSpace = 1;

			}
			if (key == '3') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][2] = true;
				selectedSpace = 2;
			}
			if (key == '4') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][3] = true;
				selectedSpace = 3;
			}
			if (key == '5') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][4] = true;
				selectedSpace = 4;
			}
			if (key == '6') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][5] = true;
				selectedSpace = 5;
			}
			if (key == '7') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][6] = true;
				selectedSpace = 6;
			}
			if (key == '8') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][7] = true;
				selectedSpace = 7;
			}
			if (key == '9') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][8] = true;
				selectedSpace = 8;
			}
			if (key == '0') {
				clearInventoryBarSelector(inventoryBarSelector);
				inventoryBarSelector[0][9] = true;
				selectedSpace = 9;
			}
		}
	}

	public int checkSelectedTileX() {

		int j = 0;

		for (int c = 0; c < ground[0].length; c++) {
			if (mouseX >= (c * 50) && mouseX <= (c * 50 + 50)) {
				j = c;
			}

		}
		return j;
	}

	public int checkSelectedTileY() {
		int i = 0;
		for (int r = 0; r < ground.length; r++) {
			if (mouseY >= (r * 50) && mouseY <= (r * 50 + 50)) {
				i = r;

			}
		}
		return i;
	}

	public void mouseReleased() {
		if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Store) {
			ground[0][0].toggleDisplay();

			return;
		}
		if(ground[0][0].isDisplayed()) {
			int newgold = ground[0][0].sellBuy();
			gold = gold + newgold;
		}
		float distance = (float) Math
				.sqrt(((playerX - mouseX) * (playerX - mouseX)) + ((playerY - mouseY) * (playerY - mouseY)));
		if (distance < 100) {
			if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Pumpkin) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()].isHarvestable()) {
					System.out.println("Pumpkin detected");
					for (int b = 0; b < inventoryBar[0].length; b++) {
						System.out.println(b);
						System.out.println(inventoryBar[0].length);
						if (inventoryBar[0][b] instanceof PumpkinItem) {
							inventoryBar[0][b].add();
							Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
							ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
							return;
						} else if (inventoryBar[0][b] instanceof Empty) {
							PumpkinItem food = new PumpkinItem(this);
							inventoryBar[0][b] = food;
							Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
							ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
							return;
						}

					}
				}
			}
			if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Carrot) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()].isHarvestable()) {

					for (int b = 0; b < inventoryBar[0].length; b++) {
						if (inventoryBar[0][b] instanceof CarrotItem) {
							inventoryBar[0][b].add();
							Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
							ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
							return;
						} else if (inventoryBar[0][b] instanceof Empty) {
							CarrotItem food = new CarrotItem(this);
							inventoryBar[0][b] = food;
							Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
							ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
							return;

						}
					}
				}
			}
			if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Eggplant) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()].isHarvestable()) {

					for (int b = 0; b < inventoryBar[0].length; b++) {
						if (inventoryBar[0][b] instanceof EggplantItem) {
							inventoryBar[0][b].add();
							Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
							ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
							return;
						} else if (inventoryBar[0][b] instanceof Empty) {
							EggplantItem food = new EggplantItem(this);
							inventoryBar[0][b] = food;
							Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
							ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
							System.out.println("Eggplant added to slot " + b);
							return;

						}
					}
				}
			}
			if (inventoryBar[0][selectedSpace] instanceof Hoe) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Grass) {
					Tilled newground = new Tilled(checkSelectedTileX(), checkSelectedTileY(), this);
					ground[checkSelectedTileX()][checkSelectedTileY()] = newground;
					return;
				}
			} else if (inventoryBar[0][selectedSpace] instanceof CarrotSeeds) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Tilled) {
					Carrot newplant = new Carrot(checkSelectedTileX(), checkSelectedTileY(), this);
					ground[checkSelectedTileX()][checkSelectedTileY()] = newplant;
					inventoryBar[0][selectedSpace].remove();
					return;
				}
			} else if (inventoryBar[0][selectedSpace] instanceof EggplantSeeds) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Tilled) {
					Eggplant newplant = new Eggplant(checkSelectedTileX(), checkSelectedTileY(), this);
					ground[checkSelectedTileX()][checkSelectedTileY()] = newplant;
					inventoryBar[0][selectedSpace].remove();
					return;
				}
			} else if (inventoryBar[0][selectedSpace] instanceof PumpkinSeeds) {
				if (ground[checkSelectedTileX()][checkSelectedTileY()] instanceof Tilled) {
					Pumpkin newplant = new Pumpkin(checkSelectedTileX(), checkSelectedTileY(), this);
					ground[checkSelectedTileX()][checkSelectedTileY()] = newplant;
					inventoryBar[0][selectedSpace].remove();
					return;
				}
			} else if (inventoryBar[0][selectedSpace] instanceof WateringCan) {
				ground[checkSelectedTileX()][checkSelectedTileY()].water();
			}

		}

	}

}
