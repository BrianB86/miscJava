package simplebattleship;

import java.util.*;

public class BattleShipGame {

	// declare and initialize the variables we will need.

	private GameHelper helper = new GameHelper();
	private ArrayList<BattleShip> shipList = new ArrayList<BattleShip>();
	private int numOfGuesses = 0;

	private void setUpGame() {
		// first make some ships and give them locations.
		// make three BattleShip objects, give them names and stick them in the
		// ArrayList.

		BattleShip one = new BattleShip();
		one.setName("Sub");
		BattleShip two = new BattleShip();
		two.setName("Boat");
		BattleShip three = new BattleShip();
		three.setName("Frigate");
		shipList.add(one);
		shipList.add(two);
		shipList.add(three);

		// print brief instructions for user.

		System.out
				.println("You must sink all three machines of war to ensure your survival!");
		System.out.println("The lower number of guesses the better: guess a-g 0-7 ie: a1 or d0 ");

		for (BattleShip battleShipToSet : shipList) { // repeat with each
														// BattleShip in the
														// list.
			ArrayList<String> newLocation = helper.placeBattleShip(3); // ask
																		// the
																		// helper
																		// for a
																		// Battleship
																		// location.
			battleShipToSet.setLocationCells(newLocation); // call the setter
															// method on this
															// Battleship to
															// give it the
															// location you just
															// got from the
															// helper.
		}
	}

	private void startPlaying() {
		while (!shipList.isEmpty()) { // as long as the shipList is NOT empty
			String userGuess = helper.getUserInput("Enter a guess: "); // get
																		// user
																		// input.
			checkUserGuess(userGuess); // call our own checkUserGuess method
		}
		finishGame(); // call our own finishGame method;
	}

	private void checkUserGuess(String userGuess) {
		numOfGuesses++; // increment the number of guesses the user has made
		String result = "miss"; // assume it's a 'miss', unless told otherwise

		for (BattleShip battleShipToTest : shipList) { // repeat with all
														// BattleShips in the
														// list.
			result = battleShipToTest.checkYourself(userGuess); // ask the
																// BattleShip to
																// check the
																// user guess,
																// looking for a
																// hit.
			if (result.equals("hit")) {
				break; // get out of the loop early no point in testing the
						// others
			}
			if (result.equals("kill")) {
				shipList.remove(battleShipToTest); // this guy's dead, so take
													// him out of the
													// BattleShips list then
													// geto ut of the loop.
				break;
			}
		}
		System.out.println(result); // print the result for the user.
	}

	private void finishGame() {
		// print a message telling the user how he did in the game.
		System.out.println("You have saved the sea from war!!!");
		if (numOfGuesses <= 44) {
			System.out
					.println("It only took you " + numOfGuesses + " guesses.");
			System.out
					.println(" You are the champion of sea warfare. JOIN THE NAVY!!!");
		} else {
			System.out.println("You took " + numOfGuesses + "guesses");
			System.out
					.println("You took too many shots and killed too many innocent fish.");
			System.out
					.println("PETA found you an slit your throat, GAME OVER.....loser");
		}
	}

	public static void main(String[] args) {
		BattleShipGame game = new BattleShipGame(); // create the game object
		game.setUpGame(); // tell the game object to set up the game.
		game.startPlaying(); // tell the game object to start the main game play
								// loop.
	}

}
