/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emklaehn, ZachReeee, eap22
 */
public class ConnectFourJUnit {
    
    public ConnectFourJUnit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting JUnit testing of Connect Four game . . .\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Finished JUnit testing of Connect Four game.");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testPlayerEquals() {
        Player playerOne = new Player("name");
        Player playerTwo = new Player("name");
        playerOne.addWinCounter();
        
        assertFalse("The players are not equal.", playerOne.equals(playerTwo));
        
        playerTwo.addWinCounter();
        
        assertTrue("The players are now equal.", playerOne.equals(playerTwo));
        
        
    }
    
    @Test
    public void testResetScore() {
        Player playerOne = new Player("name");
        playerOne.addNumMoves();
        playerOne.getScore();
        playerOne.resetScore();
        
        assertEquals("The score is equal to zero.", 0, playerOne.getScore());
    }
    
    @Test
    public void testGetScore() {
        Player playerOne = new Player("name");
        
        assertEquals("Score is equal to 0.", 0, playerOne.getScore());
        playerOne.addNumMoves();
        playerOne.addNumMoves();
        playerOne.addNumMoves();
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1700", 1700, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1600", 1600, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1500", 1500, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1400", 1400, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1300", 1300, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1200", 1200, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1100", 1100, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 1000", 1000, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 900", 900, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 800", 800, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 700", 700, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 600", 600, playerOne.getScore());
        playerOne.addNumMoves();
        assertEquals("Score is equal to 500", 500, playerOne.getScore());
        playerOne.addNumMoves();
        playerOne.addNumMoves();
        playerOne.addNumMoves();
        assertEquals("Score is equal to 200", 200, playerOne.getScore());
        playerOne.addNumMoves();
        playerOne.addNumMoves();
        assertEquals("Score is equal to 0", 0, playerOne.getScore());
    }
    
    @Test
    public void testResetWinCounter() {
        Player playerOne = new Player("name");
        playerOne.addWinCounter();
        
        assertEquals("The win counter is 1.", 1, playerOne.getWinCounter());
        assertNotEquals("The win counter is 0.", 0, playerOne.getWinCounter());
    }
    
    @Test
    public void testResetNumMoves() {
        Player playerOne = new Player("name");
        playerOne.addNumMoves();
        playerOne.resetNumMoves();
        
        assertEquals("The win counter is 0.", 0, playerOne.getNumMoves());
        assertNotEquals("The win counter is 1.", 1, playerOne.getWinCounter());
    }
    
    @Test
    public void testGetName() {
        Player playerOne = new Player("name");
        
        assertEquals("The name is found", "name", playerOne.getName());
    }
    
    @Test
    public void testGetNumMoves() {
        Player playerOne = new Player("name");
        playerOne.addNumMoves();
        
        assertEquals("The number of moves is 1.", 1, playerOne.getNumMoves());
        assertNotEquals("The number of moves is 0.", 0, playerOne.getNumMoves());
    }
    
    @Test
    public void testGetWinCounter() {
        Player playerOne = new Player("name");
        playerOne.addWinCounter();
        playerOne.resetWinCounter();
        
        assertEquals("The win counter is 0.", 0, playerOne.getWinCounter());
        assertNotEquals("The win counter is 1.", 1, playerOne.getWinCounter());
    }
    
    @Test
    public void testPlayerToString() {
        //come back to this later
        Player playerOne = new Player("name");
        playerOne.addWinCounter();
        
        assertEquals("The strings are not equal.", "\nname: Score = 0, Number of wins = 1\n", 
                playerOne.toString());
    }
    
    @Test
    public void testIsColumnFull() {
        Player playerOne = new Player("a");
        Player playerTwo = new Player("b");
        Board myBoard = new Board(playerOne, playerTwo);
        
        assertFalse("The column is not empty", myBoard.isColumnFull(1));
        
        for (int i = 0; i < 6; i++)
        {
            myBoard.addPiece(1, playerTwo);
        }
        
        assertTrue("The column is not full", myBoard.isColumnFull(1));      
    }
    
    @Test
    public void testIsBoardFull() {
        Player playerOne = new Player("a");
        Player playerTwo = new Player("b");
        Board myBoard = new Board(playerOne, playerTwo);
        
        assertFalse("The board is full", myBoard.isBoardFull());
        
        for (int i = 1; i < 7; i++)
        {
            for (int j = 1; j < 8; j++)
            {
                myBoard.addPiece(j, playerOne);
            }
        }
        
        assertTrue("The board is not full.", myBoard.isBoardFull());
    }
    
    @Test
    public void testIsWinner() {
        Player playerOne = new Player("a");
        Player playerTwo = new Player("b");
        Board myBoard = new Board(playerOne, playerTwo);
        Board horizontalBoard = new Board(playerOne, playerTwo);
        Board leftDiagonalBoard = new Board(playerOne, playerTwo);
        Board rightDiagonalBoard = new Board(playerOne, playerTwo);
        
        assertFalse("Winner", myBoard.isWinner(playerTwo));
        
        //Vertical winner test
        for (int a = 0; a < 4; a++)
        {
            myBoard.addPiece(1, playerTwo);
        }
        
        assertTrue("Loser", myBoard.isWinner(playerTwo));
        
        //Horizontal winner test
        for (int i = 1; i < 5; i++)
        {
            horizontalBoard.addPiece(i, playerOne);
        }
        
        assertTrue("Loser", horizontalBoard.isWinner(playerOne));
        
        //Diagonal left winner test
        for (int b = 1; b < 4; b++) 
        {
            leftDiagonalBoard.addPiece(2, playerTwo);
        }
        leftDiagonalBoard.addPiece(2, playerOne);
        
        for (int c = 1; c < 3; c++) 
        {
            leftDiagonalBoard.addPiece(3, playerTwo);
        }
        leftDiagonalBoard.addPiece(3, playerOne);
        
        leftDiagonalBoard.addPiece(4, playerTwo);
        leftDiagonalBoard.addPiece(4, playerOne);
        
        leftDiagonalBoard.addPiece(5, playerOne);
        
        assertTrue("Loser", leftDiagonalBoard.isWinner(playerOne));
        
        //Diagonal right winner test
        for (int b = 1; b < 4; b++) 
        {
            rightDiagonalBoard.addPiece(6, playerTwo);
        }
        rightDiagonalBoard.addPiece(6, playerOne);
        
        for (int c = 1; c < 3; c++) 
        {
            rightDiagonalBoard.addPiece(5, playerTwo);
        }
        rightDiagonalBoard.addPiece(5, playerOne);
        
        rightDiagonalBoard.addPiece(4, playerTwo);
        rightDiagonalBoard.addPiece(4, playerOne);
        
        rightDiagonalBoard.addPiece(3, playerOne);
        
        assertTrue("Loser", rightDiagonalBoard.isWinner(playerOne));
    }
    
    @Test
    public void testNextAvailableRow() {
        Player playerOne = new Player("a");
        Player playerTwo = new Player("b");
        Board myBoard = new Board(playerOne, playerTwo);
        
        assertEquals("Row 5 not available", 5, myBoard.nextAvailableRow(1));
        
        myBoard.addPiece(1, playerTwo);
        assertEquals("Row 4 is not available", 4, myBoard.nextAvailableRow(1));
    }
    
    @Test
    public void testBoardToString() {
        Player playerOne = new Player("a");
        Player playerTwo = new Player("b");
        Board myBoard = new Board(playerOne, playerTwo);
        String result = "";
        
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                result += "- ";
            }
            result += "\n";
        }       
        result += "1 2 3 4 5 6 7\n";

        
        assertEquals("The board is not empty.", result, myBoard.toString());
        
        //reset result variable
        result = "";
        
        for (int i = 1; i < 3; i++)
        {
            myBoard.addPiece(i, playerTwo);
        }
        
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                result += "- ";
            }
            result += "\n";
        }
        result += "O O - - - - - \n";
        result += "1 2 3 4 5 6 7\n";
        
        assertEquals("The board is empty.", result, myBoard.toString());       
    }    
}
