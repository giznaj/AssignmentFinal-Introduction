import java.util.Random;

/**Description of GameBoard.java
 * Application generates an array of 64 "coordinates" on a 'BattleShip' game board. The board consists of 
 * 8 rows and 8 columns.  The original game was a 10 by 10 square.  There are no duplicates in the array.
 * Assignment Final (#4)
 *
 * @author Aaron Toth
 */
public class GameBoard 
{	
	/**
	 * Class variables
	 */
	final Random randomGenNumber = new Random();
	private Ship[] playerShipArray;
	private Ship[] computerShipArray;
	private Coordinates[][] playerCoordinateArray;
	private Coordinates[][] computerCoordinateArray;
	private boolean isPlaced = false;
	private boolean gameOverStatus = false;
	private Player PlayerOne;
	private Player PlayerComputer;
	private int shipsPlaced = 0;
	private int numberOfShips;
	private int computerShipsHit = 0;
	private int playerShipsHit = 0;
	
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
	 * Overloaded constructor.  Builds the game boards
	 */
	public GameBoard(String player, String computer, int numberOfShips)
	{
		this.numberOfShips = numberOfShips; //number of ships for each player
		PlayerOne = new Player(player);
		PlayerComputer = new Player(computer);
		
		//array of coordinates for the player
		xIntCoordinate = 0;
		yIntCoordinate = 0;
		playerCoordinateArray = new Coordinates[8][8];
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				playerCoordinateArray[yIntCoordinate][xIntCoordinate] = new Coordinates(yIntCoordinate, xIntCoordinate);
			}
		}
		
		//array of coordinates for the computer
		xIntCoordinate = 0;
		yIntCoordinate = 0;
		computerCoordinateArray = new Coordinates[8][8];
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				computerCoordinateArray[yIntCoordinate][xIntCoordinate] = new Coordinates(yIntCoordinate, xIntCoordinate);
			}
		}
	}
	
	/**
	 * Method places the players ship(s) on the board.
	 */
	public void placePlayerShips(String shipOneCoordinates, int shipType, int shipNumber)
	{	
		playerShipArray = new Ship[numberOfShips];
		yCharCoordinate = shipOneCoordinates.charAt(0); //parse at position 0 to get the char part of string
		xIntCoordinate = Character.getNumericValue(shipOneCoordinates.charAt(1)); //parse at position 1 to get int part of string
		
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
		
		if(!playerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsOccupied()) //check if ship already exists on coordinate
		{
			playerShipArray[shipNumber] = new Ship(0);
			playerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
			shipsPlaced = shipsPlaced + 1;
			System.out.println("You have successfully placed your #" + shipsPlaced + " 1x1 destroyer ship on " + shipOneCoordinates);
		}
		
		else
		{
			System.out.println("Coordinates " + shipOneCoordinates + " have already been selected");
		}
	}
	
	/**
	 * Method marks the computer's coordinates status appropriately (i.e. isOccuppied).  It also creates the ships for the
	 * computer player based on the number of ships provided by the user at the start of the application
	 */
	public void placeComputerShips(String competitor)
	{
		computerShipArray = new Ship[numberOfShips];
		int x; //counter
		for(x = 1; x <= numberOfShips; ++x)
		{
			do
			{
				final Random randomGenNumber = new Random();
				int yIntCoordinate;
				int xIntCoordinate;
				yIntCoordinate = randomGenNumber.nextInt(7);
				xIntCoordinate = randomGenNumber.nextInt(7);
				
				if(!computerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsOccupied()) //check if coordinates are occupied
				{
					computerShipArray[x-1] = new Ship(0); //create the ship objects for the computer
					computerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsOccupied();
					isPlaced = true;
				}
				else
				{
					System.out.println("Coordinates " + computerCoordinateArray[yIntCoordinate][xIntCoordinate].getCoordinatePair() + " 'Occupied' status is " + computerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsOccupied());
					System.out.println(PlayerComputer + " please choose again");
					isPlaced = false;
				}
			}while(!isPlaced);
		}
		
		System.out.println("HAL has successfully placed his " + numberOfShips + " 1x1 destroyer(s) on his board");
	}
	
	/**
	 * Method checks the corresponding Coordinates object against the coordinates provided by player
	 * @param shipOneCoordinates
	 * @return
	 */
	public void attackComputer(String targetCoordinates)
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
		
		if(computerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsOccupied())
		{
			computerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsHit();
			computerShipsHit = computerShipsHit + 1;
			System.out.println("You hit the computer's ship! (" + computerCoordinateArray[yIntCoordinate][xIntCoordinate].getCoordinatePair() +")");
		}
		
		else
		{
			computerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsAttacked();
			System.out.println("You missed the computer's ship! (" + computerCoordinateArray[yIntCoordinate][xIntCoordinate].getCoordinatePair() +")");
		}
		
		setGameStatus();
	}
	
	/**
	 * Method attacks the player by choosing a random coordinate in the player's Array
	 */
	public void attackPlayer()
	{
		int yIntCoordinate;
		int xIntCoordinate;
		do //checks for a coordinate pair that HAL hasn't fired at yet (isAttacked, isHit and isSunk == false at this point)
		{
			yIntCoordinate = randomGenNumber.nextInt(8);
			xIntCoordinate = randomGenNumber.nextInt(8);
		}while(playerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsAttacked());
	
		if(playerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsOccupied())
		{
			playerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsAttacked();
			playerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsHit();
			playerShipsHit = playerShipsHit + 1;
			System.out.println("Computer has hit your ship! (" + playerCoordinateArray[yIntCoordinate][xIntCoordinate].getCoordinatePair() +")");
		}
		
		else if(!playerCoordinateArray[yIntCoordinate][xIntCoordinate].getIsOccupied())
		{
			playerCoordinateArray[yIntCoordinate][xIntCoordinate].setIsAttacked();
			System.out.println("Computer has missed your ship! (" + playerCoordinateArray[yIntCoordinate][xIntCoordinate].getCoordinatePair() +")");
		}
		
		else
		{
			//todo
		}	
		
		setGameStatus();
	}
	
	/**
	 * Method plots the game board to the screen for the player or computer
	 * @param Competitor
	 */
	public void plotBoardToScreen()
	{
		int counter = 0;
		System.out.println("Legend: Alpha/Numeric = FREE, @@ = OCCUPIED, XX = MISS, $$ = HIT");
		System.out.println(PlayerOne.getPlayer() + "'s BattleShip Board"); //player one 
		System.out.println("========================");
		
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				System.out.printf("%s ", playerCoordinateArray[yIntCoordinate][xIntCoordinate].getDisplayStatus());
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
		System.out.println(PlayerComputer.getPlayer() + "'s BattleShip Board"); //computer
		System.out.println("========================");
		
		for(yIntCoordinate = 0; yIntCoordinate < 8; ++yIntCoordinate) //Y coordinate
		{
			for(xIntCoordinate = 0; xIntCoordinate < 8; ++xIntCoordinate) //X coordinate
			{
				System.out.printf("%s ", computerCoordinateArray[yIntCoordinate][xIntCoordinate].getDisplayStatus());
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
	
	/**
	 * Method sets the gameOverStatus value to true as soon as a ship has been hit
	 */
	public void setGameStatus()
	{
		if(getNumCompShipsHit() >= numberOfShips || getNumPlayerShipsHit() >= numberOfShips)
		{
			gameOverStatus = true;
		}
		
		else
		{
			gameOverStatus = false;
		}
	}
	
	/**
	 * Method returns the boolean value for the gameOverStatus field.  (if true, the game is over)
	 * @return
	 */
	public boolean getGameOverStatus()
	{	
		return gameOverStatus;
	}
	
	/**
	 * Method returns the boolean value for the isPlaced field
	 * @return
	 */
	public int getNumShipsPlaced()
	{
		return shipsPlaced;
	}
	
	/**
	 * Method returns the boolean value of the computerShipsHit field
	 * @return
	 */
	public int getNumCompShipsHit()
	{
		return computerShipsHit;
	}
	
	/**
	 * Method returns the boolean value of the playerShipsHit field
	 * @return
	 */
	public int getNumPlayerShipsHit()
	{
		return playerShipsHit;
	}
}
