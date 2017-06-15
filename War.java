import java.util.*;

public class War {
	static List<Card> playerOneHand = null;
	static List<Card> playerTwoHand = null;
	static ArrayList<Card> playerOneFacedownCards  = new ArrayList<Card>();
	static ArrayList<Card> playerTwoFacedownCards  = new ArrayList<Card>();

	public static void main( String[ ] args){
		startGame();

		printStart();

		Scanner input = new Scanner(System.in);
		while(playerOneHand.size() != 0 && playerTwoHand.size() != 0)
		{


			/**
			 * So. Unable to read in P and Q without the users hitting the enter key
			 * and that just seems silly. I am thinking we could easily make a menu
			 * that had options like:
			 * 	1) Play next cards
			 * 	2) display counts of deck
			 * 	3) quit
			 * Though this would work, definitely not as interactive or fun...
			 */
			getInput("Player One's card: ");
			getInput("Player Two's card: ");

		Card playerOneCardLaid = playerOneHand.remove(0);
		Card playerTwoCardLaid = playerTwoHand.remove(0);

		if(playerOneCardLaid.getValue() > playerTwoCardLaid.getValue())
		{
			playerOneHand.add(playerOneCardLaid);
			playerOneHand.add(playerTwoCardLaid);
		}
		else if(playerOneCardLaid.getValue() < playerTwoCardLaid.getValue())
		{
			playerTwoHand.add(playerOneCardLaid);
			playerTwoHand.add(playerTwoCardLaid);
		}
		else
		{
			warHandler(playerOneCardLaid,playerTwoCardLaid);
		}


		}
	}
	/**
	 * This method pulls in user input.
	 */
	public static void getInput(String message)
	{

	}

	/**
	 * This prints the intro to the game.
	 */
	public static void printStart()
	{
		System.out.println("Welcome to the game of War");
		System.out.println("--------------------------");

		System.out.println("Player One: hit Q to show your card.");
		System.out.println("Player Two: hit P to show your card.");
		System.out.println("--------------------------");
		printDeckSizes();
		System.out.println("--------------------------");
	}
	public static void printDeckSizes()
	{
		System.out.println("Player One's deck size : " + playerOneHand.size());
		System.out.println("Player Two's deck size : " + playerTwoHand.size());
	}

/*
	This ends the game
*/
	public static void gameOver()
	{
		System.out.println("GAME OVER");
	}

	/**
	 *   This method initiates the game and makes the player decks
	 */
	public static void startGame()
	{
		//could also do this by making a card object and having the char be the displayed card…That would be easy. Make a field called value too and the value would be an int to do the comparisons.

		ArrayList<Card> deck = createCards();

		//shuffles the main deck


		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		int initialSize = deck.size();

		Random rand = new Random();

		for (int i = 0; i < initialSize; i++)
		{
			int index = rand.nextInt(deck.size());
			shuffledDeck.add(deck.get(index));
			deck.remove(index);
		}


		//       Collections.shuffle(shuffledDeck);
		//now we need to split the shuffled deck and assign it t0 p1 and p2

		playerOneHand = shuffledDeck.subList(0,26); // First 26 cards assigned to Player 1 (Needs to be tested)
		playerTwoHand = shuffledDeck.subList(26,52); // Last 26 cards assigned to Player 2 (Needs to be tested)

	}

	public static ArrayList<Card> createCards()
	{
		ArrayList<Card> list = new ArrayList<Card>();
		for(int j = 2; j < 11; j++)
		{
			for(int i = 0; i < 4; i++)
			{
				list.add(new Card(Integer.toString(j), j));
			}
		}
		ArrayList<String> unique = new ArrayList<String>();
		unique.add("J");
		unique.add("Q");
		unique.add("K");
		unique.add("A");
		int uniqueIndex = 0;
		for(int i = 11; i < 15; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				list.add(new Card(unique.get(uniqueIndex), i));
			}
			uniqueIndex++;
		}
		/*
                This is the old way we did it. Not sure the new way will work.
        list.add(new Card(“J”, 11);
        list.add(new Card(“J”, 11);
        list.add(new Card(“J”, 11);
        list.add(new Card(“J”, 11);

        list.add(new Card(“Q”, 12);
        list.add(new Card(“Q”, 12);
        list.add(new Card(“Q”, 12);
        list.add(new Card(“Q”, 12);

        list.add(new Card(“K”, 13);
        list.add(new Card(“K”, 13);
        list.add(new Card(“K”, 13);
        list.add(new Card(“K”, 13);

        list.add(new Card(“A”, 14);
        list.add(new Card(“A”, 14);
        list.add(new Card(“A”, 14);
        list.add(new Card(“A”, 14);
		 */
		return list;
	}



		/*
		*	This recursive method calculates all war possibilities.
		*	If player doesn't have 4 cartds for war, then they play their last card as the face up card.
		*	If a player has war on their last card in their had, that player loses.
		*
		*/
		public static void warHandler(Card playerOneCardLaid, Card playerTwoCardLaid)
		{
			Card playerOneWarCard = null;
			Card playerTwoWarCard = null;

			playerOneFacedownCards.add(playerOneCardLaid);
			playerTwoFacedownCards.add(playerTwoCardLaid);

			//Check to see if any player has no cards remaining
			if(playerOneHand.isEmpty() || playerTwoHand.isEmpty())
			{
				gameOver();
				return;
			}
			//Player One lays down rest of hand and turns last card up
			if (playerOneHand.size() < 5)
			{
				playerOneWarCard = playerOneHand.remove(playerOneHand.size() - 1);
				playerOneFacedownCards.addAll(playerOneHand);
				playerOneHand.clear();
			}

			//Player Two lays down rest of hand and turns last card up
			if (playerTwoHand.size() < 5)
			{
				playerTwoWarCard = playerTwoHand.remove(playerTwoHand.size() - 1);
				playerTwoFacedownCards.addAll(playerTwoHand);
				playerTwoHand.clear();
			}

			if(playerOneWarCard == null)
			{
				playerOneFacedownCards.add(playerOneHand.remove(0));
				playerOneFacedownCards.add(playerOneHand.remove(0));
				playerOneFacedownCards.add(playerOneHand.remove(0));
				playerOneWarCard = playerOneHand.remove(0);
			}

			if(playerTwoWarCard == null)
			{
				playerTwoFacedownCards.add(playerTwoHand.remove(0));
				playerTwoFacedownCards.add(playerTwoHand.remove(0));
				playerTwoFacedownCards.add(playerTwoHand.remove(0));
				playerTwoWarCard = playerTwoHand.remove(0);
			}
			//If the 2 compared cards are equal, call warHandler(cardone, cardtwo);
			//RECURSIVE CASE
			if(playerTwoWarCard.getValue() == playerOneWarCard.getValue())
			{
				warHandler(playerOneWarCard, playerTwoWarCard);
			}
			//else we now compare whose card is bigger
			else if(playerTwoWarCard.getValue() > playerOneWarCard.getValue())
			{
				//add all the cards to player two
				playerTwoHand.addAll(playerOneFacedownCards);
				playerTwoHand.addAll(playerTwoFacedownCards);
			}
			else
			{
				//playerOne should get all the cards
				playerOneHand.addAll(playerOneFacedownCards);
				playerOneHand.addAll(playerTwoFacedownCards);
			}
			//clear the war cards for next war
			playerOneFacedownCards.clear();
			playerTwoFacedownCards.clear();


		}

}
