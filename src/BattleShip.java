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
	private GameBoard NewGameBoard; //new game board
	
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
		System.out.println("Battleship boards (size = 8x8 : y-axis = 'A-F' : x-axis = '0-7')");
		System.out.println("Legend: 'A3' = FREE; '@@' = OCCUPIED; 'XX' = MISS; '$$' = HIT");
		System.out.println();
		
		//constructors - creates a game board for both PlayerOne and the Computer
		NewGameBoard = new GameBoard();
		
		//displays the player and computer game board.
		NewGameBoard.plotBoardToScreen(playerOneName, playerTwoName);
		
		//placing the computer's 1x1 destroyer ship on the board
		NewGameBoard.placeComputerShips(playerTwoName); //ship #1
		NewGameBoard.placeComputerShips(playerTwoName); //ship #2
		
		//placing the player's 1x1 destroyer ships on the board
		String shipOneCoordinates;
		System.out.println("Let's place your 1st 1x1 destroyer on your board.  Please select a coordinate pair (i.e. C4)");
		shipOneCoordinates = userInput.next().toUpperCase();
		int shipType = 0;
		NewGameBoard.placePlayerShips(shipOneCoordinates, shipType);
		System.out.println("Let's place your 2nd 1x1 destroyer on your board.  Please select a coordinate pair (i.e. C4)");
		shipOneCoordinates = userInput.next().toUpperCase();
		NewGameBoard.placePlayerShips(shipOneCoordinates, shipType);
		
		//the guessing begins here (battle).  The battle continues until a player sinks 2 of the opponents ships
		do
		{
			String targetCoordinates;
			System.out.println(playerOneName + ", fire away and select a coordinate pair to shoot (i.e. F2)");
			targetCoordinates = userInput.next().toUpperCase();
			NewGameBoard.attackComputer(targetCoordinates);
			NewGameBoard.attackPlayer();
			NewGameBoard.plotBoardToScreen(playerOneName, playerTwoName);
			
		}while(!NewGameBoard.getGameStatus());
	}
}