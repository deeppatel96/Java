public class Blackjack{
	

	public static void main(String[] args)
	{

	//	- Ask the user how many people want to play (up to 3, not including the dealer).
		System.out.println("Welcome to BlackJack! How many players would like to play? (Up to 3)");
		int numPlayers = IO.readInt();
		System.out.println();

		while (numPlayers<1 || numPlayers>3)
		{
			IO.reportBadInput();
			System.out.println("Please enter a number between 1 and 3:");
			numPlayers = IO.readInt();
		}

	//	- Create an array of players.
		Player[] players = new Player[numPlayers+1];
		String playerName;
		double balance;
		boolean error = true;
		players[0] = new Player("Dealer",true);
		for (int i = 1;i<=numPlayers;i++)
		{
			System.out.println("Enter the name for Player "+i+":");																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																	
			playerName = IO.readString();

			players[i] = new Player(playerName,false);
			System.out.println();
		}

	//	- Create a Blackjack window.
		BlackjackWindow window = new BlackjackWindow(players);

	// 	- Play rounds until the players want to quit the game.
		boolean keepGoing = true;
		while(keepGoing)
		{
			Blackjack.playRound(players,window);

			keepGoing = GIO.readBoolean("Does everybody want to continue playing?");
		}
		window.close();
	}



	// This method executes an single round of play (for all players).
	public static void playRound(Player[] players, BlackjackWindow window)
	{
		int numPlayers = players.length - 1;
	//	- Create and shuffle a deck of cards.
		Deck deck = new Deck();

		
	//	- Start the round (deal cards) for each player, then the dealer.
		for (int i = 1; i<=numPlayers; i++)
		{
			players[i].startRound(deck,window);
		}
		players[0].startRound(deck,window);


	//	- Allow each player to play, then the dealer.
		for (int i = 1; i<=numPlayers; i++)
		{
			players[i].playRound(deck,window);
		}
		players[0].playRound(deck,window);


	//	- Finish the round (announce results) for each player.
		for (int i = 1; i<=numPlayers; i++)
		{
			players[i].finishRound(players[0].getHand().getScore(),window);
		}
		players[0].finishRound(players[0].getHand().getScore(),window);

	}


}