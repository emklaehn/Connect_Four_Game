/**
 * @author Ela Klaehn, Zach Reents, Ez Powell
 *
 */
public class Player {
	private String name;
	private int score;
	private int winCounter;
	
	public Player(String playerName) {
		name = playerName;
		score = 0;
		winCounter = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getWinCounter() {
		return winCounter;
	}
	
	public void setScore(int playerScore) {
		score = playerScore;
	}
	
	public void addWinCounter() {
		winCounter++;
	}
	
	public void reset() {
		score = 0;
	}
	
	public String toString() {
		return 0;
	}
}
