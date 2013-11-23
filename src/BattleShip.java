import java.util.Scanner;

/**Description of BattleShip.java
 * Battleship is a guessing game for two players. It is known worldwide as a pencil and paper game which dates 
 * from World War I. It was published by various companies as a pad-and-pencil game in the 1930s, and was 
 * released as a plastic board game by Milton Bradley in 1967.
 * Assignment #4
 *
 * @author Aaron Toth
 */
public class BattleShip
{	
	private GameBoard NewGameBoard; //new game board - holds 2x array(64)
	String playerOneName; //person player (you)
	final String playerTwoName = "HAL"; //computer player ("HAL")
	
	/**
	 * @param args not used
	 */
	public static void main(String[] args)
	{
		BattleShip newBattle = new BattleShip();
		newBattle.playBattleShip();
	}
	
	/**
	 * Method gathers the player name and then constructs the objects for the game
	 */
	public void playBattleShip()
	{	
		Scanner userInput = new Scanner(System.in);
		System.out.println("Your name please?");
		playerOneName = userInput.next();
		System.out.println("Good luck " + playerOneName + "!  You'll be playing " + playerTwoName + ".");
		System.out.println("Battleship boards (Y and X axis are A-H and 0-7 respectively)");
		System.out.println("Enter Alpha before Numeric at all times (i.e. C4, not 4C)");
		System.out.println();
		
		//constructors - creates a game board - 2x 8x8 Array(64)
		NewGameBoard = new GameBoard();
		
		//displays the player and computer empty game boards.
		NewGameBoard.plotBoardToScreen(playerOneName, playerTwoName);
		
		//places both of the computers 1x1 destroyer ships on the board
		NewGameBoard.placeComputerShips(playerTwoName); //ship #1
		NewGameBoard.placeComputerShips(playerTwoName); //ship #2
		System.out.println("HAL has successfully placed his 2 1x1 destroyers on his board");
		
		
		do //placing the player's 1x1 destroyer ships on the board (2x)
		{
			int shipType = 0;
			String shipOneCoordinates;
			System.out.println("Let's place your #" + (NewGameBoard.getNumShipsPlaced() + 1) + " 1x1 destroyer on the board.  Please select a coordinate pair (i.e. C4)");
			shipOneCoordinates = userInput.next().toUpperCase();
			NewGameBoard.placePlayerShips(shipOneCoordinates, shipType); //ship #1
		}while(NewGameBoard.getNumShipsPlaced() < 2);
		
		
		do //the guessing begins here (battle).  The battle continues until a player sinks 2 of the opponents ships
		{
			String targetCoordinates;
			System.out.println(playerOneName + ", fire away and select a coordinate pair to shoot (i.e. F2)");
			targetCoordinates = userInput.next().toUpperCase();
			NewGameBoard.attackComputer(targetCoordinates);
			NewGameBoard.attackPlayer();
			NewGameBoard.plotBoardToScreen(playerOneName, playerTwoName);
			
		}while(!NewGameBoard.getGameStatus());
		
		System.out.println("Great game guys!");
	}
}