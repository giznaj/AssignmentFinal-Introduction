import java.util.ArrayList;

/** Description of GameBoard.java
 * Application generates an array of 64 "coordinates" on a 'BattleShip' game board. The board consists of 
 * 8 rows and 8 columns.  The original game was a 10 by 10 square.  There are no duplicates in the array.
 * Assignment #4
 *
 * @author Aaron Toth
 */
public class GameBoard 
{	
	/**
	 * Array that holds the 100 coordinates of the BattleShip gameboard
	 */
	public ArrayList<Coordinates> gameBoardArray;
	
	/**
	 * Main method() for this class.  Instantiates this.class
	 * @param args
	 */
	public static void main(String[] args)
	{
		GameBoard NewGameBoard = new GameBoard();
		NewGameBoard.buildTheBoard();
		NewGameBoard.displayTheBoard();
	}

	/**
	 * Default constructor for the Class.
	 */
	public GameBoard() 
	{
		
	}
	
	/**
	 * Method that creates and displays the array of Card objects.
	 * This method is invoked from the War3 class.
	 */
	public void buildTheBoard()
	{
		int xCoordinate;
		int yCoordinate;
		
		gameBoardArray = new ArrayList<Coordinates>(64);
		for(xCoordinate = 0; xCoordinate < 10; ++xCoordinate) //x coordinate
		{
			for(yCoordinate = 0; yCoordinate < 10; ++yCoordinate) //y coordinate
			{
				Coordinates TempCoordinate = new Coordinates(xCoordinate, yCoordinate);
				gameBoardArray.add(TempCoordinate);
			}
		}
	}
	
	/**
	 * Method that displays the array of Card objects
	 */
	public void displayTheBoard()
	{
		System.out.println("BattleShip Board");
		System.out.println("=====================");
		for(int x = 0; x < 100; ++x)
		{
			System.out.println("Coordinate " + (x + 1) + " : " + gameBoardArray.get(x).getXCoordinate() + "-" + gameBoardArray.get(x).getYCoordinate());
		}
	} 
}
