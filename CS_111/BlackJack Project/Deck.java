import java.util.Random;

// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{

	public Card[] myCards; // Array of cards
	public int numCards;     // Number of cards currently in deck
	
	
	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		myCards = new Card[52];
		numCards = 52;

		int i = 0;
		for (int s = 0; s < 4; s++){
			for (int n = 1; n <= 13; n++){
				myCards[i] = new Card(s,n);
				i++;
			}
		}

		shuffle();
		shuffle();
		shuffle();
		shuffle();
		shuffle();
		shuffle();
	}

	// This method shuffles the deck (randomizes the array of cards).
	// Hint: loop over the cards and swap each one with another card in a random position.
	public void shuffle()
	{
		
		Random rand = new Random();
		Card temp;
		int j;
		int k = 0;
		while(k<5){
			for(int i = 0; i < numCards; i++){

				j = rand.nextInt(numCards);

				temp = myCards[i];
				myCards[i] = myCards[j];
				myCards[j] = temp;
			}
		k++;
		}

	}
	
	// This method takes the top card off the deck and returns it.
	public Card drawCard()
	{
		Card top = myCards[0];
		
		for(int i = 1; i < numCards; i++){
			myCards[i-1] = myCards[i];
		}

		myCards[numCards-1] = null;
		numCards--;

		return top;

	}
	
	// This method returns the number of cards left in the deck.
	public int getSize()
	{
		return numCards;
	}
}

