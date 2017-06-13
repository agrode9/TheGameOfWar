import java.util.*;

public class War {
	static ArrayList<Card> playerOne = null;
	static ArrayList<Card> playerTwo = null;

	public static void main( String[ ] args){
		startGame();

		printStart();

		Scanner input = new Scanner(System.in);
		while(playerOne.size() != 0 && playerTwo.size() != 0)
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


			System.out.print("Nate's line of code");

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
		System.out.println("Player One's deck size : " + playerOne.size());
		System.out.println("Player Two's deck size : " + playerTwo.size());
	}

	/**
	 *   This method initiates the game and makes the player decks
	 */
	public static void startGame()
	{
		//could also do this by making a card object and having the char be the displayed card…That would be easy. Make a field called value too and the value would be an int to do the comparisons.

		ArrayList<Card> deck = createCards();

		ArrayList<Card> p1 = new ArrayList<Card>();
		ArrayList<Card> p2 = new ArrayList<Card>();

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




		playerOne = p1;
		playerTwo = p2;
	}

	public static ArrayList<Card> createCards()
	{
		ArrayList<Card> list = new ArrayList<Card>();
		for(int j = 0; j < 8; j++)
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



}
