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
	 * Player and Computer 'Ship' objects
	 */
	private Ship PlayerDestroyerShip;
	private Ship ComputerDestroyerShip;
	private Ship PlayerSubShip;
	private Ship ComputerSubShip;
	
	/**
	 * competitor who owns this.GameBoard
	 */
	private String competitor;
	
	/**
	 * X and Y coordinates that make up the String pair (i.e. B4).  Need this variables for when the user inputs
	 * a String value (i.e. B4) for either placing their ship on the board or attacking the computer ship(s).  The 
	 * String is parsed into a 'char' and int.  The 'char' is then converted to it's corresponding int value.  Finally the 
	 * 2 new int values are sent over as parameters (coordinates). 
	 */
	private int xIntCoordinate;
	private char yCharCoordinate;
	private int yIntCoordinate;
	
	//constructors : 2 competitors in the game of battleship (player and computer)
	Player UserPlayer = new Player(competitor);
	Player ComputerPlayer = new Player(competitor);
	
	/**
	 * Builds the game board
	 */
	public GameBoard(String competitor)
	{
		this.competitor = competitor; //holds the value of the competitors name for this.GameBoard
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
	 * Method sets the computers 1x1 ship on the computer's game board.  Doesn't check if coordinate is already occupied
	 */
	public void placeComputerShips()
	{
		final Random randomGenNumber = new Random();
		int yIntCoordinate;
		int xIntCoordinate;
		yIntCoordinate = randomGenNumber.nextInt(7);
		xIntCoordinate = randomGenNumber.nextInt(7);
		System.out.println(yIntCoordinate + "" + xIntCoordinate);
		objectArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
	}
	
	/**
	 * Method places the players ship(s) on the board.
	 */
	public void placePlayerShips(Player competitor, String shipOneCoordinates, int shipType)
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
				System.out.printf("%s ", objectArray[yIntCoordinate][xIntCoordinate].getCoordinatePair());
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
