import java.util.Scanner;

/** Description of BattleShip.java
 * Battleship is a guessing game for two players. It is known worldwide as a pencil and paper game which dates 
 * from World War I. It was published by various companies as a pad-and-pencil game in the 1930s, and was 
 * released as a plastic board game by Milton Bradley in 1967.
 * Assignment #4
 *
 * @author Aaron Toth
 */
public class BattleShip
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String playerName;
		Scanner kb = new Scanner(System.in);
		System.out.println("Your name please?");
		playerName = kb.next();
		System.out.println("Welcome " + playerName);
		
		GameBoard newGame = new GameBoard();
	}
}
