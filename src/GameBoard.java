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
	private Coordinates[][] objectArray;
	
	/**
	 * X and Y coordinates that make up the String pair (i.e. B4)
	 */
	private int xCoordinate;
	private int yCoordinate;
	
	/**
	 * Builds the game board
	 */
	public GameBoard()
	{	
		objectArray = new Coordinates[8][8];
		
		for(yCoordinate = 0; yCoordinate < 8; ++yCoordinate) //Y coordinate
		{
			for(xCoordinate = 0; xCoordinate < 8; ++xCoordinate) //X coordinate
			{
				objectArray[yCoordinate][xCoordinate] = new Coordinates(yCoordinate, xCoordinate);
			}
		}
	}
	
	/**
	 * test purposes : shows the array(s), their indexes and the values at each index
	 */
	public void testDisplayBoard(Player Competitor)
	{
		System.out.println("BattleShip Board for: " + Competitor.getPlayer());
		System.out.println("===========================");
		for(yCoordinate = 0; yCoordinate < 8; ++yCoordinate) //Y coordinate
		{
			for(xCoordinate = 0; xCoordinate < 8; ++xCoordinate) //X coordinate
			{
				System.out.println("objectArray @ index[" + yCoordinate + "][" + xCoordinate + "] = " + objectArray[yCoordinate][xCoordinate].getYCoordinate() + objectArray[yCoordinate][xCoordinate].getXCoordinate());
			}
		}
		
		System.out.println();
	} 
	
	
	public void plotBoardToScreen()
	{
		int counter = 0;
		for(yCoordinate = 0; yCoordinate < 8; ++yCoordinate) //Y coordinate
		{
			for(xCoordinate = 0; xCoordinate < 8; ++xCoordinate) //X coordinate
			{
				System.out.print(String.format("%c%d ", yCoordinate, xCoordinate));
				counter++;
    	
				if (counter == 8)
				{
					System.out.println();
					counter = 0;
				}
			}
		}
	}
}
