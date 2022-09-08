import java.io.*;
import java.util.Scanner;

public class Game_24032220 {
	private static int id;
	static int n; // iterations
	static int num; // number of warriors
	private static Scanner scan;
	public static String[][] board;
	public static Warrior_24032220[] WAR;
	private static int row;
	private static int col;
	public static Water_24032220 Water[][];
	static Water_24032220 WATER[];

	public static int getRow() {
		return row;
	}

	public static int getCol() {
		// returns number of columns in board
		return col;
	}

	private static void WarriorAddDefense(Warrior_24032220 w, int k) {
		for (int i = 0; i < num; i++) {
			if (WAR[i] != null && w.getType() == WAR[i].getType() && i != k && w.getX() == WAR[i].getX()
					&& w.getY() == WAR[i].getY())
				w.adddefense(2);
		}
	}

	public static void main(String[] args) {
		int visual = 2;
		try {
			File file = new File(args[0]);
			if (args[1] != null) {
				visual = Integer.parseInt(args[1]); // determines visual requirements
				if (visual == 0) // no game visualisation, section 4.1
					;
				else if (visual == 1)// game visualisation, section 4.2
					;
				else {
					System.out.println("Usage: Game_24032220 " + args[0]);
					System.exit(0);
				}
			}
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Usage: Game_24032220 " + args[0]);
			System.exit(0);
		}
		row = scan.nextInt();
		col = scan.nextInt();
		board = new String[row][col];
		Water = new Water_24032220[row][col];
		clearBoard();
		n = scan.nextInt(); // iterations
		scan.next(); // for the word "Warrior:"
		num = scan.nextInt(); // number of warriors
		WAR = new Warrior_24032220[num];
		int t = 0;
		for (int k = 0; k < num; k++) {
			int x = scan.nextInt(); // x position
			int y = scan.nextInt();// y position
			id = scan.nextInt(); // warrior id
			String type = scan.next();
			int age = scan.nextInt();
			double health = scan.nextDouble();
			double offense = scan.nextDouble();
			double defense = scan.nextDouble();
			int InventorySize = scan.nextInt();
			String moves = scan.next();
			Warrior_24032220 warr = new Warrior_24032220(x, y, age, type, health, offense, defense, InventorySize,
					moves, id);
			if (visual == 0 && Warrior_24032220.nullCount()>1)
				warr.printStats();
			WAR[id - 1] = warr;
		}
		while (scan.hasNextLine() && scan.hasNext()) {
			int number = 0; // number of water objects
			String temp = scan.next();
			if (temp.contains("Water:")) {
				number = scan.nextInt();
				for (int i = 0; i < number; i++) {
					int x = scan.nextInt();
					int y = scan.nextInt();
					Water_24032220 W = new Water_24032220(x, y);
					Water[x][y] = W;
				}
			}
		}
		if (visual == 1) {
			Warrior_24032220.printVisualStart();
			System.out.println();
		}
		Warrior_24032220 w;
		int hold = 1;
		boolean water = false;
		char c; // character used for moves
		while (t < n) {
			if (visual == 0 && Warrior_24032220.nullCount()>1)
				System.out.println();
			for (int k = 0; k < num; k++)
				if (WAR[k] != null) {
					w = WAR[k];
					water = w.waterNeighbour();
					if (t != hold && !water) {
						w.sethealth(-0.5);
					}
					if (t != hold && water) {
						w.sethealth(3);
					}
					if (t == (w.getMoves()).length())
						w.setMoves(w.getMoves() + w.getMoves());
					c = (w.getMoves()).charAt(t);
					w.move(c);
					// check for warrior cell overload
					Warrior_24032220.overload();
					if (w.getHealth() <= 10 && !w.AbilitySet) {
						if (w.getType().equals("Stone") && !w.ability) {
							StoneWarrior_24032220.performSpecialAbility(w);
						} else if (w.getType().equals("Flame") && !w.ability) {
							FlameWarrior_24032220.performSpecialAbility(w);
						} else if (w.getType().equals("Water") && !w.ability) {
							WaterWarrior_24032220.performSpecialAbility(w);
						} else if (w.getType().equals("Air") && !w.ability) {
							AirWarrior_24032220.performSpecialAbility(w);
						}
						// used to utilise the turn count of special abilities
					}
					if (w.getHealth() <= 10 && !w.AbilitySet && hold != t) {
						w.setCounter(1);
					}
					if (!w.AbilitySet) {
						if (w.getType().equals("Stone") && w.abilityCounter() == 3) {
							w.AbilitySet = true;
							StoneWarrior_24032220.specialAbilityCompleted(w);
						}
						if (w.getType().equals("Flame") && w.abilityCounter() == 2) {
							w.AbilitySet = true;
							FlameWarrior_24032220.specialAbilityCompleted(w);
						}
						if (w.getType().equals("Air") && w.abilityCounter() == 3) {
							w.AbilitySet = true;
							AirWarrior_24032220.specialAbilityCompleted(w);
						}
					}
					if (water && w.getType() == "Water")
						w.sethealth(1 * w.watercount());
					WarriorAddDefense(w, k);
					w.battle();
					w.ageSet();
					w.quit(k);
					if (w.getHealth() > 0 && visual == 0)
						w.printStats();
				}
			
			if (visual == 1)
				Warrior_24032220.printVisual();
			hold = t;
			t++;
			// end of turn
		}
	}

	static void clearBoard() {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				board[i][j] = ConsoleColours.EMPTY_CELL_COLOUR + ". " + ConsoleColours.RESET;
	}
}
