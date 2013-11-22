/**Description of Player.java
 * Represents the either the 'Player' or the 'Computer' in the game of BattleShip 
 * Assignment #4
 *
 * @author Aaron Toth
 */
	public class Player
	{
		/**
		 * String that represents the name of the player in the game (i.e. player: Aaron / computer: HAL)
		 */
		private String player;
		
		/**
		 * Boolean value that represents the task of placing ships on the board.  When shipsPlaced = 2, boolean = true 
		 */
		private boolean finishPlaceShips;
		
		/**
		 * int represents the number of ships that the user has placed on his/her board.
		 */
		private int numOfShipsPlaced;
		
		/**
		 * Constructor : Overloaded constructor for the class that takes a String as a parameter
		 */
		public Player(String player)
		{
			this.player = player;
			this.numOfShipsPlaced = 0;
		}
		
		/**
		 * Method returns the player to the invoking method
		 * @return
		 */
		public String getPlayer()
		{
			return player;
		}
	}
