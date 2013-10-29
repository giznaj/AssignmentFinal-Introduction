/** Description of Player.java
 * Represents the either the 'Player' or the 'Computer' in the game of BattleShip 
 * Assignenment #4
 *
 * @author Aaron Toth
 */
	public class Player
	{
		/**
		 * String that represents the player in the game (i.e. player or computer)
		 */
		private String player;
		
		/**
		 * Default constructor for the class
		 */
		public void Player(String player)
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
