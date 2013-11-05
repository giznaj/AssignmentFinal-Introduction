/** Description of Coordinates.java
 * Represents Coordinates on a 10 x 10 BattleShip Gameboard
 * Assignment #4
 *
 * @author Aaron Toth
 */
	public class Coordinates
	{
		/**
		 * X coordinate part of a x,y coordinate combination (i.e.  0,1,2,3...)
		 */
		private int xCoordinate;
		
		/**
		 * Y coordinate part of a x,y coordinate combination (i.e. A,B,C,D...)
		 */
		private char yCoordinate;
		
	    /**
	     * Default constructor for the Card class
	     */
		public Coordinates()
		{
			xCoordinate = '0';
			yCoordinate = 'A';
		}
		
		/**
		 * Overloaded constructor for the Coordinate class
		 * @param xIntCoordinate
		 * @param yCoordinate
		 */
		public Coordinates(int yIntCoordinate, int xIntCoordinate)
		{	
			if((yCoordinate >= 0 && yCoordinate < 8) && (xIntCoordinate >= 0 && xIntCoordinate < 8))
			{
				char[] yCoordinateArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
				yCoordinate = yCoordinateArray[yIntCoordinate];
				xCoordinate = xIntCoordinate;
			}
			
			else
			{
				System.out.println("Possible Error: 'X Coordinate' can only accept numbers (0-7) and " + xIntCoordinate + " was sent in the constructor");
				System.out.println("Possible Error: 'Y Coordinate' can only accept numbers (0-7) and " + yCoordinate + " was sent in the constructor");
				System.out.println("Please make sure to only send the approvaite values in range");
			}
		}
		
		
		/**
		 * Method returns the xCoordinate field value to the calling method
		 * @return
		 */
		public int getXCoordinate()
		{
			return xCoordinate;
		}
		
		/**
		 * Method returns the yCoordinate field value to the calling method
		 * @return
		 */
		public char getYCoordinate()
		{
			return yCoordinate;
		}
	}
