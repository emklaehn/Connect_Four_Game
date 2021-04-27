/**
 * This class creates a player for the Connect Four game.
 * 
 * @author emklaehn, ZachReeee, eap22
 * 
 */
public class Player {
    private String name;
    private int score;
    private int winCounter;
    private int numMoves;
    private final int AVG_MOVES = 11;
	
    /**
    * This method creates a player, given a String.
    *
    * @param    playerName String name for refer to player
    */
    public Player(String playerName) {
	name = playerName;
	score = 0;
	winCounter = 0;
	numMoves = 0;
    }
	
    /**
    * This method returns a String of the name of the player.
    *
    * @return   String name of player
    */
    public String getName() {
	return name;
    }
	
    /**
    * This method returns an integer of the player's score. 
    *
    * @return   integer of the player's score
    */
    public int getScore() {
        return score;
    }

    /**
    * This method returns an integer of the player's total win count.
    *
    * @return   integer of player's win count
    */
    public int getWinCounter() {
	return winCounter;
    }

    /**
    * This method returns an integer of the number of moves for the player.
    *
    * @return   integer of the player's number of moves
    */
    public int getNumMoves() {
        return numMoves;
    }
	
    /**
    * This private method calculates the score for the player based on the 
    * number of moves.
    *
    */
    private void setScore() {
        /* 
        *   Take average number of moves which is 42 (total slots in board) divide
        *   by 2 and divide by 2 (for the player average moves) to get 11. Subtract
        *   from number of moves. Multiply by arbitrary large number (in this case 100),
        *   add 400 (least most moves needed * 100) and add 600 so the lowest 
        *   score is 0.
        */
        score = (((AVG_MOVES - numMoves) + 4) * 100) + 600;
    }
	
    /**
    * This method increments the win count of the player.
    *
    */
    public void addWinCounter() {
	winCounter++;
    }

    /**
    * This method increments the player's number of moves, and it also calls the
    * setScore method to calculate the score.
    *
    */
    public void addNumMoves() {
        numMoves++;
        setScore();
    }

    /**
    * This method resets the player's score to zero.
    *
    */
    public void resetScore() {
	score = 0;
    }
	
    /**
    * This method resets the player's win count to zero.
    *
    */
    public void resetWinCounter() {
	winCounter = 0;
    }
    
    /**
    * This method resets the player's number of moves to zero.
    *
    */
    public void resetNumMoves() {
        numMoves = 0;
    }
	
    /**
    * This method tests to see if two player objects are equal.
    *
    * @param    obj player object to compare
    * @return       boolean of whether or not player objects are equal
    */
    @Override
    public boolean equals(Object obj) {
	boolean result = false;
		
	if (obj != null && getClass() == obj.getClass()) {
	    Player other = (Player) obj;
	    result = name.equals(other.name)
		&& score == other.score
		&& winCounter == other.winCounter
		&& numMoves == other.numMoves;
	}
		
	return result;
    }
	
    /**
    * This returns a string representation of the player.
    *
    * @return   a string representation of the player
    */
    public String toString() {
	return "\n" + name + ": Score = " + score + ", Number of wins = " 
            + winCounter + "\n";
    }
}
