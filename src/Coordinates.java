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
		 * String of the concatenation of the 'char' and the 'int' values (i.e. 'A' + 4 = "A4")
		 */
		private String coordinatePair;
		
		/**
		 * Value holds the displaStatus string that is displayed for each of the coordinates
		 */
		private String displayStatus;
		
		/**
		 * Boolean value for this coordinates 'occupied status.  (if the ship is on the coordinate, isOccupied = true)
		 */
		private boolean isOccupied = false;
		
		/**
		 * Boolean value that represents if the coordinate has been shot at.
		 */
		private boolean isAttacked = false;
		
		/**
		 * Boolean value that represents if the ship has been hit or not
		 */
		private boolean isHit = false;
		
		/**
		 * Boolean value that represents if the ship has been sunk or not
		 */
		private boolean isSunk = false;
		
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
				coordinatePair = yCharCoordinate + "" + xIntCoordinate;
				isOccupied = false; //maybe not needed. -- needs testing
				setDisplayStatus();
			}
			
			else
			{
				System.out.println("Possible Error: 'X Coordinate' can only accept numbers (0-7) and " + xIntCoordinate + " was sent in the constructor");
				System.out.println("Possible Error: 'Y Coordinate' can only accept numbers (0-7) and " + yIntCoordinate + " was sent in the constructor");
				System.out.println("Please make sure to only send the approvaite values in range");
			}
		}
		
		/**
		 * Sets the boolean value IsOccupied to true. (if ship occupies coordinates, 'isOccupied' becomes true).  When this 
		 * flag is true, another ship cannot occupy this coordinate.
		 */
		public void setIsOccupied()
		{
			isOccupied = true;
		}
		
		/**
		 * Sets the isHit boolean value to true if the ship is successfully hit
		 */
		public void setIsHit()
		{
			isHit = true;	
		}
		
		/**
		 * Sets the isSunk boolean value to true if the ship goes under water after it's last hit
		 */
		public void setIsSunk()
		{
			isSunk = true;
		}
		
		/**
		 * Method responsible for showing the 2 digit 'char' values on the each game board
		 */
		public void setDisplayStatus()
		{
			if(!isOccupied)
			{
				displayStatus = getCoordinatePair();
			}
			
			else if(isHit)
			{
				displayStatus = "$$";
			}
			
			else if(!isHit)
			{
				displayStatus = "??";
			}
			
			else if(isSunk)
			{
				displayStatus = "XX";
			}
			
			else
			{
				//do nothing for now
			}
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
		
		/**
		 * Method returns the value assigned to the coordinatePair field.
		 * @return
		 */
		public String getCoordinatePair()
		{
			coordinatePair = getYCharCoordinate() + "" + getXIntCoordinate();
			return coordinatePair;
		}
		
		/**
		 * Method returns the Boolean value for t
		 * @return
		 */
		public boolean getIsOccupied()
		{
			return isOccupied;
		}	
		
		/**
		 * Returns the string pair (2 digits) for display on each of the game boards
		 * @return
		 */
		public String getDisplayStatus()
		{
			return displayStatus;
		}
	}
