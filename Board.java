/**
 * @author Ela Klaehn, Zach Reents, Ez Powell
 *
 */
public class Board {
	private char[][] grid;
	private Player playerX;
	private Player playerO;
	private final char PIECE_ONE = 'X';
	private final char PIECE_TWO = 'O';
	private final char BLANK = '-';
	
	public Board(Player playerOne, Player playerTwo) {
		grid = new char[6][7];
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				grid[row][col] = BLANK;
			}
		}
		playerX = playerOne;
		playerO = playerTwo;
	}
	
	public void addPiece(int col, Player player) {
		char piece;
		if (player == playerX) {
			// make equals method in Player class to compare players
			piece = PIECE_ONE;
		}
		else
			piece = PIECE_TWO
		
		for (int i = grid[i].length; i >= 0; i--) {
			if (grid[i][col] == BLANK)
				grid[i][col] = piece; 
		}
	}
	
	public boolean isFull(int col) {
		// check if column is full
		for (int i = grid[i].length; i >= 0; i--) {
			if (grid[i][col] == BLANK)
				return false;
		}
		return true;
	}
	
	public boolean isBoardFull() {
		// check if all rows and columns are full
		
	}
}
