/**Description of Coordinates.java
 * Represents Coordinates on a 10 x 10 BattleShip Gameboard
 * Assignment #4
 * Used for AssignmentFinal-Intro
 *
 * @author Aaron Toth
 */
	public class Coordinates
	{
		private int xIntCoordinate;
		private int yIntCoordinate;
		private char yCharCoordinate;
		private String coordinatePair;
		private String displayStatus;
		private boolean isOccupied = false;
		private boolean isAttacked = false;
		private boolean isHit = false;
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
		 * Sets the boolean value IsOccupied to true. (if ship occupies coordinates, 'isOccupied' becomes true) 
		 * If flag is true, another ship cannot occupy this coordinate.
		 */
		public void setIsOccupied()
		{
			isOccupied = true;
			setDisplayStatus();
		}
		
		/**
		 * Sets the boolean value IsAttacked to true. (if coordinate has been shot at, 'isAttacked' becomes true)
		 */
		public void setIsAttacked()
		{
			isAttacked = true;
			setDisplayStatus();
		}
		
		/**
		 * Sets the isHit boolean value to true if the ship is successfully hit
		 */
		public void setIsHit()
		{
			isHit = true;
			setDisplayStatus();
		}
		
		/**
		 * Sets the isSunk boolean value to true if the ship goes under water after it's last hit
		 */
		public void setIsSunk()
		{
			isSunk = true;
			setDisplayStatus();
		}
		
		/**
		 * Method responsible for setting the 2 digit 'char' values on the each game board
		 */
		public void setDisplayStatus()
		{
			if(isHit)
			{
				displayStatus = "$$";
			}
			
			else if(isAttacked)
			{
				displayStatus = "XX";
			}
			
			else if(isOccupied)
			{
				displayStatus = "@@";
			}
			
			else if(!isOccupied)
			{
				displayStatus = getCoordinatePair();
			}
			
			else
			{
				System.out.println("That is not a proper displayStatus " + displayStatus);
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
		 * Returns the boolean value assigned to isOccupied field
		 * @return
		 */
		public boolean getIsOccupied()
		{
			return isOccupied;
		}
		
		/**
		 * Returns the boolean value for the isAttacked status for the given coordinate pair
		 * @return
		 */
		public boolean getIsAttacked()
		{
			return isAttacked;
		}
		
		/**
		 * Returns the boolean value assigned to isHit field
		 * @return
		 */
		public boolean getIsHit()
		{
			return isHit;
		}
		
		/**
		 * Returns the boolean value assign to the isSunk field
		 * @return
		 */
		public boolean getIsSunk()
		{
			return isSunk;
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
