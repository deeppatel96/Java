// This class represents one blackjack player (or the dealer)
public class Player
{
	private String name;
	private Hand hand;
	private boolean isDealer;

	// This constructor creates a player.
	// If isDealer is true, this Player object represents the dealer.
	public Player(String playerName, boolean isDealer)
	{
		this.name = playerName;
		hand = new Hand();
		this.isDealer = isDealer;
	}
		
	// This method retrieves the player's name.
	public String getName()
	{
		return this.name;
	}

	// This method retrieves the player's hand of cards.
	public Hand getHand()
	{
		return this.hand;
	}
	
	// This method deals two cards to the player (one face down if this is the dealer).
	// The window input should be used to redraw the window whenever a card is dealt.
	public void startRound(Deck deck, BlackjackWindow window)
	{
		if (this.isDealer)
		{
			hand.addCard(deck.drawCard());
			hand.getCard(hand.getNumberOfCards()-1).turnFaceDown();
			window.redraw();
			hand.addCard(deck.drawCard());
			hand.getCard(hand.getNumberOfCards()-1).turnFaceUp();
			window.redraw();
		}
		else
		{
			hand.addCard(deck.drawCard());
			hand.getCard(hand.getNumberOfCards()-1).turnFaceUp();
			window.redraw();
			hand.addCard(deck.drawCard());
			hand.getCard(hand.getNumberOfCards()-1).turnFaceUp();
			window.redraw();
		}

	}

	// This method executes gameplay for one player.
	// If this player is the dealer:
	//	- hits until score is at least 17
	// If this is an ordinary player:
	//	- repeatedly asks the user if they want to hit (draw another card)
	//	  until either the player wants to stand (not take any more cards) or
	//	  his/her score exceeds 21 (busts).
	// The window input should be used to redraw the window whenever a card is dealt or turned over.
	public void playRound(Deck deck, BlackjackWindow window)
	{

		if(this.isDealer)
		{
			this.hand.getCard(0).turnFaceUp();
			window.redraw();

			while (hand.getScore() < 17)
			{
				GIO.displayMessage("The Dealer Hits...");

				this.hand.addCard(deck.drawCard());
				this.hand.getCard(hand.getNumberOfCards()-1).turnFaceUp();
				window.redraw();
			}
		}
		else
		{
			boolean go = true;
			while (hand.getScore() < 21 && go)
			{
				go = GIO.readBoolean(this.name+": Do you want to HIT (Yes) or STAND (No)?");
				if (go)
				{
					this.hand.addCard(deck.drawCard());
					this.hand.getCard(hand.getNumberOfCards()-1).turnFaceUp();
					window.redraw();
				}
			}
		}

	}

	// This method informs the player about whether they won, lost, or pushed.
	// It also discards the player's cards to prepare for the next round.
	// The window input should be used to redraw the window after cards are discarded.

	public void finishRound(int dealerScore, BlackjackWindow window)
	{
		if (!isDealer)
		{
			if (hand.getScore() <=21 && dealerScore > 21)
			{
				GIO.displayMessage(this.name+": You won this round!");
			}
			else if (hand.getScore() <=21 && dealerScore <= 21 && hand.getScore() > dealerScore)
			{
				GIO.displayMessage(this.name+": You won this round!");
			}
			else if (hand.getScore() > 21)
			{
				GIO.displayMessage(this.name+": You lost this round!");
			}
			else if (hand.getScore() <=21 && dealerScore <= 21 && hand.getScore() < dealerScore)
			{
				GIO.displayMessage(this.name+": You lost this round!");
			}
			else if (hand.getScore() <=21 && dealerScore <= 21 && hand.getScore() == dealerScore)
			{
				GIO.displayMessage(this.name+": You pushed this round!");
			}

			this.hand.discardAll();
			window.redraw();
		}
		else
		{
			this.hand.discardAll();
			window.redraw();	
		}

	}
}













