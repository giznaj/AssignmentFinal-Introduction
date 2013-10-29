import java.util.ArrayList;

/** Description of GameBoard.java
 * Application generates an array of 64 "coordinates" on a 'BattleShip' game board. The board consists of 
 * 8 rows and 8 columns.  The original game was a 10 by 10 square.  There are no duplicates in the array.
 * Assignment #4
 *
 * @author Aaron Toth
 */
public class GameBoard 
{	
	/**
	 * Main method() for this class.  Instantiates this.class
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		GameBoard BattleBegins = new GameBoard();
		BattleBegins.buildTheBoard();
		BattleBegins.displayTheBoard();
	}

	/**
	 * Default constructor for the Class.
	 */
	public GameBoard() 
	{
		// not used
	}
	
	/**
	 * Method that creates and displays the array of Card objects.
	 * This method is invoked from the War3 class.
	 */
	public void buildTheBoard()
	{	
		 = new ArrayList<Card>(64);
		for(totalCardSuits = 0; totalCardSuits < 4; ++totalCardSuits) //suits
		{
			for(totalCardNumbers = 0; totalCardNumbers < 13; ++totalCardNumbers) //numbers
			{
				Card TempCard = new Card(totalCardSuits, totalCardNumbers);
				deckOfCards.add(TempCard);
			}
		}
	}
	
	/**
	 * Method that displays the array of Card objects
	 */
	public void displayTheBoard()
	{
		System.out.println("BattleShip Board");
		System.out.println("=====================");
		for(int x = 0; x < 52; ++x)
		{
			System.out.println("Card " + (x + 1) + " : " + deckOfCards.get(x).getCardNum() + " of " + deckOfCards.get(x).getCardSuit());
		}
	} 
}
