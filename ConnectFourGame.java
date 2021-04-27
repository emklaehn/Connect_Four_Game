/**
 * This is the CUI version of the Connect Four game; this plays the Connect
 * Four game.
 * 
 * @author emklaehn, ZachReeee, eap22
 * 
 */
import java.util.Scanner;
import java.lang.NumberFormatException;

public class ConnectFourGame {
    /**
    * This provides the instructions for the Connect Four game, and gets the names
    * of the players.
    * 
    * @param args   the command line; just the file
    * 
    */
    public static void main(String[] args) {
        System.out.println("\t*** WELCOME TO CONNECT FOUR ***\n");
        System.out.println("This program plays a game of Connect Four.\n");
        System.out.println("Two players will select which column to drop " 
            + "their piece into.");
        System.out.println("The first player to match four of their pieces " 
            + "in a row/column/diagonal wins.");
        System.out.println("Player one will be 'X' while player two will be"
            + " 'O'. The score is calculated");
        System.out.println("by the number of moves it takes a player before the"
            + " game is finished. Also,");
        System.out.println("there is a win count in case you want to play"
            + " again.\n");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please enter player 1's name: ");
        Player playerOne = new Player(scan.next());
        
        System.out.print("\nPlease enter player 2's name: ");
        Player playerTwo = new Player(scan.next());
        
        System.out.println("\nPlayer one: " + playerOne.getName());
        System.out.println("Player two: " + playerTwo.getName());
        
        playGame(playerOne, playerTwo);
    }
    
    /**
    * This method creates the board and starts the game.
    * 
    * @param playerOne  player object for first player
    * @param playerTwo  player object for second player
    */
    public static void playGame(Player playerOne, Player playerTwo) {
        Board gameBoard = new Board(playerOne, playerTwo);
        do {
            playerTurn(playerOne, gameBoard);
            if (!gameBoard.isWinner(playerOne)) {
                playerTurn(playerTwo, gameBoard);
            }
        } while (!gameBoard.isWinner(playerOne) && !gameBoard.isWinner(playerTwo) 
              && !gameBoard.isBoardFull());
        
        if (gameBoard.isBoardFull()) {
            System.out.println("\nThe board is full, so it is a draw.\n");
        }
        
        if (gameBoard.isWinner(playerTwo))
        {
            playerWin(playerTwo, gameBoard);
        }
        else if (gameBoard.isWinner(playerOne))
        {
            playerWin(playerOne, gameBoard);
        }
        playAgain(playerOne, playerTwo);
    }
    
    /**
    * This method does the turn for each player.
    * 
    * @param player player object for player
    * @param game   game board to record player moves
    */
    public static void playerTurn(Player player, Board game) {
        Scanner scanOne = new Scanner(System.in);
        Scanner scanTwo = new Scanner(System.in);
        System.out.println("\n" + game.toString());
        System.out.println("It is " + player.getName() + "'s turn.");
        System.out.print("Would you like to continue playing? (Y/N) ");
        String response = scanOne.next().toUpperCase();
        while (!response.equals("Y") && !response.equals("N")) {
            System.out.println("\nInvalid response");
            System.out.print("Would you like to continue playing? (Y/N) ");
            response = scanOne.next().toUpperCase();
        }
        if (response.equals("N")) {
            System.out.println("\nThanks for playing!");
            System.exit(0);
        }
        
        int col = 0;
        boolean intError = true;
        do {
            try {
                System.out.print("\nChoose a column: ");
                col = Integer.parseInt(scanTwo.nextLine());
                // need to add a try-catch method
                while (col < 1 || col > 7 || game.isColumnFull(col)) {
                    System.out.println("\nColumn is full or incorrect number selected.");
                    System.out.print("Choose a column: ");
                    col = Integer.parseInt(scanTwo.nextLine());
                }
                intError = false;
            }
            catch (NumberFormatException e) {
                System.err.println("Error: Invalid input. Not an integer.");
            }
        } while(intError);
    
        game.addPiece(col, player);
        player.addNumMoves();
    }
    
    /**
    * This method shows the winner of the game.
    * 
    * @param player player object for player
    * @param game   game board to record player moves
    */
    public static void playerWin(Player player, Board game) {
        player.addWinCounter();
        System.out.println(game.toString());
        System.out.println("\n" + player.getName() + " wins!");
        System.out.println(player.toString());
       
    }
    
    /**
    * This method asks if the players wish to restart the game.
    * 
    * @param playerOne  player object for first player
    * @param playerTwo  player object for second player
    */
    public static void playAgain(Player playerOne, Player playerTwo) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Would you like to play again? (Y/N) ");
        String response = scan.next().toUpperCase();
        while (!response.equals("Y") && !response.equals("N")) {
            System.out.println("Invalid response");
            System.out.print("Would you like to play again? (Y/N) ");
            response = scan.next().toUpperCase();
        } 
        System.out.println();
        
        if (response.equals("Y")) {
            playerOne.resetScore();
            playerTwo.resetScore();
            playerOne.resetNumMoves();
            playerTwo.resetNumMoves();
            playGame(playerOne, playerTwo);
        }
        else {
            System.out.println("Thanks for playing!");
        }
    }

}
