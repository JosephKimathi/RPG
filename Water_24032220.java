
public class Water_24032220 extends Game_24032220 {
	private int posX;
	private int posY;
	private static final int row = Game_24032220.getRow();
	private static final int col = Game_24032220.getCol();
	static String[][] waterboard = new String[row][col];
	private static String[][] waterOut = new String[row][col];
	private static String[][] waterIn = new String[row][col];
	static int[][]watercount=new int[row][col];

	public Water_24032220(int x, int y) {
		// TODO Auto-generated constructor stub
		posX = x;
		posY = y;
		waterboard[x][y] = "w";
		watercount[x][y]++;
	}

	public int getX() {
		return posX;
	}

	public 	int getY() {
		return posY;
	}

	private static void empty(String[][] arr) {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				arr[i][j] = null;
	}

	public static void start() {
		// finding waters in beginning of game
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if(watercount[i][j]>1) {
					System.out.println("Error: multiple water pieces were configured at the same position on the game grid.");
					System.exit(0);
				}	
				if (waterboard[i][j] != null && waterboard[i][j].equals("w"))
					board[i][j] = ConsoleColours.WATER_COLOUR + "w " + ConsoleColours.RESET;
			}
	}
		//fill water board
	private static void fill() {
		empty(waterboard); //clear for iteration
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (waterIn[i][j] != null)
					if (waterIn[i][j] == "w")
						new Water_24032220(i, j);
				if (waterOut[i][j] != null)
					if (waterOut[i][j] == "w")
						new Water_24032220(i, j);
			}
	}

	private static void waterFill() {
		// look for water cells that stay
		int count = 0;
		empty(waterOut); //clear for iteration
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (waterboard[i][j] != null) {
//						up
					if (i > 0 && waterboard[i - 1][j] != null && waterboard[i - 1][j].equals("w"))
						count++;
					else if (i == 0 && waterboard[row - 1][j] != null && waterboard[row - 1][j].equals("w"))
						count++;
//						down
					if (i < row - 1 && waterboard[i + 1][j] != null && waterboard[i + 1][j].equals("w"))
						count++;
					else if (i == row - 1 && waterboard[0][j] != null && waterboard[0][j].equals("w"))
						count++;
//						left
					if (j > 0 && waterboard[i][j - 1] != null && waterboard[i][j - 1].equals("w"))
						count++;
					else if (j == 0 && waterboard[i][col - 1] != null && waterboard[i][col - 1].equals("w"))
						count++;
//						right
					if (j < col - 1 && waterboard[i][j + 1] != null && waterboard[i][j + 1].equals("w"))
						count++;
					else if (j == col - 1 && waterboard[i][0] != null && waterboard[i][0].equals("w"))
						count++;
//						up-left
					if (j > 0 && i > 0 && waterboard[i - 1][j - 1] != null && waterboard[i - 1][j - 1].equals("w")) {
						count++;
					} else if (j > 0 && i == 0 && waterboard[row - 1][j - 1] != null
							&& waterboard[row - 1][j - 1].equals("w")) {
						count++;
					} else if (j == 0 && i > 0 && waterboard[i - 1][col - 1] != null
							&& waterboard[i - 1][col - 1].equals("w")) {
						count++;
					} else if (j == 0 && i == 0 && waterboard[row - 1][col - 1] != null
							&& waterboard[row - 1][col - 1].equals("w"))
						count++;
//						up-right
					if (i > 0 && j < col - 1 && waterboard[i - 1][j + 1] != null
							&& waterboard[i - 1][j + 1].equals("w"))
						count++;
					else if (i == 0 && j < col - 1 && waterboard[row - 1][j + 1] != null
							&& waterboard[row - 1][j + 1].equals("w"))
						count++;
					else if (i > 0 && j == col - 1 && waterboard[i - 1][0] != null && waterboard[i - 1][0].equals("w"))
						count++;
					else if (i == 0 && j == col - 1 && waterboard[row - 1][0] != null
							&& waterboard[row - 1][0].equals("w"))
						count++;
//						down-left
					if (i < row - 1 && j > 0 && waterboard[i + 1][j - 1] != null
							&& waterboard[i + 1][j - 1].equals("w"))
						count++;
					else if (i == row - 1 && j > 0 && waterboard[0][j - 1] != null && waterboard[0][j - 1].equals("w"))
						count++;
					else if (i < row - 1 && j == 0 && waterboard[i + 1][col - 1] != null
							&& waterboard[i + 1][col - 1].equals("w"))
						count++;
					else if (i == row - 1 && j == 0 && waterboard[0][col - 1] != null
							&& waterboard[0][col - 1].equals("w"))
						count++;
//						down-right
					if (i < row - 1 && j < col - 1 && waterboard[i + 1][j + 1] != null
							&& waterboard[i + 1][j + 1].equals("w"))
						count++;
					else if (i == row - 1 && j < col - 1 && waterboard[0][j + 1] != null
							&& waterboard[0][j + 1].equals("w"))
						count++;
					else if (i < row - 1 && j == col - 1 && waterboard[i + 1][0] != null
							&& waterboard[i + 1][0].equals("w"))
						count++;
					else if (i == row - 1 && j == col - 1 && waterboard[0][0] != null && waterboard[0][0].equals("w"))
						count++;
					if (count == 3 || count == 2) {
						waterOut[i][j] = "w";
					}
					count = 0;
				}
			}
	}

	public static void check() {
		// water iteration and board filling
		waterFill();
		emptyWaterFill();
		fill();
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (waterboard[i][j] != null && waterboard[i][j] == "w") {
					Game_24032220.board[i][j] = ConsoleColours.EMPTY_CELL_COLOUR + ". " + ConsoleColours.RESET;

				}
				if (waterboard[i][j] != null && waterboard[i][j] == "w" ) {
					Game_24032220.board[i][j] = ConsoleColours.WATER_COLOUR + "w " + ConsoleColours.RESET;
				}
			}
	}

	private static void emptyWaterFill() {
//		run at the beginning of every iteration to check for cells to fill
//		cross check every empty water position to the neighbourhood for a solitary water object
		int count = 0;
		empty(waterIn);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (waterboard[i][j] == null) {
//						up
					if (i > 0 && waterboard[i - 1][j] != null && waterboard[i - 1][j].equals("w"))
						count++;
					else if (i == 0 && waterboard[row - 1][j] != null && waterboard[row - 1][j].equals("w"))
						count++;
//						down
					if (i < row - 1 && waterboard[i + 1][j] != null && waterboard[i + 1][j].equals("w"))
						count++;
					else if (i == row - 1 && waterboard[0][j] != null && waterboard[0][j].equals("w"))
						count++;
//						left
					if (j > 0 && waterboard[i][j - 1] != null && waterboard[i][j - 1].equals("w"))
						count++;
					else if (j == 0 && waterboard[i][col - 1] != null && waterboard[i][col - 1].equals("w"))
						count++;
//						right
					if (j < col - 1 && waterboard[i][j + 1] != null && waterboard[i][j + 1].equals("w"))
						count++;
					else if (j == col - 1 && waterboard[i][0] != null && waterboard[i][0].equals("w"))
						count++;
//						up-left
					if (j > 0 && i > 0 && waterboard[i - 1][j - 1] != null && waterboard[i - 1][j - 1].equals("w")) {
						count++;
					} else if (j > 0 && i == 0 && waterboard[row - 1][j - 1] != null
							&& waterboard[row - 1][j - 1].equals("w")) {
						count++;
					} else if (j == 0 && i > 0 && waterboard[i - 1][col - 1] != null
							&& waterboard[i - 1][col - 1].equals("w")) {
						count++;
					} else if (j == 0 && i == 0 && waterboard[row - 1][col - 1] != null
							&& waterboard[row - 1][col - 1].equals("w"))
						count++;
//						up-right
					if (i > 0 && j < col - 1 && waterboard[i - 1][j + 1] != null
							&& waterboard[i - 1][j + 1].equals("w"))
						count++;
					else if (i == 0 && j < col - 1 && waterboard[row - 1][j + 1] != null
							&& waterboard[row - 1][j + 1].equals("w"))
						count++;
					else if (i > 0 && j == col - 1 && waterboard[i - 1][0] != null && waterboard[i - 1][0].equals("w"))
						count++;
					else if (i == 0 && j == col - 1 && waterboard[row - 1][0] != null
							&& waterboard[row - 1][0].equals("w"))
						count++;
//						down-left
					if (i < row - 1 && j > 0 && waterboard[i + 1][j - 1] != null
							&& waterboard[i + 1][j - 1].equals("w"))
						count++;
					else if (i == row - 1 && j > 0 && waterboard[0][j - 1] != null && waterboard[0][j - 1].equals("w"))
						count++;
					else if (i < row - 1 && j == 0 && waterboard[i + 1][col - 1] != null
							&& waterboard[i + 1][col - 1].equals("w"))
						count++;
					else if (i == row - 1 && j == 0 && waterboard[0][col - 1] != null
							&& waterboard[0][col - 1].equals("w"))
						count++;
//						down-right
					if (i < row - 1 && j < col - 1 && waterboard[i + 1][j + 1] != null
							&& waterboard[i + 1][j + 1].equals("w"))
						count++;
					else if (i == row - 1 && j < col - 1 && waterboard[0][j + 1] != null
							&& waterboard[0][j + 1].equals("w"))
						count++;
					else if (i < row - 1 && j == col - 1 && waterboard[i + 1][0] != null
							&& waterboard[i + 1][0].equals("w"))
						count++;
					else if (i == row - 1 && j == col - 1 && waterboard[0][0] != null && waterboard[0][0].equals("w"))
						count++;
					if (count == 3) {
						waterIn[i][j] = "w";
					}
					count = 0;
				}
			}
	}
}
