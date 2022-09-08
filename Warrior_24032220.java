public class Warrior_24032220 implements WarriorTypeInterface_24032220 {
	private int posx; // x coordinate of warrior
	private int posy; // y coordinate of warrior
	private int AGE;
	private double HEALTH;
	private double off;
	private double def;
	private final String TYPE;
	private int[] inventory;
	private String MOVES;
	private final int ID;
	boolean ability = false;
	boolean AbilitySet = false;
	private final static int row = Game_24032220.getRow();
	private final static int col = Game_24032220.getCol();
	static Warrior_24032220[] arr = Game_24032220.WAR; // array of warriors
	private static String[][] board = Game_24032220.board;
	private int abilityCounter = -1;
	private static String[][] waterboard = Water_24032220.waterboard;

	public Warrior_24032220(int x, int y, int age, String type, double health, double offense, double defense,
			int InventorySize, String moves, int id) {
		posx = x;
		posy = y;
		AGE = age;
		TYPE = type;
		HEALTH = health;
		off = offense;
		def = defense;
		inventory = new int[InventorySize];
		MOVES = moves;
		ID = id;
	}

	public int watercount() {
		int i = posx;
		int j = posy;
		int count = 0;
//		up
		if (i > 0 && waterboard[i - 1][j] != null && waterboard[i - 1][j].equals("w"))
			count++;
		else if (i == 0 && waterboard[row - 1][j] != null && waterboard[row - 1][j].equals("w"))
			count++;
//		down
		if (i < row - 1 && waterboard[i + 1][j] != null && waterboard[i + 1][j].equals("w"))
			count++;
		else if (i == row - 1 && waterboard[0][j] != null && waterboard[0][j].equals("w"))
			count++;
//		left
		if (j > 0 && waterboard[i][j - 1] != null && waterboard[i][j - 1].equals("w"))
			count++;
		else if (j == 0 && waterboard[i][col - 1] != null && waterboard[i][col - 1].equals("w"))
			count++;
//		right
		if (j < col - 1 && waterboard[i][j + 1] != null && waterboard[i][j + 1].equals("w"))
			count++;
		else if (j == col - 1 && waterboard[i][0] != null && waterboard[i][0].equals("w"))
			count++;
//		up-left
		if (j > 0 && i > 0 && waterboard[i - 1][j - 1] != null && waterboard[i - 1][j - 1].equals("w")) {
			count++;
		} else if (j > 0 && i == 0 && waterboard[row - 1][j - 1] != null && waterboard[row - 1][j - 1].equals("w")) {
			count++;
		} else if (j == 0 && i > 0 && waterboard[i - 1][col - 1] != null && waterboard[i - 1][col - 1].equals("w")) {
			count++;
		} else if (j == 0 && i == 0 && waterboard[row - 1][col - 1] != null && waterboard[row - 1][col - 1].equals("w"))
			count++;
//		up-right
		if (i > 0 && j < row - 1 && waterboard[i - 1][j + 1] != null && waterboard[i - 1][j + 1].equals("w"))
			count++;
		else if (i == 0 && j < row - 1 && waterboard[row - 1][j + 1] != null && waterboard[row - 1][j + 1].equals("w"))
			count++;
		else if (i > 0 && j == col - 1 && waterboard[i - 1][0] != null && waterboard[i - 1][0].equals("w"))
			count++;
		else if (i == 0 && j == col - 1 && waterboard[row - 1][0] != null && waterboard[row - 1][0].equals("w"))
			count++;
//		down-left
		if (i < row - 1 && j > 0 && waterboard[i + 1][j - 1] != null && waterboard[i + 1][j - 1].equals("w"))
			count++;
		else if (i == row - 1 && j > 0 && waterboard[0][j - 1] != null && waterboard[0][j - 1].equals("w"))
			count++;
		else if (i < row - 1 && j == 0 && waterboard[i + 1][col - 1] != null && waterboard[i + 1][col - 1].equals("w"))
			count++;
		else if (i == row - 1 && j == 0 && waterboard[0][col - 1] != null && waterboard[0][col - 1].equals("w"))
			count++;
//		down-right
		if (i < row - 1 && j < col - 1 && waterboard[i + 1][j + 1] != null && waterboard[i + 1][j + 1].equals("w"))
			count++;
		else if (i == row - 1 && j < col - 1 && waterboard[0][j + 1] != null && waterboard[0][j + 1].equals("w"))
			count++;
		else if (i < row - 1 && j == col - 1 && waterboard[i + 1][0] != null && waterboard[i + 1][0].equals("w"))
			count++;
		else if (i == row - 1 && j == col - 1 && waterboard[0][0] != null && waterboard[0][0].equals("w"))
			count++;
		return count;
	}

	public boolean waterNeighbour() {
		boolean ans = false;
		int i = posx;
		int j = posy;
		int count = 0;
//		up
		if (i > 0 && waterboard[i - 1][j] != null && waterboard[i - 1][j].equals("w"))
			count++;
		else if (i == 0 && waterboard[row - 1][j] != null && waterboard[row - 1][j].equals("w"))
			count++;
//		down
		if (i < row - 1 && waterboard[i + 1][j] != null && waterboard[i + 1][j].equals("w"))
			count++;
		else if (i == row - 1 && waterboard[0][j] != null && waterboard[0][j].equals("w"))
			count++;
//		left
		if (j > 0 && waterboard[i][j - 1] != null && waterboard[i][j - 1].equals("w"))
			count++;
		else if (j == 0 && waterboard[i][col - 1] != null && waterboard[i][col - 1].equals("w"))
			count++;
//		right
		if (j < col - 1 && waterboard[i][j + 1] != null && waterboard[i][j + 1].equals("w"))
			count++;
		else if (j == col - 1 && waterboard[i][0] != null && waterboard[i][0].equals("w"))
			count++;
//		up-left
		if (j > 0 && i > 0 && waterboard[i - 1][j - 1] != null && waterboard[i - 1][j - 1].equals("w")) {
			count++;
		} else if (j > 0 && i == 0 && waterboard[row - 1][j - 1] != null && waterboard[row - 1][j - 1].equals("w")) {
			count++;
		} else if (j == 0 && i > 0 && waterboard[i - 1][col - 1] != null && waterboard[i - 1][col - 1].equals("w")) {
			count++;
		} else if (j == 0 && i == 0 && waterboard[row - 1][col - 1] != null && waterboard[row - 1][col - 1].equals("w"))
			count++;
//		up-right
		if (i > 0 && j < row - 1 && waterboard[i - 1][j + 1] != null && waterboard[i - 1][j + 1].equals("w"))
			count++;
		else if (i == 0 && j < col - 1 && waterboard[row - 1][j + 1] != null && waterboard[row - 1][j + 1].equals("w"))
			count++;
		else if (i > 0 && j == col - 1 && waterboard[i - 1][0] != null && waterboard[i - 1][0].equals("w"))
			count++;
		else if (i == 0 && j == col - 1 && waterboard[row - 1][0] != null && waterboard[row - 1][0].equals("w"))
			count++;
//		down-left
		if (i < row - 1 && j > 0 && waterboard[i + 1][j - 1] != null && waterboard[i + 1][j - 1].equals("w"))
			count++;
		else if (i == row - 1 && j > 0 && waterboard[0][j - 1] != null && waterboard[0][j - 1].equals("w"))
			count++;
		else if (i < row - 1 && j == 0 && waterboard[i + 1][col - 1] != null && waterboard[i + 1][col - 1].equals("w"))
			count++;
		else if (i == row - 1 && j == 0 && waterboard[0][col - 1] != null && waterboard[0][col - 1].equals("w"))
			count++;
//		down-right
		if (i < row - 1 && j < col - 1 && waterboard[i + 1][j + 1] != null && waterboard[i + 1][j + 1].equals("w"))
			count++;
		else if (i == row - 1 && j < col - 1 && waterboard[0][j + 1] != null && waterboard[0][j + 1].equals("w"))
			count++;
		else if (i < row - 1 && j == col - 1 && waterboard[i + 1][0] != null && waterboard[i + 1][0].equals("w"))
			count++;
		else if (i == row - 1 && j == col - 1 && waterboard[0][0] != null && waterboard[0][0].equals("w"))
			count++;
		if (count >= 1)
			ans = true;
		return ans;
	}

	public void setCounter(int a) {
		abilityCounter += a;
	}

	public boolean getAbilitySet() {
		return ability;
	}

	public int abilityCounter() {
		return abilityCounter;
	}

	public void ageSet() {
		AGE++;
		capDefense();
	}

	public static void printVisualStart() { // used in the beginning of setup
		Game_24032220.clearBoard();
		fillBoard();
		Water_24032220.start();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != null)
				arr[i].printStats();
	}

	static void printVisual() {
		Game_24032220.clearBoard();
		fillBoard();
		Water_24032220.check();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++)
			if (arr[i] != null)
				arr[i].printStats();
		System.out.println();

	}
	public static int nullCount() {
		int count=0;
		for(int k=0;k<arr.length;k++)
			if(arr[k]!=null)
				count++;
		return count;
	}
	private static void fillBoard() {
		int count = 1;
		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (board[arr[i].getX()][arr[i].getY()].contains("."))
					board[arr[i].getX()][arr[i].getY()] = ConsoleColours.WARRIOR_COLOUR + arr[i].toString()
							+ ConsoleColours.RESET;
				else {
					x = arr[i].getX();
					y = arr[i].getY();
					count++;
				}
			}
		}
		if (count > 1)
			board[x][y] = ConsoleColours.WARRIOR_COLOUR + count + " " + ConsoleColours.RESET;

	}

	public void printStats() {
		int weapon = 0;
		if (inventory[0] != 0)
			weapon++;
		System.out.println(getID() + ", " + getAge() + ", " + getHealth() + ", " + getOffense() + ", " + getDefense()
				+ ", " + weapon + ", " + getType() + ", " + getX() + ", " + getY());
	}

	public static void printStats(Warrior_24032220 w) {
		int weapon = 0;
		if (w.inventory[0] != 0)
			weapon++;
		System.out.println(w.getID() + ", " + w.getAge() + ", " + w.getHealth() + ", " + w.getOffense() + ", "
				+ w.getDefense() + ", " + weapon + ", " + w.getType() + ", " + w.getX() + ", " + w.getY());
	}

	private static void WarriorWon() {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null)
				count++;
		}
		if (count == 1) {
			System.out.println("A warrior has been proven victor!");
			System.exit(0);
		} else if (count == 0) {
			System.out.println("No warriors are left!");
			System.exit(0);
		}
	}

	private void fight(Warrior_24032220 w) {
		// damage calculation method
		if (getDefense() < w.getDefense()) {
			sethealth(-w.getOffense());
		}
	}

	public void battle() {// method to initiate fighting between warriors
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && !(equals(arr[i]))) {
				Warrior_24032220 w = arr[i];
//				up
				if (posx > 0 && posx - 1 == w.getX() && posy == w.getY())
					fight(w);
				else if (posx == 0 && w.getX() == row - 1 && posy == w.getY())
					fight(w);
//				down
				if (posx < row - 1 && posx + 1 == w.getX() && posy == w.getY())
					fight(w);
				else if (posx == row - 1 && w.getX() == 0 && posy == w.getY())
					fight(w);
//				left
				if (posy > 0 && posy - 1 == w.getY() && posx == w.getX())
					fight(w);
				else if (posy == 0 && w.getY() == col - 1 && posx == w.getX())
					fight(w);
//				right
				if (posy < col - 1 && posy + 1 == w.getY() && posx == w.getX())
					fight(w);
				else if (posy == col - 1 && w.getY() == 0 && posx == w.getX())
					fight(w);
//				up-left
				if (posy > 0 && posx > 0 && posx - 1 == w.getX() && posy - 1 == w.getY()) {
					fight(w);
				} else if (posy > 0 && posx == 0 && row - 1 == w.getX() && posy - 1 == w.getY()) {
					fight(w);
				} else if (posy == 0 && posx > 0 && col - 1 == w.getY() && posx - 1 == w.getX()) {
					fight(w);
				} else if (posy == 0 && posx == 0 && col - 1 == w.getY() && row - 1 == w.getX())
					fight(w);
//				up-right
				if (posx > 0 && posy < row - 1 && posx - 1 == w.getX() && posy + 1 == w.getY())
					fight(w);
				else if (posx == 0 && posy < row - 1 && row - 1 == w.getX() && posy + 1 == w.getY())
					fight(w);
				else if (posx > 0 && posy == col - 1 && posx - 1 == w.getX() && 0 == w.getY())
					fight(w);
				else if (posx == 0 && posy == col - 1 && row - 1 == w.getX() && 0 == w.getY())
					fight(w);
//				down-left
				if (posx < row - 1 && posy > 0 && posx + 1 == w.getX() && posy - 1 == w.getY())
					fight(w);
				else if (posx == row - 1 && 0 == w.getX() && posy > 0 && posy - 1 == w.getY())
					fight(w);
				else if (posx < row - 1 && posx + 1 == w.getX() && posy == 0 && col - 1 == w.getY())
					fight(w);
				else if (posx == row - 1 && posy == 0 && 0 == w.getX() && col - 1 == w.getY())
					fight(w);
//				down-right
				if (posx < row - 1 && posy < col - 1 && posx + 1 == w.getX() && posy + 1 == w.getY())
					fight(w);
				else if (posx == row - 1 && 0 == w.getX() && posy < col - 1 && posy + 1 == w.getY())
					fight(w);
				else if (posx < row - 1 && posx + 1 == w.getX() && posy == col - 1 && 0 == w.getY())
					fight(w);
				else if (posx == row - 1 && posy == col - 1 && 0 == w.getX() && 0 == w.getY())
					fight(w);
			}
		}
	}

	public boolean equals(Warrior_24032220 w) {
		boolean ans = false;
		if (getType().equals(w.getType()) && getX() == w.getX() && w.getY() == getY() && getID() == w.getID()
				&& getMoves().equals(w.getMoves()) && getOffense() == w.getOffense())
			ans = true;
		return ans;
	}

	public void setY(int y) {
		posy = y;
	}

	public void setX(int x) {
		posx = x;
	}

	public double getOffense() {
		return off;
	}

	public int getID() {
		return ID;
	}

	public void setMoves(String m) {
		MOVES = m;
	}

	public String toString() {
		if (getType().equals("Water"))
			return "W ";
		else if (getType().equals("Stone"))
			return "S ";
		else if (getType().equals("Air"))
			return "A ";
		else
			return "F ";
	}

	public int getAge() {
		return AGE;
	}

	public String getType() {
		return TYPE;
	}

	public double getHealth() {
		return HEALTH;
	}

	public int InventorySize() {
		return inventory.length;
	}

	public String getMoves() {
		return MOVES;
	}

	public void move(Character c) {
		if (c == 'a') { // left
			if (posy > 0)
				posy--;
			else if (posy == 0)
				posy = col - 1;
		} else if (c == 'd') { // right
			if (posy < col - 1)
				posy++;
			else
				posy = 0;
		} else if (c == 'w') { // up
			if (posx > 0)
				posx--;
			else
				posx = row - 1;
		} else if (c == 'x') { // down
			if (posx < row - 1)
				posx++;
			else
				posx = 0;
		} else if (c == 'z') { // down-left diagonal
			if (posy > 0 && posx < row - 1) {
				posx++;
				posy--;
			} else if (posy > 0 && posx == row - 1) {
				posx = 0;
				posy--;
			} else if (posy == 0 && posx < row - 1) {
				posx++;
				posy = col - 1;
			} else {
				posx = 0;
				posy = col - 1;
			}
		} else if ((c == 'c')) {// down-right diagonal
			if (posy < col - 1 && posx < row - 1) {
				posx++;
				posy++;
			}
			if (posx == row - 1 && posy < col - 1) {
				posy++;
				posx = 0;
			}
			if (posx < row - 1 && posy == col - 1) {
				posy = 0;
				posx++;
			} else if (posx == row - 1 && posy == col - 1) {
				posx = 0;
				posy = 0;
			}
		} else if (c == 'q') { // up-left diagonal
			if (posy > 0 && posx > 0) {
				posx--;
				posy--;
			} else if (posy > 0 && posx == 0) {
				posx = row - 1;
				posy--;
			} else if (posy == 0 && posx > 0) {
				posx--;
				posy = col - 1;
			} else {
				posx = row - 1;
				posy = col - 1;
			}
		} else if (c == 'e') { // up-right diagonal
			if (posx > 0 && posy < col - 1) {
				posy++;
				posx--;
			} else if (posx > 0 && posy == col - 1) {
				posy = 0;
				posx--;
			} else if (posx == 0 && posy < col - 1) {
				posy++;
				posx = row - 1;
			} else {
				posy = 0;
				posx = row - 1;
			}
		} else if (c == 'n')
			dont();
	}

	public int getX() {
		return posx;
	}

	public int getY() {
		return posy;
	}

	public double getDefense() {
		return def;
	}

	public void adddefense(double d) {
		def += d;
	}

	public void setdefense(double d) {
		// TODO Auto-generated method stub
		def = d;
		capDefense();

	}

	public void sethealth(double d) {
		HEALTH += d;
		capHealth();
	}

	private void capHealth() {
		if (getHealth() > 100)
			HEALTH = 100;
	}

	public void setoff(double d) {
		off = d;
		capOffense();
	}

	private void capOffense() {
		if (getOffense() > 100)
			setoff(100);
	}

	@Override
	public void quit(int k) {
		// check warrior leaving game
		if (getHealth() <= 0) {
			System.out.println("A warrior has left the game!");
			Game_24032220.WAR[k] = null;
		}
//		if(waterboard[posx][posy]!=null && waterboard[posx][posy].equals("w")) {
//			System.out.println("Error: multiple water pieces were configured at the same position");
//			System.exit(0);
//		}
		Warrior_24032220.WarriorWon();
	}

	@Override
	public void capDefense() {
		/*
		 * If the age of a warrior is above 15, their defence strength strength must not
		 * be above 75%. If the age of a warrior is above 25, their defence strength
		 * must not be above 50%. If the age of a warrior is above 50, their defence
		 * strength must not be above 30%.
		 */
		if (AGE > 15 && AGE < 25 && def > 70)
			def = 75;
		if (AGE > 25 && AGE < 50 && def > 50)
			def = 50;
		if (AGE > 50 && def > 30)
			def = 30;
	}

	private void dont() {
		// do nothing
	}

	@Override
	public void SpecialAbilityCompleted() {
	}

	public static void overload() {
		// 10 warriors at same cell
		int count = 1;
		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (board[arr[i].getX()][arr[i].getY()].contains("."))
					board[arr[i].getX()][arr[i].getY()] = ConsoleColours.WARRIOR_COLOUR + arr[i].toString()
							+ ConsoleColours.RESET;
				else {
					x = arr[i].getX();
					y = arr[i].getY();
					count++;
				}
			}
		}
//		}
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 0; j < arr.length; j++)
//				if (arr[i] != null && arr[j] != null && j != i && arr[i].equalsCoords(arr[j])) {
//					count++;
//					if (count >= 10) {
//						x = arr[i].getX();
//						y = arr[i].getY();
//					}
//				}
//			count = 0;
//		}
		if (count >= 10) {
			System.out.println("Error: warrior limit exceeded at cell " + x + " " + y);
			System.exit(0);
		}

	}

	@Override
	public void specialAbilityCompleted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void performSpecialAbility() {
		// TODO Auto-generated method stub

	}

}
