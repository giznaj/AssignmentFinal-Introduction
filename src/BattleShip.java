import java.util.Scanner;
import java.util.InputMismatchException;

/* Description of BattleShip.java
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
	private int numberOfShips;
	
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
		System.out.println("Battleship boards: (Y and X axis are A-H and 0-7 respectively)");
		System.out.println("When entering coordinates, enter them in alpha/numeric order (i.e. C4, not 4C)");
		
		//get number of ships for each player for the game.  Maximum is 3
		try
		{
			do
			{
				System.out.println("Okay, let's get started.  How many ships do you want to play with? (1, 2 or 3)");
				numberOfShips = userInput.nextInt();
			}while(numberOfShips <= 0 || numberOfShips >= 4);
			
		}catch (InputMismatchException erMsg)
		{
			System.out.println("Error: " + erMsg.toString());
			userInput.close();
			return;
		}
		
		//constructors - creates a game board - 2x 8x8 Array(64)
		NewGameBoard = new GameBoard(playerOneName, playerTwoName, numberOfShips);
		
		//displays the player and computer empty game boards.
		NewGameBoard.plotBoardToScreen();
		
		//places the player's 1x1 destroyer ships on the board (numberOfShips)
		do 
		{
			int shipNumber;
			int shipType = 0;
			String shipOneCoordinates;
			System.out.println("Let's place your #" + (NewGameBoard.getNumShipsPlaced() + 1) + " 1x1 destroyer on the board.  Please select a coordinate pair (i.e. C4)");
			shipOneCoordinates = userInput.next().toUpperCase();
			shipNumber = NewGameBoard.getNumShipsPlaced();
			NewGameBoard.placePlayerShips(shipOneCoordinates, shipType, shipNumber);
		}while(NewGameBoard.getNumShipsPlaced() < numberOfShips);
	
		
		//places the computers 1x1 destroyer ships on the board
		NewGameBoard.placeComputerShips(playerTwoName);
		
		//the guessing begins here (battle).  The battle continues until a player sinks all of the opponents ships
		do 
		{
			String targetCoordinates;
			System.out.println(playerOneName + ", fire away and select a coordinate pair to shoot (i.e. F2)");
			targetCoordinates = userInput.next().toUpperCase();
			NewGameBoard.attackComputer(targetCoordinates);
			NewGameBoard.attackPlayer();
			NewGameBoard.plotBoardToScreen();
			
		}while(!NewGameBoard.getGameOverStatus());
		
		System.out.println("Great game guys!");
		userInput.close();
	}
}