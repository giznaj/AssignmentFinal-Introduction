/** Description of Coordinates.java
 * Represents Coordinates on a 10 x 10 BattleShip Gameboard
 * Assignenment #4
 *
 * @author Aaron Toth
 */
	public class Coordinates
	{
		/**
		 * x coordinate part of a x,y coordinate combination
		 */
		private char xCoordinate;
		
		/**
		 * y coordinate part of a x,y coordinate combination
		 */
		private int yCoordinate;
		
	    /**
	     * Default constructor for the Card class
	     */
		public Coordinates()
		{
			xCoordinate = 'A';
			yCoordinate = 0;
		}
		
		/**
		 * Overloaded constructor for the Coordinate class
		 * @param xIntCoordinate
		 * @param yCoordinate
		 */
		public Coordinates(int xIntCoordinate, int yCoordinate)
		{	
			if((xIntCoordinate >= 0 && xIntCoordinate < 10) && (yCoordinate >= 0 && yCoordinate < 10))
			{
				char[] xCoordinateArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
				xCoordinate = xCoordinateArray[xIntCoordinate];
				this.yCoordinate = yCoordinate;
			}
			
			else
			{
				System.out.println("Possible Error: 'X Coordinate' can only accept numbers (0-9) and " + xIntCoordinate + " was sent in the constructor");
				System.out.println("Possible Error: 'Y Coordinate' can only accept numbers (0-9) and " + yCoordinate + " was sent in the constructor");
				System.out.println("Please make sure to only send the approvaite values in range");
			}
		}
		
		
		/**
		 * Method returns the xCoordinate field value to the calling method
		 * @return
		 */
		public char getXCoordinate()
		{
			return xCoordinate;
		}
		
		/**
		 * Method returns the yCoordinate field value to the calling method
		 * @return
		 */
		public int getYCoordinate()
		{
			return yCoordinate;
		}
	}
