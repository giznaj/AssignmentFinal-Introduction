/**Description of Ship.java
 * Represents the different ships and vessels one can use in the popular 
 * game of "BattleShip".
 * Assignment #4
 *
 * @author Aaron Toth
 */
	public class Ship
	{
		/**
		 * number (int) that represents the ship type (i.e. 0 for destroyer, 1 for submarine)
		 */
		private int shipType;
		
		/**
		 * number (int) that represents how many coordinates the ship occupies on the board
		 */
		private int shipLength;
		
		/**
		 * Boolean value for the ship's 'Sunk' status. (if the ship is sunk, isSunk = true)
		 */
		private boolean isSunk;
		
		/**
		 * Boolean value for the ship's 'Hit' status.  (if the ship is hit, isHit = true)
		 */
		private boolean isHit;
		
		/**
		 * Overloaded constructor for the ship class
		 * @param shipType
		 */
		public Ship(int shipType)
		{	
			this.shipType = shipType;
			isHit = false;
			isSunk = false;
			
			if(shipType == 0)
			{
				this.shipLength = 1;
			}
			else if(shipType == 1)
			{
				this.shipLength = 2;
			}
			
			else
			{
				System.out.println("That is not a valid shipType");
			}
		}
		
		/**
		 * Sets the 'isHit' boolean expression to 'true' upon the first hit of the ship
		 */
		public void setIsHit()
		{
			isHit = true;
		}
		
		/**
		 * Sets the 'isHit' boolean expression to 'true' upon the 
		 */
		public void setIsSunk()
		{
			isHit = true;
		}
		
		/**
		 * Method returns the ship's type (shipType) the invoking method
		 * @return
		 */
		public int getShipType()
		{
			return shipType;
		}
		
		/**
		 * Method returns the ship's length (shipLength) the invoking method
		 * @return
		 */
		public int getShipLength()
		{
			return shipLength;
		}
		
		/**
		 * Method returns the ships 'isSunk' status to the calling method
		 * @return
		 */
		public boolean getIsSunk()
		{
			return isSunk;
		}
		
		/**
		 * Method returns the ships 'isHit' status t othe calling method
		 * @return
		 */
		public boolean getIsHit()
		{
			return isHit;
		}
	}