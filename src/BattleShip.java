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
	private GameBoard PlayerOneBoard; //user game board
	private GameBoard PlayerTwoBoard; //computer game board
	
	private Player PlayerOne;
	private Player PlayerTwo;
	
	private Ship PlayOneDestroy;
	private Ship PlayTwoDestroy;
	
	/**
	 * holds the competitors name who is playing the computer
	 */
	String playerOneName;
	
	/**
	 * @param args not used
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
		final String playerTwoName = "HAL";
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Your name please?");
		playerOneName = userInput.next();
		System.out.println("Good luck " + playerOneName + "!  You will need it!");
		System.out.println("Your Battleship board (size = 8x8 : y-axis = 'A-F' : x-axis = '0-7')");
		System.out.println();
		
		//constructors - creates a game board for both PlayerOne and PlayerTwo
		PlayerOneBoard = new GameBoard(PlayOneDestroy, PlayerOne, playerOneName); //players game board
		//PlayerTwoBoard = new GameBoard(PlayTwoDestroy, PlayerTwo, playerTwoName); //computers game board
		
		//displays the player and computer game board.  This is so the user can see where to place his/her ship(s).
		PlayerOneBoard.plotBoardToScreen(playerOneName);
		PlayerTwoBoard.plotBoardToScreen(playerTwoName);
		
		//sends the first ships coordinates.  Method passes the coordinates and the game board both as parameters.
		//1st ship is a 1x1 for both the player and the computer
		String shipOneCoordinates;
		System.out.println("Let's place your 1x1 destroyer on your board.  Please select the coordinates (i.e. C4)");
		shipOneCoordinates = userInput.next().toUpperCase();
		int shipType = 0;
		PlayerOneBoard.placePlayerShips(shipOneCoordinates, shipType);
		PlayerTwoBoard.placeComputerShips();
		
		String targetCoordinates;
		System.out.println(playerOneName + " fire away and select a coordinate to shoot? (i.e. F2)");
		targetCoordinates = userInput.next();
		
		PlayerTwoBoard.attackShip(targetCoordinates);
	}
}
