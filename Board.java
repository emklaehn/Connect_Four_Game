/**
 * This class creates the board for the Connect Four game.
 *
 * @author emklaehn, ZachReeee, eap22
 *
 */
public class Board {
    private char[][] grid;
    private Player playerX;
    private Player playerO;
    private final char PIECE_ONE = 'X';
    private final char PIECE_TWO = 'O';
    private final char BLANK = '-';
    
    /**
    * This method creates an empty board for the Connect Four game.
    *
    * @param playerOne  first player object
    * @param playerTwo  second player object
    */
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
     
    /**
    * This method adds a piece into the Connect Four board.
    *
    * @param col     integer column number on the board
    * @param player  chosen player object
    */
    public void addPiece(int col, Player player) {
	char piece;
	if (player.equals(playerX)) {
	    // make equals method in Player class to compare players
	    piece = PIECE_ONE;
	}
	else
	    piece = PIECE_TWO;
		
	    for (int row = grid.length - 1; row >= 0; row--) 
            {
                if (grid[row][col - 1] == BLANK)
                {
                    grid[row][col - 1] = piece;
                    break;
                }
	    }
    }
    
    /**
    * This method returns a boolean if the given column is completed or not.
    *
    * @param col     integer column number on the board
    * @return        boolean whether column is completed
    */
    public boolean isColumnFull(int col) {
	// check if column is full
	for (int row = grid.length - 1; row >= 0; row--) 
        {
	    if (grid[row][col - 1] == BLANK)
                return false;
	}
	return true;
    }
    
    /**
    * This method returns a boolean if the board is completed or not.
    *
    * @return   boolean whether board is completed
    */
    public boolean isBoardFull() {
        // check if all rows and columns are full
        for (int row = grid.length - 1; row >= 0; row--) {
            for(int col = grid[row].length - 1; col >= 0; col--){
        	if (grid[row][col] == BLANK) {
                    return false;
                }    
            }
        }
        return true;
    }
	
    // Add isWinner method to find who wins
    /**
    * This method returns a boolean if the chosen player is the winner.
    *
    * @param player chosen player object
    * @return       boolean if chosen player is winner
    */
    public boolean isWinner(Player player) {
        //public method for all private method winning types
        char piece;
        if (player.equals(playerX)) {
	    // make equals method in Player class to compare players
	    piece = PIECE_ONE;
	}
	else
	    piece = PIECE_TWO;
        
        return (isVerticalWinner(piece) || isHorizontalWinner(piece) 
            || isLeftDiagonal(piece) || isRightDiagonal(piece));
    }
	
    /**
    * This method returns a boolean if the chosen player wins vertically.
    *
    * @param piece  char associated with the chosen player
    * @return       boolean whether player wins vertically
    */
    private boolean isVerticalWinner(char piece) {
        int col = 0;
        int count;
        char previousPiece = 'a';
        while (col < 7) {
            count = 0;
	    previousPiece = 'a';
            for (int row = 0; row < 6; row++) {
                if (row == 0 || previousPiece == grid[row][col]) {
                    if (grid[row][col] == piece) {
                        count++;
                    }
                    else {
                        count = 0;
                    }
                    
                    if (count == 3) {
                        return true;
                    }
                }
                
                previousPiece = grid[row][col];
            }
            col++;
        }
        
        return false;
    }
	
    /**
    * This method returns a boolean if the chosen player wins horizontally.
    *
    * @param piece  char associated with the chosen player
    * @return       boolean whether player wins horizontally
    */
    private boolean isHorizontalWinner(char piece) {
        
        int row = 0;
        int count;
        char previousPiece = 'a';
        while (row < 6) 
        {
            count = 0;
	    previousPiece = 'a';
            for (int col = 0; col < 7; col++) 
            {
                if (col == 0 || grid[row][col] == piece) {
                    if (piece == previousPiece)
                    {
                        count++;
                    }
                    else {
                        count = 0;   
                    }
                
                    if (count == 3) {
                        return true;
                    }
                }
                previousPiece = grid[row][col];
            }
            row++;
        }
        return false;
    }
	
    /**
    * This method returns a boolean if the chosen player wins left diagonally or
    * downward diagonally.
    *
    * @param piece  char associated with the chosen player
    * @return       boolean whether player wins left diagonally
    */	
    private boolean isLeftDiagonal(char piece) {
        
        int count;

        for (int row = 0; row < grid.length - 3; row++)
        {
            for (int col = 0; col < grid[row].length - 3; col++)
            {
                if (piece == grid[row][col] && piece == grid[row + 1][col + 1] 
                        && piece == grid[row + 2][col + 2] 
                        && piece == grid[row + 3][col + 3])
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
    * This method returns a boolean if the chosen player wins right diagonally or
    * upward diagonally.
    *
    * @param piece  char associated with the chosen player
    * @return       boolean whether player wins right diagonally
    */
    private boolean isRightDiagonal(char piece) {
        for (int row = 0; row < grid.length - 3; row ++)
        {
            for (int col = 3; col < grid[row].length; col++)
            {
                if (piece == grid[row][col] && piece == grid[row + 1][col - 1]
                        && piece == grid[row + 2][col - 2]
                        && piece == grid[row + 3][col - 3]) 
                {
                    return true;
                }
                    
            }
        } 
        return false;
    }
	
    /**
    * This returns the next available row in the selected column.
    *
    * @param col    integer of the selected column
    * @return       integer of the next available row
    */
    public int nextAvailableRow(int col) {
        int result = 0;
        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][col - 1] == BLANK)
                return row;
        }
        return result;
    }
	
    /**
    * This returns a string representation of the Connect Four board.
    *
    * @return   a string representation of the board
    */
    public String toString() {
	String result = "";
	for (int row = 0; row < grid.length; row++) {
	    for (int col = 0; col < grid[row].length; col++) {
		result += grid[row][col] + " ";
	    }
			
	    result += "\n";
	}
	// label column numbers
	result += "1 2 3 4 5 6 7\n";
	
	return result;
    }
}
