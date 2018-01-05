public class Split
{
	private Card[] hand = new Card[11];
	private int numCards;
	private boolean done;
	private double balance;
	private double bet;


	public Split(Card x,int player)
	{
		this.emptyHand();
		this.hand[0] = x;
		numCards++;
	}

	public void emptyHand()
	{
		for (int i = 0; i<11; i++)
		{
			this.hand[i] = null;
		}
		this.numCards = 0;
	}








}