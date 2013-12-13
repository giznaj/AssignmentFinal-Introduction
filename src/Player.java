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
		 * Constructor : Overloaded constructor for the class that takes a String as a parameter
		 */
		public Player(String player)
		{
			this.player = player;
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
