import java.util.Scanner;

/** Description of BattleShip.java
 * Battleship is a guessing game for two players. It is known worldwide as a pencil and paper game which dates 
 * from World War I. It was published by various companies as a pad-and-pencil game in the 1930s, and was 
 * released as a plastic board game by Milton Bradley in 1967.
 * Assignment #4
 *
 * @author Aaron Toth
 */
public class BattleShip
{	
	/**
	 * Class variables.  There is a 1:1 of GameBoard to Player object
	 */
	GameBoard UserBoard;
	GameBoard ComputerBoard;
	Player UserPlayer;
	Player UserComputer;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BattleShip newBattle = new BattleShip();
		newBattle.playBattleShip();
	}
	
	/**
	 * This method gathers the details of the user and then constructs the objects for the game
	 */
	public void playBattleShip()
	{
		String playerName;
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Your name please?");
		playerName = kb.next();
		System.out.println("Thanks and good luck " + playerName + "!  You'll need it - hehehehe");
		System.out.println();
		
		// constructors : the players of the game (player versus computer)
		UserPlayer = new Player(playerName);
		UserComputer = new Player("HAL");
		
		// constructors : each game board for each of the players
		UserBoard = new GameBoard();
		ComputerBoard = new GameBoard();
		
		//test purposes : shows the array(s), their indexes and the values at each index
		//UserBoard.testDisplayBoard();
		//ComputerBoard.testDisplayBoard();
		
		UserBoard.plotBoardToScreen();
	}
}
