import java.util.Random;

/** Description of GameBoard.java
 * Application generates an array of 64 "coordinates" on a 'BattleShip' game board. The board consists of 
 * 8 rows and 8 columns.  The original game was a 10 by 10 square.  There are no duplicates in the array.
 * Assignment Final (#4)
 *
 * @author Aaron Toth
 */
public class GameBoard 
{	
	/**
	 * Array that holds the 100 coordinates of the BattleShip gameboard
	 */
	private Coordinates[][] objectArray;	
	
	/**
	 * competitor who owns this.GameBoard
	 */
	private String competitor;
	
	/**
	 * boolean value becomes true if the player successfully hits the ship
	 */
	boolean attackStatus = false;
	
	/**
	 * X and Y coordinates that make up the String pair (i.e. B4).  Need this variables for when the user inputs
	 * a String value (i.e. B4) for either placing their ship on the board or attacking the computer ship(s).  The 
	 * String is parsed into a 'char' and int.  The 'char' is then converted to it's corresponding int value.  Finally the 
	 * 2 new int values are sent over as parameters (coordinates). 
	 */
	private int xIntCoordinate;
	private char yCharCoordinate;
	private int yIntCoordinate;
	
	/**
	 * Builds the game board
	 */
	public GameBoard(Ship DestroyerShip, Player Competitor, String playerName)
	{
		DestroyerShip = new Ship(0);
		Competitor = new Player(playerName);
		this.competitor = playerName;
		
		objectArray = new Coordinates[8][8];
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				objectArray[yIntCoordinate][xIntCoordinate] = new Coordinates(yIntCoordinate, xIntCoordinate);
			}
		}
	}
	
	/**
	 * Method places the players ship(s) on the board.
	 */
	public void placePlayerShips(String shipOneCoordinates, int shipType)
	{	
		yCharCoordinate = shipOneCoordinates.charAt(0); //parse at index[0] to get the char part
		xIntCoordinate = Character.getNumericValue(shipOneCoordinates.charAt(1)); //parse at index[1] to get int part
		
		char[] yCharArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}; //convert yCharCoordinate to corresponding int value
		int counter = 0;
		yIntCoordinate = 0; //re-initialize variable
		do
		{
			if(yCharCoordinate == yCharArray[counter])
			{
				yIntCoordinate = counter;
			}
			
			else
			{
				counter++;
			}
		}while(yIntCoordinate != counter);
		
		if(objectArray[yIntCoordinate][xIntCoordinate].getIsOccupied() == false) //check if ship already exists on coordinate
		{
			objectArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
			System.out.println("You have successfully placed your 1x1 destroyer on " + shipOneCoordinates);
		}
		
		else
		{
			System.out.println("Coordinates " + shipOneCoordinates + " have already been selected");
		}
	}
	
	/**
	 * Method sets the computers 1x1 ship on the computer's game board.  Doesn't check if coordinate is already occupied
	 */
	public void placeComputerShips()
	{
		final Random randomGenNumber = new Random();
		int yIntCoordinate;
		int xIntCoordinate;
		yIntCoordinate = randomGenNumber.nextInt(7);
		xIntCoordinate = randomGenNumber.nextInt(7);
		objectArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
		System.out.println(competitor + " has placed his 1x1 destroyer on his game board.");
		
		//turn on for testing or marking purposes
		System.out.println("Answer is " + yIntCoordinate + "" + xIntCoordinate + " or " + objectArray[yIntCoordinate][xIntCoordinate].getCoordinatePair());
	}
	
	/**
	 * Method checks the corresponding Coordinates object against the coordinates provided by player
	 * @param shipOneCoordinates
	 * @return
	 */
	public boolean attackShip(String shipOneCoordinates)
	{
		yCharCoordinate = shipOneCoordinates.charAt(0); //parse at index[0] to get the char part
		xIntCoordinate = Character.getNumericValue(shipOneCoordinates.charAt(1)); //parse at index[1] to get int part
		
		char[] yCharArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'}; //convert yCharCoordinate to corresponding int value
		int counter = 0;
		yIntCoordinate = 0; //re-initialize variable
		do
		{
			if(yCharCoordinate == yCharArray[counter])
			{
				yIntCoordinate = counter;
			}
			
			else
			{
				counter++;
			}
		}while(yIntCoordinate != counter);
		
		if(objectArray[yIntCoordinate][yIntCoordinate].getIsOccupied())
		{
			attackStatus = true;
			System.out.println("You hit the ship!");
			objectArray[yIntCoordinate][xIntCoordinate].setIsHit();
		}
		
		else
		{
			System.out.println("You missed");
			attackStatus = true;
		}
		
		return attackStatus;
	}
	
	/**
	 * Method plots the game board to the screen for the player or computer
	 * @param Competitor
	 */
	public void plotBoardToScreen(String competitor)
	{
		int counter = 0;
		System.out.println(competitor + "'s BattleShip Board");
		System.out.println("========================");
		
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				//System.out.printf("%s ", objectArray[yIntCoordinate][xIntCoordinate].getCoordinatePair());
				System.out.printf("%s ", objectArray[yIntCoordinate][xIntCoordinate].getDisplayStatus());
				//System.out.printf(String.format("%d%d ", yIntCoordinate, xIntCoordinate));
				counter++;
    	
				if (counter == 8)
				{
					System.out.println();
					counter = 0;
				}
			}
		}
		
		System.out.println();
	}
}
