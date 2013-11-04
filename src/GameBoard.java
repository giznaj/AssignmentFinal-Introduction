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
	private ArrayList<Coordinates> gameBoardArray;
	
	
	public GameBoard()
	{
		int xCoordinate;
		int yCoordinate;
		
		gameBoardArray = new ArrayList<Coordinates>(64);
		for(xCoordinate = 0; xCoordinate < 8; ++xCoordinate) //x coordinate
		{
			for(yCoordinate = 0; yCoordinate < 8; ++yCoordinate) //y coordinate
			{
				Coordinates TempCoordinate = new Coordinates(xCoordinate, yCoordinate);
				gameBoardArray.add(TempCoordinate);
			}
		}
	}
	
	/**
	 * Method that displays the array of Card objects
	 */
	public void displayTheBoard(Player Competitor)
	{
		System.out.println("BattleShip Board for: " + Competitor.getPlayer());
		System.out.println("===================");
		for(int x = 0; x < 64; ++x)
		{
			System.out.println("Coordinate " + (x + 1) + " : " + gameBoardArray.get(x).getXCoordinate() + "-" + gameBoardArray.get(x).getYCoordinate());
		}
		
		System.out.println();
	} 
}
