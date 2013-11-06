/** Description of Coordinates.java
 * Represents Coordinates on a 10 x 10 BattleShip Gameboard
 * Assignment #4
 *
 * @author Aaron Toth
 */
	public class Coordinates
	{
		/**
		 * X coordinate part (int format) of a x,y coordinate combination (i.e.  0,1,2,3...)
		 */
		private int xIntCoordinate;
		
		/**
		 * Y coordinate part (int format) of a x,y coordinate combination (i.e. A,B,C,D...)
		 */
		private int yIntCoordinate;
		
		/**
		 * Y coordinate part (char format) of a x.y coordinate combination (i.e.  0,1,2,3...)
		 */
		private char yCharCoordinate;
		
		
		/**
		 * Boolean value for this coordinates 'occupied status.  (if the ship is on the coordinate, isOccupied = true)
		 */
		private boolean isOccupied = false;
		
	    /**
	     * Default constructor for the Card class
	     */
		public Coordinates()
		{
			yIntCoordinate = '0';
			yCharCoordinate = 'A';
		}
		
		/**
		 * Overloaded constructor for the Coordinate class.  Builds the Object for the Array in GameBoard.java
		 * @param xIntCoordinate
		 * @param yCoordinate
		 */
		public Coordinates(int yIntCoordinate, int xIntCoordinate)
		{	
			if((yIntCoordinate >= 0 && yIntCoordinate < 8) && (xIntCoordinate >= 0 && xIntCoordinate < 8))
			{
				char[] yCharArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
				yCharCoordinate = yCharArray[yIntCoordinate];
				this.yIntCoordinate = yIntCoordinate;
				this.xIntCoordinate = xIntCoordinate;
			}
			
			else
			{
				System.out.println("Possible Error: 'X Coordinate' can only accept numbers (0-7) and " + xIntCoordinate + " was sent in the constructor");
				System.out.println("Possible Error: 'Y Coordinate' can only accept numbers (0-7) and " + yIntCoordinate + " was sent in the constructor");
				System.out.println("Please make sure to only send the approvaite values in range");
			}
		}
		
		
		public void setIsOccupied()
		{
			isOccupied = true;
		}
		
		
		/**
		 * Method returns the xCoordinate field value to the calling method
		 * @return
		 */
		public int getXIntCoordinate()
		{
			return xIntCoordinate;
		}
		
		/**
		 * Method returns the yCoordinate field value (int value) to the calling method
		 * @return
		 */
		public int getYIntCoordinate()
		{
			return yIntCoordinate;
		}
		
		/**
		 * Method returns the yCoordinate field value (char value) to the calling method
		 * @return
		 */
		public char getYCharCoordinate()
		{
			return yCharCoordinate;
		}
		
	}
