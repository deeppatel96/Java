// This class represents the set of cards held by one player (or the dealer).
public class Hand
{
	private Card[] hand;
	private int numCards;

	// This constructor builds a hand (with no cards, initially).
	public Hand()
	{
		hand = new Card[11];
		numCards = 0;
	}
	
	// This method retrieves the size of this hand.
	public int getNumberOfCards()
	{
		return numCards;
	}

	// This method retrieves a particular card in this hand.  The card number is zero-based.
	public Card getCard(int index)
	{
		return hand[index];
	}

	// This method takes a card and places it into this hand.
	public void addCard(Card newcard)
	{
		this.hand[this.numCards] = newcard;
		numCards++;
	}

	// This method computes the score of this hand.
	public int getScore()
	{
		int handSum = 0;
		int cardNum;
		int numAce = 0;

		for (int i = 0; i<numCards;i++)
		{
			cardNum = hand[i].getFace();

			if (cardNum == 1)
			{
				numAce++;
				handSum+=11;
			}
			else if (cardNum > 10)
			{
				handSum+=10;
			}
			else
			{
				handSum+=cardNum;
			}
		}

		while (handSum > 21 && numAce > 0)
		{
			handSum -= 10;
			numAce--;
		}

		return handSum;	
	}

	// This methods discards all cards in this hand.
	public void discardAll()
	{
		for (int i = 0; i<11; i++)
		{
			this.hand[i] = null;
		}
		this.numCards = 0;	}
}









