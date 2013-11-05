/** Description of Ship.java
 * Represents the different ships and vessels one can use in the popular 
 * game of "BattleShip".
 * Assignment #4
 *
 * @author Aaron Toth
 */
	public class Ship
	{
		/**
		 * String that represents the ship type (i.e. submarine)
		 */
		private String shipType;
		
		/**
		 * number (int) that represents how many coordinates the ship occupies on the board
		 */
		private int shipLength;
		
	    /**
	     * Default constructor for the Card class
	     */
		public Ship()
		{
			shipType = "battleship";
			shipLength = 4;
		}
		
		/**
		 * Overloaded constructor for the ship class
		 * @param shipType
		 * @param shipLength
		 */
		public void Card(String shipType, int shipLength)
		{	
			this.shipType = shipType;
			this.shipLength = shipLength;
		}
		
		
		/**
		 * Method returns the ship's type (shipType) the invoking method
		 * @return
		 */
		public String getShipType()
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
	}