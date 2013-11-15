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
	 * Array that holds the 64 coordinates of the BattleShip game board
	 */
	private Coordinates[][] playerObjectArray;
	private Coordinates[][] computerObjectArray;
	
	/**
	 * competitor who owns this.GameBoard
	 */
	private String competitor;
	
	/**
	 * boolean value becomes true if the respective player has been successfully hit
	 */
	boolean playerOneAttackedStatus = false;
	boolean computerAttackedStatus = false;
	
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
	 * Builds the game boards
	 */
	public GameBoard()
	{
		xIntCoordinate = 0;
		yIntCoordinate = 0;
		playerObjectArray = new Coordinates[8][8];
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				playerObjectArray[yIntCoordinate][xIntCoordinate] = new Coordinates(yIntCoordinate, xIntCoordinate);
			}
		}
		
		xIntCoordinate = 0;
		yIntCoordinate = 0;
		computerObjectArray = new Coordinates[8][8];
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				computerObjectArray[yIntCoordinate][xIntCoordinate] = new Coordinates(yIntCoordinate, xIntCoordinate);
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
		
		if(playerObjectArray[yIntCoordinate][xIntCoordinate].getIsOccupied() == false) //check if ship already exists on coordinate
		{
			playerObjectArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
			playerObjectArray[yIntCoordinate][xIntCoordinate].setDisplayStatus();
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
	public void placeComputerShips(String competitor)
	{
		final Random randomGenNumber = new Random();
		int yIntCoordinate;
		int xIntCoordinate;
		yIntCoordinate = randomGenNumber.nextInt(7);
		xIntCoordinate = randomGenNumber.nextInt(7);
		computerObjectArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
		computerObjectArray[yIntCoordinate][xIntCoordinate].setDisplayStatus();
		System.out.println(competitor + " has placed his 1x1 destroyer on his game board.");
		
		//turn on for testing or marking purposes
		System.out.println(computerObjectArray[yIntCoordinate][xIntCoordinate].getCoordinatePair());
	}
	
	/**
	 * Method checks the corresponding Coordinates object against the coordinates provided by player
	 * @param shipOneCoordinates
	 * @return
	 */
	public boolean attackComputer(String targetCoordinates)
	{
		yCharCoordinate = targetCoordinates.charAt(0); //parse at index[0] to get the char part
		xIntCoordinate = Character.getNumericValue(targetCoordinates.charAt(1)); //parse at index[1] to get int part
		
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
		
		if(computerObjectArray[yIntCoordinate][yIntCoordinate].getIsOccupied())
		{
			computerObjectArray[yIntCoordinate][xIntCoordinate].setIsHit();
			computerObjectArray[yIntCoordinate][xIntCoordinate].setDisplayStatus();
			computerAttackedStatus = true;
			System.out.println("You hit the computer's ship!");
		}
		
		else
		{
			computerObjectArray[yIntCoordinate][xIntCoordinate].setIsAttacked();
			computerObjectArray[yIntCoordinate][xIntCoordinate].setDisplayStatus();
			computerAttackedStatus = false;
			System.out.println("You missed the computer's ship");
		}
		
		return computerAttackedStatus;
	}
	
	/**
	 * Method attacks the player by choosing a random coordinate in the player's Array
	 */
	public boolean attackPlayer()
	{
		final Random randomGenNumber = new Random();
		int yIntCoordinate;
		int xIntCoordinate;
		yIntCoordinate = randomGenNumber.nextInt(7);
		xIntCoordinate = randomGenNumber.nextInt(7);
	
		if(playerObjectArray[yIntCoordinate][yIntCoordinate].getIsOccupied())
		{
			playerObjectArray[yIntCoordinate][xIntCoordinate].setIsHit();
			playerObjectArray[yIntCoordinate][xIntCoordinate].setDisplayStatus();
			playerOneAttackedStatus = true;
			System.out.println("Computer has hit your ship!");
		}
		
		else
		{
			playerObjectArray[yIntCoordinate][xIntCoordinate].setIsAttacked();
			playerObjectArray[yIntCoordinate][xIntCoordinate].setDisplayStatus();
			playerOneAttackedStatus = false;
			System.out.println("Computer missed your ship");
		}
		
		return playerOneAttackedStatus;	
	}
	
	/**
	 * Method plots the game board to the screen for the player or computer
	 * @param Competitor
	 */
	public void plotBoardToScreen(String player, String computer)
	{
		int counter = 0;
		System.out.println(player + "'s BattleShip Board"); //player one 
		System.out.println("========================");
		
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				System.out.printf("%s ", playerObjectArray[yIntCoordinate][xIntCoordinate].getDisplayStatus());
				counter++;
    	
				if (counter == 8)
				{
					System.out.println();
					counter = 0;
				}
			}
		}
		
		System.out.println();
		
		counter = 0;
		System.out.println(computer + "'s BattleShip Board"); //computer
		System.out.println("========================");
		
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				System.out.printf("%s ", computerObjectArray[yIntCoordinate][xIntCoordinate].getDisplayStatus());
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
